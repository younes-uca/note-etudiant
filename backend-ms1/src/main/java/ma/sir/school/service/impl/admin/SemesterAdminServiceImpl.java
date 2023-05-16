package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.Semester;
import ma.sir.school.bean.history.SemesterHistory;
import ma.sir.school.dao.criteria.core.SemesterCriteria;
import ma.sir.school.dao.criteria.history.SemesterHistoryCriteria;
import ma.sir.school.dao.facade.core.SemesterDao;
import ma.sir.school.dao.facade.history.SemesterHistoryDao;
import ma.sir.school.dao.specification.core.SemesterSpecification;
import ma.sir.school.service.facade.admin.SemesterAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.school.bean.core.Module;

import ma.sir.school.service.facade.admin.TrainingAdminService ;
import ma.sir.school.service.facade.admin.ModuleAdminService ;


import java.util.List;
@Service
public class SemesterAdminServiceImpl extends AbstractServiceImpl<Semester,SemesterHistory, SemesterCriteria, SemesterHistoryCriteria, SemesterDao,
SemesterHistoryDao> implements SemesterAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Semester create(Semester t) {
        super.create(t);
        if (t.getModules() != null) {
                t.getModules().forEach(element-> {
                    element.setSemester(t);
                    moduleService.create(element);
            });
        }
        return t;
    }

    public Semester findWithAssociatedLists(Long id){
        Semester result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setModules(moduleService.findBySemesterId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        moduleService.deleteBySemesterId(id);
    }


    public void updateWithAssociatedLists(Semester semester){
    if(semester !=null && semester.getId() != null){
            List<List<Module>> resultModules= moduleService.getToBeSavedAndToBeDeleted(moduleService.findBySemesterId(semester.getId()),semester.getModules());
            moduleService.delete(resultModules.get(1));
            ListUtil.emptyIfNull(resultModules.get(0)).forEach(e -> e.setSemester(semester));
            moduleService.update(resultModules.get(0),true);
    }
    }

    public Semester findByReferenceEntity(Semester t){
        return  dao.findByCode(t.getCode());
    }

    public List<Semester> findByTrainingId(Long id){
        return dao.findByTrainingId(id);
    }
    public int deleteByTrainingId(Long id){
        return dao.deleteByTrainingId(id);
    }



    public void configure() {
        super.configure(Semester.class,SemesterHistory.class, SemesterHistoryCriteria.class, SemesterSpecification.class);
    }

    @Autowired
    private TrainingAdminService trainingService ;
    @Autowired
    private ModuleAdminService moduleService ;

    public SemesterAdminServiceImpl(SemesterDao dao, SemesterHistoryDao historyDao) {
        super(dao, historyDao);
    }

}