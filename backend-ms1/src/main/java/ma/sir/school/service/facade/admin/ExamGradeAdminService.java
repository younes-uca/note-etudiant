package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.ExamGrade;
import ma.sir.school.dao.criteria.core.ExamGradeCriteria;
import ma.sir.school.dao.criteria.history.ExamGradeHistoryCriteria;
import ma.sir.school.zynerator.service.IService;


public interface ExamGradeAdminService extends  IService<ExamGrade,ExamGradeCriteria, ExamGradeHistoryCriteria>  {

    List<ExamGrade> findByExamId(Long id);
    int deleteByExamId(Long id);
    List<ExamGrade> findByStudentId(Long id);
    int deleteByStudentId(Long id);



}
