package com.example.student_management.controller;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.response.GeneralResponse;
import com.example.student_management.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student/{userId}")
    public GeneralResponse addStudent(@RequestBody StudentDto studentDto, @PathVariable Long userId) {
        GeneralResponse response = new GeneralResponse();
        try {
            return studentService.addStudent(studentDto,userId);
        } catch (Exception e) {
            response.setMessage("Sorry something went wrong!");
            response.setStatus(HttpStatus.BAD_REQUEST);
        }
        return response;
    }


}
