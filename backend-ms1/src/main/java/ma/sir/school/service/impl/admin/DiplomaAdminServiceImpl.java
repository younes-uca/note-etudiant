package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.Diploma;
import ma.sir.school.bean.history.DiplomaHistory;
import ma.sir.school.dao.criteria.core.DiplomaCriteria;
import ma.sir.school.dao.criteria.history.DiplomaHistoryCriteria;
import ma.sir.school.dao.facade.core.DiplomaDao;
import ma.sir.school.dao.facade.history.DiplomaHistoryDao;
import ma.sir.school.dao.specification.core.DiplomaSpecification;
import ma.sir.school.service.facade.admin.DiplomaAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.school.service.facade.admin.StudentAdminService ;
import ma.sir.school.service.facade.admin.TrainingAdminService ;


import java.util.List;
@Service
public class DiplomaAdminServiceImpl extends AbstractServiceImpl<Diploma,DiplomaHistory, DiplomaCriteria, DiplomaHistoryCriteria, DiplomaDao,
DiplomaHistoryDao> implements DiplomaAdminService {



    public List<Diploma> findByStudentId(Long id){
        return dao.findByStudentId(id);
    }
    public int deleteByStudentId(Long id){
        return dao.deleteByStudentId(id);
    }
    public List<Diploma> findByTrainingId(Long id){
        return dao.findByTrainingId(id);
    }
    public int deleteByTrainingId(Long id){
        return dao.deleteByTrainingId(id);
    }



    public void configure() {
        super.configure(Diploma.class,DiplomaHistory.class, DiplomaHistoryCriteria.class, DiplomaSpecification.class);
    }

    @Autowired
    private StudentAdminService studentService ;
    @Autowired
    private TrainingAdminService trainingService ;

    public DiplomaAdminServiceImpl(DiplomaDao dao, DiplomaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}