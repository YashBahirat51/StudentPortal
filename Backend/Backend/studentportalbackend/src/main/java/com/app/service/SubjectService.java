package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.SubjectRepository;
import com.app.entities.Subject;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

  

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }


    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

}