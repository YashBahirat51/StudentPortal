package com.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FacultyRepository;
import com.app.entities.Faculty;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyByEmail(String email) {
        return facultyRepository.findByEmail(email);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
    public Faculty login(String email, String password) {
        Faculty faculty = facultyRepository.findByEmail(email);
        if (faculty != null && faculty.getPassword().equals(password)) {
            return faculty;
        }
        return null;
    }
}