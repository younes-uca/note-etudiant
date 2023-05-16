package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.ModuleGradeCriteria;
import ma.sir.school.bean.core.ModuleGrade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ModuleGradeSpecification extends  AbstractSpecification<ModuleGradeCriteria, ModuleGrade>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("grade", criteria.getGrade(), criteria.getGradeMin(), criteria.getGradeMax());
        addPredicateFk("student","id", criteria.getStudent()==null?null:criteria.getStudent().getId());
        addPredicateFk("student","id", criteria.getStudents());
        addPredicateFk("module","id", criteria.getModule()==null?null:criteria.getModule().getId());
        addPredicateFk("module","id", criteria.getModules());
        addPredicateFk("module","code", criteria.getModule()==null?null:criteria.getModule().getCode());
        addPredicateFk("semester","id", criteria.getSemester()==null?null:criteria.getSemester().getId());
        addPredicateFk("semester","id", criteria.getSemesters());
        addPredicateFk("semester","code", criteria.getSemester()==null?null:criteria.getSemester().getCode());
    }

    public ModuleGradeSpecification(ModuleGradeCriteria criteria) {
        super(criteria);
    }

    public ModuleGradeSpecification(ModuleGradeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
