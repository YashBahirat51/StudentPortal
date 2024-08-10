package com.app.controller;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.entities.Assignment;
import com.app.entities.Faculty;
import com.app.service.AssignmentService;
import com.app.service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.saveFaculty(faculty));
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Faculty> getFacultyByEmail(@PathVariable String email) {
        return ResponseEntity.ok(facultyService.getFacultyByEmail(email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Faculty faculty) {
        Faculty existingfaculty = facultyService.getFacultyByEmail(faculty.getEmail());
        if (existingfaculty != null && existingfaculty.getPassword().equals(faculty.getPassword())) {
            // In a real application, generate a token and return it
            System.out.println("login succesfull");
        	return ResponseEntity.ok("Login successful"); // Placeholder response
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
    
    
    @PostMapping("/assignments")
    public ResponseEntity<Assignment> createAssignment(
            @RequestParam String name,
            @RequestParam String deadline,
            @RequestParam MultipartFile questionImage) throws IOException {

        Assignment assignment = new Assignment();
        assignment.setName(name);
        assignment.setDeadline(LocalDate.parse(deadline));
        assignment.setQuestionImage(questionImage.getBytes());

        Assignment savedAssignment = assignmentService.saveAssignment(assignment);

        return new ResponseEntity<>(savedAssignment, HttpStatus.CREATED);
    }
}
