package com.periodtracker.backend;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tracker_records")
public class TrackerRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private LocalDate lastPeriodDate;
    private LocalDate nextPeriodDate;
    private LocalDate ovulationStart;
    private LocalDate ovulationEnd;

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public LocalDate getLastPeriodDate() { return lastPeriodDate; }
    public void setLastPeriodDate(LocalDate d) { this.lastPeriodDate = d; }
    public LocalDate getNextPeriodDate() { return nextPeriodDate; }
    public void setNextPeriodDate(LocalDate d) { this.nextPeriodDate = d; }
    public LocalDate getOvulationStart() { return ovulationStart; }
    public void setOvulationStart(LocalDate d) { this.ovulationStart = d; }
    public LocalDate getOvulationEnd() { return ovulationEnd; }
    public void setOvulationEnd(LocalDate d) { this.ovulationEnd = d; }
}