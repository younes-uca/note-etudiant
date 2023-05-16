package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.ExamHistoryCriteria;
import ma.sir.school.bean.history.ExamHistory;


public class ExamHistorySpecification extends AbstractHistorySpecification<ExamHistoryCriteria, ExamHistory> {

    public ExamHistorySpecification(ExamHistoryCriteria criteria) {
        super(criteria);
    }

    public ExamHistorySpecification(ExamHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
