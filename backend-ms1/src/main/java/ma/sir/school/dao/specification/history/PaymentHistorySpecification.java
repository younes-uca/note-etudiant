package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.PaymentHistoryCriteria;
import ma.sir.school.bean.history.PaymentHistory;


public class PaymentHistorySpecification extends AbstractHistorySpecification<PaymentHistoryCriteria, PaymentHistory> {

    public PaymentHistorySpecification(PaymentHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentHistorySpecification(PaymentHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
