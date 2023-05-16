package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.SemesterAverageCriteria;
import ma.sir.school.bean.core.SemesterAverage;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SemesterAverageSpecification extends  AbstractSpecification<SemesterAverageCriteria, SemesterAverage>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("average", criteria.getAverage(), criteria.getAverageMin(), criteria.getAverageMax());
        addPredicateBool("validated", criteria.getValidated());
        addPredicateFk("student","id", criteria.getStudent()==null?null:criteria.getStudent().getId());
        addPredicateFk("student","id", criteria.getStudents());
        addPredicateFk("semester","id", criteria.getSemester()==null?null:criteria.getSemester().getId());
        addPredicateFk("semester","id", criteria.getSemesters());
        addPredicateFk("semester","code", criteria.getSemester()==null?null:criteria.getSemester().getCode());
    }

    public SemesterAverageSpecification(SemesterAverageCriteria criteria) {
        super(criteria);
    }

    public SemesterAverageSpecification(SemesterAverageCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
