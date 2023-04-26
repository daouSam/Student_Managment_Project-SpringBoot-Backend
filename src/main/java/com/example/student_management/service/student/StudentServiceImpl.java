package com.example.student_management.service.student;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.model.Student;
import com.example.student_management.model.User;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.repository.UserRepo;
import com.example.student_management.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepo userRepo;

    @Override
    public GeneralResponse addStudent(StudentDto studentDto, Long userId) {
        GeneralResponse response = new GeneralResponse();
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()){
            Student student = new Student();
            student.setName(studentDto.getName());
            student.setFatherName(studentDto.getFatherName());
            student.setMotherName(studentDto.getMotherName());
            student.setUser(optionalUser.get());
            studentRepository.save(student);
            response.setMessage("Student created.");
            response.setData(HttpStatus.CREATED);
        } else {
            response.setMessage("User not exist!");
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
