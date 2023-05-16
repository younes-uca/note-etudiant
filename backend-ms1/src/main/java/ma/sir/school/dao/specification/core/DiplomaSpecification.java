package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.DiplomaCriteria;
import ma.sir.school.bean.core.Diploma;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DiplomaSpecification extends  AbstractSpecification<DiplomaCriteria, Diploma>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateIssued", criteria.getDateIssued(), criteria.getDateIssuedFrom(), criteria.getDateIssuedTo());
        addPredicateFk("student","id", criteria.getStudent()==null?null:criteria.getStudent().getId());
        addPredicateFk("student","id", criteria.getStudents());
        addPredicateFk("training","id", criteria.getTraining()==null?null:criteria.getTraining().getId());
        addPredicateFk("training","id", criteria.getTrainings());
        addPredicateFk("training","code", criteria.getTraining()==null?null:criteria.getTraining().getCode());
    }

    public DiplomaSpecification(DiplomaCriteria criteria) {
        super(criteria);
    }

    public DiplomaSpecification(DiplomaCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
