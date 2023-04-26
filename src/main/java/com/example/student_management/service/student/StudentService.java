package com.example.student_management.service.student;


import com.example.student_management.dto.StudentDto;
import com.example.student_management.response.GeneralResponse;

public interface StudentService {
    GeneralResponse addStudent(StudentDto studentDto,Long userId);
}
