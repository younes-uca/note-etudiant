package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.Training;
import ma.sir.school.bean.history.TrainingHistory;
import ma.sir.school.dao.criteria.core.TrainingCriteria;
import ma.sir.school.dao.criteria.history.TrainingHistoryCriteria;
import ma.sir.school.dao.facade.core.TrainingDao;
import ma.sir.school.dao.facade.history.TrainingHistoryDao;
import ma.sir.school.dao.specification.core.TrainingSpecification;
import ma.sir.school.service.facade.admin.TrainingAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.school.bean.core.Semester;
import ma.sir.school.bean.core.Student;

import ma.sir.school.service.facade.admin.StudentAdminService ;
import ma.sir.school.service.facade.admin.SemesterAdminService ;


import java.util.List;
@Service
public class TrainingAdminServiceImpl extends AbstractServiceImpl<Training,TrainingHistory, TrainingCriteria, TrainingHistoryCriteria, TrainingDao,
TrainingHistoryDao> implements TrainingAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Training create(Training t) {
        super.create(t);
        if (t.getSemesters() != null) {
                t.getSemesters().forEach(element-> {
                    element.setTraining(t);
                    semesterService.create(element);
            });
        }
        if (t.getStudents() != null) {
                t.getStudents().forEach(element-> {
                    element.setTraining(t);
                    studentService.create(element);
            });
        }
        return t;
    }

    public Training findWithAssociatedLists(Long id){
        Training result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSemesters(semesterService.findByTrainingId(id));
            result.setStudents(studentService.findByTrainingId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        semesterService.deleteByTrainingId(id);
        studentService.deleteByTrainingId(id);
    }


    public void updateWithAssociatedLists(Training training){
    if(training !=null && training.getId() != null){
            List<List<Semester>> resultSemesters= semesterService.getToBeSavedAndToBeDeleted(semesterService.findByTrainingId(training.getId()),training.getSemesters());
            semesterService.delete(resultSemesters.get(1));
            ListUtil.emptyIfNull(resultSemesters.get(0)).forEach(e -> e.setTraining(training));
            semesterService.update(resultSemesters.get(0),true);
            List<List<Student>> resultStudents= studentService.getToBeSavedAndToBeDeleted(studentService.findByTrainingId(training.getId()),training.getStudents());
            studentService.delete(resultStudents.get(1));
            ListUtil.emptyIfNull(resultStudents.get(0)).forEach(e -> e.setTraining(training));
            studentService.update(resultStudents.get(0),true);
    }
    }

    public Training findByReferenceEntity(Training t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(Training.class,TrainingHistory.class, TrainingHistoryCriteria.class, TrainingSpecification.class);
    }

    @Autowired
    private StudentAdminService studentService ;
    @Autowired
    private SemesterAdminService semesterService ;

    public TrainingAdminServiceImpl(TrainingDao dao, TrainingHistoryDao historyDao) {
        super(dao, historyDao);
    }

}