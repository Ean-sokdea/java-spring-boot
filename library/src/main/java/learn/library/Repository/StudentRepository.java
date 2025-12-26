package learn.library.Repository;

import learn.library.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    boolean existsByName(String name);
}