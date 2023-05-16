package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.ExamGradeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamGradeHistoryDao extends AbstractHistoryRepository<ExamGradeHistory,Long> {

}
