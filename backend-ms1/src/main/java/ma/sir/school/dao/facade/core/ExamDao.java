package ma.sir.school.dao.facade.core;

import ma.sir.school.zynerator.repository.AbstractRepository;
import ma.sir.school.bean.core.Exam;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ExamDao extends AbstractRepository<Exam,Long>  {

    List<Exam> findByModuleId(Long id);
    int deleteByModuleId(Long id);
    List<Exam> findBySemesterId(Long id);
    int deleteBySemesterId(Long id);

}
