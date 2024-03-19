package com.example.demo.checkDate;



// AttendanceController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/check-attendance")
    public String checkAttendance(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        LocalDate today = LocalDate.now();
        if (date.equals(today)) {
            List<Student> students = studentRepository.findAll();
            students.forEach(student -> student.setStudentAttendance(true));
            studentRepository.saveAll(students);
            return "Attendance updated successfully for all students.";
        } else {
            return "Attendance not updated. The provided date is not today.";
        }
    }
}
