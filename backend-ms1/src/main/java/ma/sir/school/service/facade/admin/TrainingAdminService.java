package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.Training;
import ma.sir.school.dao.criteria.core.TrainingCriteria;
import ma.sir.school.dao.criteria.history.TrainingHistoryCriteria;
import ma.sir.school.zynerator.service.IService;


public interface TrainingAdminService extends  IService<Training,TrainingCriteria, TrainingHistoryCriteria>  {




}
