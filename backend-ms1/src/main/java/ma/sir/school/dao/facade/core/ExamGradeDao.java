package ma.sir.school.dao.facade.core;

import ma.sir.school.zynerator.repository.AbstractRepository;
import ma.sir.school.bean.core.ExamGrade;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ExamGradeDao extends AbstractRepository<ExamGrade,Long>  {

    List<ExamGrade> findByExamId(Long id);
    int deleteByExamId(Long id);
    List<ExamGrade> findByStudentId(Long id);
    int deleteByStudentId(Long id);

}
