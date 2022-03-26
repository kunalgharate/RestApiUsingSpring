package com.justproject.demo.controller;


import com.justproject.demo.StudentService;
import com.justproject.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private List<Student> myList = new ArrayList<>();
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody  Student student)
    {
        studentService.addNewStudent(student);
    }

    @PostMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id)
    {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email)
    {
        studentService.updateStudent(studentId,name,email);
    }
}
