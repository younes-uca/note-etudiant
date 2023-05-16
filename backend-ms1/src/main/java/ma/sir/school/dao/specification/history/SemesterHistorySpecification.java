package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.SemesterHistoryCriteria;
import ma.sir.school.bean.history.SemesterHistory;


public class SemesterHistorySpecification extends AbstractHistorySpecification<SemesterHistoryCriteria, SemesterHistory> {

    public SemesterHistorySpecification(SemesterHistoryCriteria criteria) {
        super(criteria);
    }

    public SemesterHistorySpecification(SemesterHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
