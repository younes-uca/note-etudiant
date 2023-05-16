package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.StudentHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentHistoryDao extends AbstractHistoryRepository<StudentHistory,Long> {

}
