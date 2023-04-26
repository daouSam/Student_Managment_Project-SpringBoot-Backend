package com.example.student_management.controller;

import com.example.student_management.dto.TeacherDto;
import com.example.student_management.response.GeneralResponse;
import com.example.student_management.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping("/teacher/{userId}")
    public GeneralResponse addTeacher(@RequestBody TeacherDto teacherDto, @PathVariable Long userId){
        GeneralResponse response = new GeneralResponse();
        try{
            return teacherService.addTeacher(userId,teacherDto);
        } catch (Exception e){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Something went wrong!");
        }
        return response;
    }

}
