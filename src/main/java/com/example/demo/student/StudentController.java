package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService= studentService;
    }


    @GetMapping
    public List<Student> getstudents()
    {
            return studentService.getstudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentID)
    {
        studentService.deleteStudent(studentID);
    }
    @PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable("studentId") Long studentID,
                              @RequestParam(required = false) String name, @RequestParam(required = false) String email)
            {
        studentService.updateStudent(studentID,name,email);
    }


}
