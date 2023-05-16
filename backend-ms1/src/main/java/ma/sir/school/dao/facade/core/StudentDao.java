package ma.sir.school.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.school.zynerator.repository.AbstractRepository;
import ma.sir.school.bean.core.Student;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StudentDao extends AbstractRepository<Student,Long>  {

    List<Student> findByTrainingId(Long id);
    int deleteByTrainingId(Long id);
    List<Student> findByDiplomaId(Long id);
    int deleteByDiplomaId(Long id);

    @Query("SELECT NEW Student(item.id,item.cin) FROM Student item")
    List<Student> findAllOptimized();
}
