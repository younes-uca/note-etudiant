package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.SemesterAverageHistoryCriteria;
import ma.sir.school.bean.history.SemesterAverageHistory;


public class SemesterAverageHistorySpecification extends AbstractHistorySpecification<SemesterAverageHistoryCriteria, SemesterAverageHistory> {

    public SemesterAverageHistorySpecification(SemesterAverageHistoryCriteria criteria) {
        super(criteria);
    }

    public SemesterAverageHistorySpecification(SemesterAverageHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
