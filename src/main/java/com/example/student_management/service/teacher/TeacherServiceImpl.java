package com.example.student_management.service.teacher;

import com.example.student_management.dto.TeacherDto;
import com.example.student_management.model.Teacher;
import com.example.student_management.model.User;
import com.example.student_management.repository.TeacherRepository;
import com.example.student_management.repository.UserRepo;
import com.example.student_management.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public GeneralResponse addTeacher(Long userId, TeacherDto teacherDto) {
        GeneralResponse response = new GeneralResponse();
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()){
            Teacher teacher = new Teacher();
            teacher.setName(teacherDto.getName());
            teacher.setDepartment(teacherDto.getDepartment());
            teacher.setUser(optionalUser.get());
            teacherRepository.save(teacher);
            response.setStatus(HttpStatus.CREATED);
            response.setMessage("Teacher is created.");
        } else {
            response.setMessage("User not exist");
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
