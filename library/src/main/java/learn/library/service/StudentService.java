package learn.library.service;

import learn.library.Repository.StudentRepository;
import learn.library.excentionhandler.AlreadyExcention;
import learn.library.excentionhandler.NotFountException;
import learn.library.model.StudentEntity;
import learn.library.model.StudentRequest;
import learn.library.model.StudentResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // Create
    public StudentEntity createStudent(StudentRequest studentRequest) throws Exception {
        StudentEntity data = studentRequest.toEntity();
        if (this.studentRepository.existsByName(studentRequest.getName())) {
            throw new AlreadyExcention("Name Already Exists");
        }
        try {
            return studentRepository.save(data);
        }catch (Exception ex){
            throw  new Exception(ex);
        }
    }
    // Find All
    public List<StudentEntity> findAll(){
        return  this.studentRepository.findAll();
    }
    // Update
    public StudentEntity upDate(Long id,StudentRequest studentRequest) throws Exception {
        StudentEntity data = this.studentRepository.findById(id).orElseThrow(()->new NotFountException("Student Not Found"));
        data.setName(studentRequest.getName());
        data.setAge(studentRequest.getAge());
        data.setGender(studentRequest.getGender());
        data.setKhmerName(studentRequest.getKhmerName());
        try {
            return studentRepository.save(data);
        }catch (Exception ex){
            throw  new Exception(ex);
        }
    }
    // Delete
    public StudentEntity DeleteStudent(Long id) throws Exception {
        StudentEntity data = this.studentRepository.findById(id).orElseThrow(()->new NotFountException("Student Not Found"));
        this.studentRepository.delete(data);
        try {
            return data;
        }catch (Exception ex){
            throw  new Exception(ex);
        }
    }
    // Get BY id
    public StudentEntity findByID(Long id) throws Exception {
        StudentEntity data = this.studentRepository.findById(id).orElseThrow(()->new NotFountException("Student Not Found"));
        try {
            return data;
        }catch (Exception ex){
            throw  new Exception(ex);
        }
    }
}
