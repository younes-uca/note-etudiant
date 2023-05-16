package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.Student;
import ma.sir.school.dao.criteria.core.StudentCriteria;
import ma.sir.school.dao.criteria.history.StudentHistoryCriteria;
import ma.sir.school.zynerator.service.IService;


public interface StudentAdminService extends  IService<Student,StudentCriteria, StudentHistoryCriteria>  {

    List<Student> findByTrainingId(Long id);
    int deleteByTrainingId(Long id);
    List<Student> findByDiplomaId(Long id);
    int deleteByDiplomaId(Long id);



}
