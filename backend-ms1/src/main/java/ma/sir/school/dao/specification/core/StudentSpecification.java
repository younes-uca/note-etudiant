package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.StudentCriteria;
import ma.sir.school.bean.core.Student;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification extends  AbstractSpecification<StudentCriteria, Student>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("firstName", criteria.getFirstName(),criteria.getFirstNameLike());
        addPredicate("lastName", criteria.getLastName(),criteria.getLastNameLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("phoneNumber", criteria.getPhoneNumber(),criteria.getPhoneNumberLike());
        addPredicate("address", criteria.getAddress(),criteria.getAddressLike());
        addPredicate("registrationDate", criteria.getRegistrationDate(), criteria.getRegistrationDateFrom(), criteria.getRegistrationDateTo());
        addPredicateBool("graduated", criteria.getGraduated());
        addPredicateFk("training","id", criteria.getTraining()==null?null:criteria.getTraining().getId());
        addPredicateFk("training","id", criteria.getTrainings());
        addPredicateFk("training","code", criteria.getTraining()==null?null:criteria.getTraining().getCode());
        addPredicateFk("diploma","id", criteria.getDiploma()==null?null:criteria.getDiploma().getId());
        addPredicateFk("diploma","id", criteria.getDiplomas());
    }

    public StudentSpecification(StudentCriteria criteria) {
        super(criteria);
    }

    public StudentSpecification(StudentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
