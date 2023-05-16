package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.DiplomaHistoryCriteria;
import ma.sir.school.bean.history.DiplomaHistory;


public class DiplomaHistorySpecification extends AbstractHistorySpecification<DiplomaHistoryCriteria, DiplomaHistory> {

    public DiplomaHistorySpecification(DiplomaHistoryCriteria criteria) {
        super(criteria);
    }

    public DiplomaHistorySpecification(DiplomaHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
