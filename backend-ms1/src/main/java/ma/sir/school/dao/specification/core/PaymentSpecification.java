package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.PaymentCriteria;
import ma.sir.school.bean.core.Payment;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaymentSpecification extends  AbstractSpecification<PaymentCriteria, Payment>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicate("paidDate", criteria.getPaidDate(), criteria.getPaidDateFrom(), criteria.getPaidDateTo());
        addPredicateFk("student","id", criteria.getStudent()==null?null:criteria.getStudent().getId());
        addPredicateFk("student","id", criteria.getStudents());
        addPredicateFk("Training","id", criteria.getTraining()==null?null:criteria.getTraining().getId());
        addPredicateFk("Training","id", criteria.getTrainings());
        addPredicateFk("Training","code", criteria.getTraining()==null?null:criteria.getTraining().getCode());
        addPredicateFk("semester","id", criteria.getSemester()==null?null:criteria.getSemester().getId());
        addPredicateFk("semester","id", criteria.getSemesters());
        addPredicateFk("semester","code", criteria.getSemester()==null?null:criteria.getSemester().getCode());
    }

    public PaymentSpecification(PaymentCriteria criteria) {
        super(criteria);
    }

    public PaymentSpecification(PaymentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
