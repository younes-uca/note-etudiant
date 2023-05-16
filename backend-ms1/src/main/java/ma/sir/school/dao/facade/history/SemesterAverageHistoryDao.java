package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.SemesterAverageHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterAverageHistoryDao extends AbstractHistoryRepository<SemesterAverageHistory,Long> {

}
