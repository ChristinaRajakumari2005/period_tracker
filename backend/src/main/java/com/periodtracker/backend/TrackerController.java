package com.periodtracker.backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*")
public class TrackerController {

    private final TrackerRecordRepository repo;

    public TrackerController(TrackerRecordRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/api/track")
    public TrackerRecord track(@RequestBody TrackerRecord r) {

        if (r.getName() == null || r.getName().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
        if (r.getAge() == null || r.getAge() < 10 || r.getAge() > 60)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter a valid age");
        if (r.getLastPeriodDate() == null || r.getLastPeriodDate().isAfter(LocalDate.now()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter a valid past date");

        LocalDate last = r.getLastPeriodDate();
        r.setNextPeriodDate(last.plusDays(28));    // cycle length 28
        r.setOvulationStart(last.plusDays(7));     // period 5 + 2
        r.setOvulationEnd(last.plusDays(11));      // period 5 + 6

        return repo.save(r);
    }
}