package learn.library.controller;

import learn.library.model.StudentEntity;
import learn.library.model.StudentRequest;
import learn.library.model.StudentResponce;
import learn.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
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
    @GetMapping
    public ResponseEntity<List<StudentResponce>> findAllStudent(){
        List<StudentResponce>  data=this.studentService.findAll().stream().map(StudentResponce::fromEntity).toList();
        return ResponseEntity.ok(data);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponce> findStudentById(@PathVariable Long id) throws Exception {
        StudentEntity data = this.studentService.findByID(id);
        return ResponseEntity.ok(StudentResponce.fromEntity(data));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponce> updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) throws Exception {
        StudentEntity data = this.studentService.upDate(id, studentRequest);
        return ResponseEntity.ok(StudentResponce.fromEntity(data));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponce> deleteStudent(@PathVariable Long id) throws Exception {
        StudentEntity data = this.studentService.DeleteStudent(id);
        return ResponseEntity.ok(StudentResponce.fromEntity(data));
    }
}














