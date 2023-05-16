package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.TrainingHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingHistoryDao extends AbstractHistoryRepository<TrainingHistory,Long> {

}
