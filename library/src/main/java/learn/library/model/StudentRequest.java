package learn.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String khmerName;
    private int age;
    private String gender;
    public StudentEntity toEntity() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setKhmerName(khmerName);
        studentEntity.setAge(age);
        studentEntity.setGender(gender);
        return studentEntity;
    }
}
