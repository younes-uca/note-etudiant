package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.TrainingHistoryCriteria;
import ma.sir.school.bean.history.TrainingHistory;


public class TrainingHistorySpecification extends AbstractHistorySpecification<TrainingHistoryCriteria, TrainingHistory> {

    public TrainingHistorySpecification(TrainingHistoryCriteria criteria) {
        super(criteria);
    }

    public TrainingHistorySpecification(TrainingHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
