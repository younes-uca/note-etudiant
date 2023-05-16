package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.Diploma;
import ma.sir.school.dao.criteria.core.DiplomaCriteria;
import ma.sir.school.dao.criteria.history.DiplomaHistoryCriteria;
import ma.sir.school.zynerator.service.IService;


public interface DiplomaAdminService extends  IService<Diploma,DiplomaCriteria, DiplomaHistoryCriteria>  {

    List<Diploma> findByStudentId(Long id);
    int deleteByStudentId(Long id);
    List<Diploma> findByTrainingId(Long id);
    int deleteByTrainingId(Long id);



}
