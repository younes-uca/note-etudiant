package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.ExamGradeHistoryCriteria;
import ma.sir.school.bean.history.ExamGradeHistory;


public class ExamGradeHistorySpecification extends AbstractHistorySpecification<ExamGradeHistoryCriteria, ExamGradeHistory> {

    public ExamGradeHistorySpecification(ExamGradeHistoryCriteria criteria) {
        super(criteria);
    }

    public ExamGradeHistorySpecification(ExamGradeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
