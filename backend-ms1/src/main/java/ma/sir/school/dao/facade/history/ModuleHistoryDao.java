package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.ModuleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleHistoryDao extends AbstractHistoryRepository<ModuleHistory,Long> {

}
