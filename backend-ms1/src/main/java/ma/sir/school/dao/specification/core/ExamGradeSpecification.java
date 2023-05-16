package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.ExamGradeCriteria;
import ma.sir.school.bean.core.ExamGrade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ExamGradeSpecification extends  AbstractSpecification<ExamGradeCriteria, ExamGrade>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("grade", criteria.getGrade(), criteria.getGradeMin(), criteria.getGradeMax());
        addPredicateFk("exam","id", criteria.getExam()==null?null:criteria.getExam().getId());
        addPredicateFk("exam","id", criteria.getExams());
        addPredicateFk("student","id", criteria.getStudent()==null?null:criteria.getStudent().getId());
        addPredicateFk("student","id", criteria.getStudents());
    }

    public ExamGradeSpecification(ExamGradeCriteria criteria) {
        super(criteria);
    }

    public ExamGradeSpecification(ExamGradeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
