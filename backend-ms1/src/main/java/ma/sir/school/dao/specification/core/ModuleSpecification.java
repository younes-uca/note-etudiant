package  ma.sir.school.dao.specification.core;

import ma.sir.school.zynerator.specification.AbstractSpecification;
import ma.sir.school.dao.criteria.core.ModuleCriteria;
import ma.sir.school.bean.core.Module;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ModuleSpecification extends  AbstractSpecification<ModuleCriteria, Module>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ModuleSpecification(ModuleCriteria criteria) {
        super(criteria);
    }

    public ModuleSpecification(ModuleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
