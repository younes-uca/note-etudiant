package ma.sir.school.dao.facade.history;

import ma.sir.school.zynerator.repository.AbstractHistoryRepository;
import ma.sir.school.bean.history.PaymentHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryDao extends AbstractHistoryRepository<PaymentHistory,Long> {

}
