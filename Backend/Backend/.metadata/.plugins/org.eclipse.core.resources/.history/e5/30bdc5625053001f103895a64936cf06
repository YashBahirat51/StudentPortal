package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TimetableRepository;
import com.app.entities.Timetable;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    public Timetable addTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    // Other methods for managing timetable
}
