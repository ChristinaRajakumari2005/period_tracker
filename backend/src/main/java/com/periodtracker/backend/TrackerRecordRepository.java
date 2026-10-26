package com.periodtracker.backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRecordRepository extends JpaRepository<TrackerRecord, Integer> {
}