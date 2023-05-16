package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.Semester;
import ma.sir.school.dao.criteria.core.SemesterCriteria;
import ma.sir.school.dao.criteria.history.SemesterHistoryCriteria;
import ma.sir.school.zynerator.service.IService;


public interface SemesterAdminService extends  IService<Semester,SemesterCriteria, SemesterHistoryCriteria>  {

    List<Semester> findByTrainingId(Long id);
    int deleteByTrainingId(Long id);



}
