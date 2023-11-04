package com.example.CrudAPI.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final ServiceStudent serviceStudent;

    @Autowired
    public StudentController(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    @GetMapping
    public List<Student> getStudents() {
        return serviceStudent.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        serviceStudent.addNewStudent(student);
    }

    //delete by id
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        serviceStudent.deleteStudent(studentId);
    }

    //update by id
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email) {
        serviceStudent.updateStudent(studentId, name, email);
    }
}
