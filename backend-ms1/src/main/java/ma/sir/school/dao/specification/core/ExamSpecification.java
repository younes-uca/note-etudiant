package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.ExamCriteria;
import ma.sir.school.bean.core.Exam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ExamSpecification extends  AbstractSpecification<ExamCriteria, Exam>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateExam", criteria.getDateExam(), criteria.getDateExamFrom(), criteria.getDateExamTo());
        addPredicateFk("module","id", criteria.getModule()==null?null:criteria.getModule().getId());
        addPredicateFk("module","id", criteria.getModules());
        addPredicateFk("module","code", criteria.getModule()==null?null:criteria.getModule().getCode());
        addPredicateFk("semester","id", criteria.getSemester()==null?null:criteria.getSemester().getId());
        addPredicateFk("semester","id", criteria.getSemesters());
        addPredicateFk("semester","code", criteria.getSemester()==null?null:criteria.getSemester().getCode());
    }

    public ExamSpecification(ExamCriteria criteria) {
        super(criteria);
    }

    public ExamSpecification(ExamCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
