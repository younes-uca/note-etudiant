package ma.sir.school.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.school.zynerator.repository.AbstractRepository;
import ma.sir.school.bean.core.Semester;
import org.springframework.stereotype.Repository;
import ma.sir.school.bean.core.Semester;
import java.util.List;


@Repository
public interface SemesterDao extends AbstractRepository<Semester,Long>  {
    Semester findByCode(String code);
    int deleteByCode(String code);

    List<Semester> findByTrainingId(Long id);
    int deleteByTrainingId(Long id);

    @Query("SELECT NEW Semester(item.id,item.libelle) FROM Semester item")
    List<Semester> findAllOptimized();
}
