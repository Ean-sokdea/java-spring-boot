package learn.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponce {
    private Long id;
    private String name;
    private String khmerName;
    private int age;
    private String gender;
    public static StudentResponce fromEntity(StudentEntity studentEntity) {
        return builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .khmerName(studentEntity.getKhmerName())
                .age(studentEntity.getAge())
                .gender(studentEntity.getGender())
                .build();
    }
}
