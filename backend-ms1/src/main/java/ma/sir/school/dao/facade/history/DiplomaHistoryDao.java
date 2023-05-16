package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.DiplomaHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomaHistoryDao extends AbstractHistoryRepository<DiplomaHistory,Long> {

}
