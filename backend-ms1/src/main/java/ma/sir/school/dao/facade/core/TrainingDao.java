package ma.sir.school.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.school.zynerator.repository.AbstractRepository;
import ma.sir.school.bean.core.Training;
import org.springframework.stereotype.Repository;
import ma.sir.school.bean.core.Training;
import java.util.List;


@Repository
public interface TrainingDao extends AbstractRepository<Training,Long>  {
    Training findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Training(item.id,item.libelle) FROM Training item")
    List<Training> findAllOptimized();
}
