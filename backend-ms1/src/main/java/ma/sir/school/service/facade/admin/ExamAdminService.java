package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.Exam;
import ma.sir.school.dao.criteria.core.ExamCriteria;
import ma.sir.school.dao.criteria.history.ExamHistoryCriteria;
import ma.sir.school.zynerator.service.IService;


public interface ExamAdminService extends  IService<Exam,ExamCriteria, ExamHistoryCriteria>  {

    List<Exam> findByModuleId(Long id);
    int deleteByModuleId(Long id);
    List<Exam> findBySemesterId(Long id);
    int deleteBySemesterId(Long id);



}
