package learn.library.service;

import learn.library.Repository.StudentRepository;
import learn.library.excentionhandler.AlreadyExcention;
import learn.library.model.StudentEntity;
import learn.library.model.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
