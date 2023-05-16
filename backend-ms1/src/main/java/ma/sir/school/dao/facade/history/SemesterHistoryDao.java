package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.SemesterHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterHistoryDao extends AbstractHistoryRepository<SemesterHistory,Long> {

}
