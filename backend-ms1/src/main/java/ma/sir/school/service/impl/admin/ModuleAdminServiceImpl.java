package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.Module;
import ma.sir.school.bean.history.ModuleHistory;
import ma.sir.school.dao.criteria.core.ModuleCriteria;
import ma.sir.school.dao.criteria.history.ModuleHistoryCriteria;
import ma.sir.school.dao.facade.core.ModuleDao;
import ma.sir.school.dao.facade.history.ModuleHistoryDao;
import ma.sir.school.dao.specification.core.ModuleSpecification;
import ma.sir.school.service.facade.admin.ModuleAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.school.bean.core.Training;
import ma.sir.school.bean.core.Semester;
import ma.sir.school.bean.core.Exam;

import ma.sir.school.service.facade.admin.SemesterAdminService ;
import ma.sir.school.service.facade.admin.ExamAdminService ;
import ma.sir.school.service.facade.admin.TrainingAdminService ;


import java.util.List;
@Service
public class ModuleAdminServiceImpl extends AbstractServiceImpl<Module,ModuleHistory, ModuleCriteria, ModuleHistoryCriteria, ModuleDao,
ModuleHistoryDao> implements ModuleAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Module create(Module t) {
        super.create(t);
        if (t.getTrainings() != null) {
                t.getTrainings().forEach(element-> {
                    element.setModule(t);
                    trainingService.create(element);
            });
        }
        if (t.getSemesters() != null) {
                t.getSemesters().forEach(element-> {
                    element.setModule(t);
                    semesterService.create(element);
            });
        }
        if (t.getExams() != null) {
                t.getExams().forEach(element-> {
                    element.setModule(t);
                    examService.create(element);
            });
        }
        return t;
    }

    public Module findWithAssociatedLists(Long id){
        Module result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setTrainings(trainingService.findByModuleId(id));
            result.setSemesters(semesterService.findByModuleId(id));
            result.setExams(examService.findByModuleId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        trainingService.deleteByModuleId(id);
        semesterService.deleteByModuleId(id);
        examService.deleteByModuleId(id);
    }


    public void updateWithAssociatedLists(Module module){
    if(module !=null && module.getId() != null){
            List<List<Training>> resultTrainings= trainingService.getToBeSavedAndToBeDeleted(trainingService.findByModuleId(module.getId()),module.getTrainings());
            trainingService.delete(resultTrainings.get(1));
            ListUtil.emptyIfNull(resultTrainings.get(0)).forEach(e -> e.setModule(module));
            trainingService.update(resultTrainings.get(0),true);
            List<List<Semester>> resultSemesters= semesterService.getToBeSavedAndToBeDeleted(semesterService.findByModuleId(module.getId()),module.getSemesters());
            semesterService.delete(resultSemesters.get(1));
            ListUtil.emptyIfNull(resultSemesters.get(0)).forEach(e -> e.setModule(module));
            semesterService.update(resultSemesters.get(0),true);
            List<List<Exam>> resultExams= examService.getToBeSavedAndToBeDeleted(examService.findByModuleId(module.getId()),module.getExams());
            examService.delete(resultExams.get(1));
            ListUtil.emptyIfNull(resultExams.get(0)).forEach(e -> e.setModule(module));
            examService.update(resultExams.get(0),true);
    }
    }

    public Module findByReferenceEntity(Module t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(Module.class,ModuleHistory.class, ModuleHistoryCriteria.class, ModuleSpecification.class);
    }

    @Autowired
    private SemesterAdminService semesterService ;
    @Autowired
    private ExamAdminService examService ;
    @Autowired
    private TrainingAdminService trainingService ;

    public ModuleAdminServiceImpl(ModuleDao dao, ModuleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}