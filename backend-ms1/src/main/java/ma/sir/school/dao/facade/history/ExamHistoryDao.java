package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.ExamHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamHistoryDao extends AbstractHistoryRepository<ExamHistory,Long> {

}
