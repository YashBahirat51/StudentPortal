package com.app.controller;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Admin;
import com.app.entities.Attendance;
import com.app.entities.DailyAttendanceSheet;
import com.app.entities.Faculty;
import com.app.entities.Notice;
import com.app.entities.Student;
import com.app.service.AdminService;
import com.app.service.AttendanceService;
import com.app.service.DailyAttendanceSheetService;
import com.app.service.FacultyService;
import com.app.service.NoticeService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private DailyAttendanceSheetService dailyAttendanceSheetService;
    @Autowired
    private NoticeService noticeService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin admin) {
        Admin existingAdmin = adminService.getAdminByEmail(admin.getEmail());
        if (existingAdmin != null && existingAdmin.getPassword().equals(admin.getPassword())) {
            // In a real application, generate a token and return it
            return ResponseEntity.ok("Login successful"); // Placeholder response
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
    
    @PostMapping("/post-notice")
    public ResponseEntity<Notice> postNotice(@RequestBody Notice notice) {
        Notice savedNotice = noticeService.saveNotice(notice);
        return ResponseEntity.ok(savedNotice);
    }

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return ResponseEntity.ok(notices);
    }
    @PostMapping("/mark-attendance")
    public ResponseEntity<DailyAttendanceSheet> markAttendance(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody List<Attendance> attendances) {
        List<Attendance> savedAttendances = attendanceService.saveAllAttendances(attendances);
        DailyAttendanceSheet dailySheet = dailyAttendanceSheetService.createOrUpdateDailySheet(date, savedAttendances);
        return ResponseEntity.ok(dailySheet);
    }
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(savedAdmin);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
        Admin admin = adminService.getAdminByEmail(email);
        return ResponseEntity.ok(admin);
    }

    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PostMapping("/add-faculty")
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.ok(savedFaculty);
    }
    
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}