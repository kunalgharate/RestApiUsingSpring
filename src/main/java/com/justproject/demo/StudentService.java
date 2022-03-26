package com.justproject.demo;

import com.justproject.demo.entities.Student;
import com.justproject.demo.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    List<Student> myList = new ArrayList();


    @Autowired
    private  final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents()
    {
      return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        final Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        final boolean b = studentRepository.existsById(id);
        if (!b)
        {
            throw new IllegalStateException("student with id"+id+ "doesn't exists");
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email)
    {
        Optional<Student> byId = studentRepository.findById(studentId);


       if (!byId.isPresent())
        {
            throw new IllegalStateException("Student not present ");
        }
       else if (!byId.orElseThrow(RuntimeException::new).getName().equalsIgnoreCase(name) && name.length()>0)
       {
           byId.orElseThrow(RuntimeException::new).setName(name);
       }
       else if (email!=null && email.length()>0)
       {
           Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
           if (studentByEmail.isPresent())
           {
               throw new IllegalStateException("Email Taken");
           }
           byId.orElseThrow(RuntimeException::new).setEmail(email);
       }



    }
}
