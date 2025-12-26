package learn.library.controller;

import learn.library.model.StudentEntity;
import learn.library.model.StudentRequest;
import learn.library.model.StudentResponce;
import learn.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentResponce> createStudent(@RequestBody StudentRequest studentRequest) throws Exception {
        StudentEntity data = studentService.createStudent(studentRequest);
        return ResponseEntity.ok(StudentResponce.fromEntity(data));
    }

}
