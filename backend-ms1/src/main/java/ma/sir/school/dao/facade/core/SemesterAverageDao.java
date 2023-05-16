package ma.sir.school.dao.facade.core;

import ma.sir.school.zynerator.repository.AbstractRepository;
import ma.sir.school.bean.core.SemesterAverage;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SemesterAverageDao extends AbstractRepository<SemesterAverage,Long>  {

    List<SemesterAverage> findByStudentId(Long id);
    int deleteByStudentId(Long id);
    List<SemesterAverage> findBySemesterId(Long id);
    int deleteBySemesterId(Long id);

}
