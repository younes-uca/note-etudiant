package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.ModuleHistoryCriteria;
import ma.sir.school.bean.history.ModuleHistory;


public class ModuleHistorySpecification extends AbstractHistorySpecification<ModuleHistoryCriteria, ModuleHistory> {

    public ModuleHistorySpecification(ModuleHistoryCriteria criteria) {
        super(criteria);
    }

    public ModuleHistorySpecification(ModuleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
