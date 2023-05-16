package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.StudentHistoryCriteria;
import ma.sir.school.bean.history.StudentHistory;


public class StudentHistorySpecification extends AbstractHistorySpecification<StudentHistoryCriteria, StudentHistory> {

    public StudentHistorySpecification(StudentHistoryCriteria criteria) {
        super(criteria);
    }

    public StudentHistorySpecification(StudentHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
