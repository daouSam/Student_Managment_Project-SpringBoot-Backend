package com.example.student_management.service.teacher;

import com.example.student_management.dto.TeacherDto;
import com.example.student_management.response.GeneralResponse;

public interface TeacherService {
    GeneralResponse addTeacher(Long userId, TeacherDto teacherDto);
}
