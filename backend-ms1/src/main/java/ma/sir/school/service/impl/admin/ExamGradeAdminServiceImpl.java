package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.ExamGrade;
import ma.sir.school.bean.history.ExamGradeHistory;
import ma.sir.school.dao.criteria.core.ExamGradeCriteria;
import ma.sir.school.dao.criteria.history.ExamGradeHistoryCriteria;
import ma.sir.school.dao.facade.core.ExamGradeDao;
import ma.sir.school.dao.facade.history.ExamGradeHistoryDao;
import ma.sir.school.dao.specification.core.ExamGradeSpecification;
import ma.sir.school.service.facade.admin.ExamGradeAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.school.service.facade.admin.StudentAdminService ;
import ma.sir.school.service.facade.admin.ExamAdminService ;


import java.util.List;
@Service
public class ExamGradeAdminServiceImpl extends AbstractServiceImpl<ExamGrade,ExamGradeHistory, ExamGradeCriteria, ExamGradeHistoryCriteria, ExamGradeDao,
ExamGradeHistoryDao> implements ExamGradeAdminService {



    public List<ExamGrade> findByExamId(Long id){
        return dao.findByExamId(id);
    }
    public int deleteByExamId(Long id){
        return dao.deleteByExamId(id);
    }
    public List<ExamGrade> findByStudentId(Long id){
        return dao.findByStudentId(id);
    }
    public int deleteByStudentId(Long id){
        return dao.deleteByStudentId(id);
    }



    public void configure() {
        super.configure(ExamGrade.class,ExamGradeHistory.class, ExamGradeHistoryCriteria.class, ExamGradeSpecification.class);
    }

    @Autowired
    private StudentAdminService studentService ;
    @Autowired
    private ExamAdminService examService ;

    public ExamGradeAdminServiceImpl(ExamGradeDao dao, ExamGradeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}