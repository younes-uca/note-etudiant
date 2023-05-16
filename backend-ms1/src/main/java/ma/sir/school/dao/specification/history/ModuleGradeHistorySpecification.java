package  ma.sir.school.dao.specification.history;

import ma.sir.school.zynerator.specification.AbstractHistorySpecification;
import ma.sir.school.dao.criteria.history.ModuleGradeHistoryCriteria;
import ma.sir.school.bean.history.ModuleGradeHistory;


public class ModuleGradeHistorySpecification extends AbstractHistorySpecification<ModuleGradeHistoryCriteria, ModuleGradeHistory> {

    public ModuleGradeHistorySpecification(ModuleGradeHistoryCriteria criteria) {
        super(criteria);
    }

    public ModuleGradeHistorySpecification(ModuleGradeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
