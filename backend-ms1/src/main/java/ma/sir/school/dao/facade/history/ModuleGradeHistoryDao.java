package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.ModuleGradeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleGradeHistoryDao extends AbstractHistoryRepository<ModuleGradeHistory,Long> {

}
