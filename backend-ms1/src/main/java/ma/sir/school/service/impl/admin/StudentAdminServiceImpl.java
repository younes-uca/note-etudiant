package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.Student;
import ma.sir.school.bean.history.StudentHistory;
import ma.sir.school.dao.criteria.core.StudentCriteria;
import ma.sir.school.dao.criteria.history.StudentHistoryCriteria;
import ma.sir.school.dao.facade.core.StudentDao;
import ma.sir.school.dao.facade.history.StudentHistoryDao;
import ma.sir.school.dao.specification.core.StudentSpecification;
import ma.sir.school.service.facade.admin.StudentAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.school.bean.core.ModuleGrade;
import ma.sir.school.bean.core.SemesterAverage;
import ma.sir.school.bean.core.Payment;

import ma.sir.school.service.facade.admin.SemesterAverageAdminService ;
import ma.sir.school.service.facade.admin.DiplomaAdminService ;
import ma.sir.school.service.facade.admin.TrainingAdminService ;
import ma.sir.school.service.facade.admin.PaymentAdminService ;
import ma.sir.school.service.facade.admin.ModuleGradeAdminService ;


import java.util.List;
@Service
public class StudentAdminServiceImpl extends AbstractServiceImpl<Student,StudentHistory, StudentCriteria, StudentHistoryCriteria, StudentDao,
StudentHistoryDao> implements StudentAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Student create(Student t) {
        super.create(t);
        if (t.getModulesGrades() != null) {
                t.getModulesGrades().forEach(element-> {
                    element.setStudent(t);
                    moduleGradeService.create(element);
            });
        }
        if (t.getSemestersAverages() != null) {
                t.getSemestersAverages().forEach(element-> {
                    element.setStudent(t);
                    semesterAverageService.create(element);
            });
        }
        if (t.getPayments() != null) {
                t.getPayments().forEach(element-> {
                    element.setStudent(t);
                    paymentService.create(element);
            });
        }
        return t;
    }

    public Student findWithAssociatedLists(Long id){
        Student result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setModulesGrades(moduleGradeService.findByStudentId(id));
            result.setSemestersAverages(semesterAverageService.findByStudentId(id));
            result.setPayments(paymentService.findByStudentId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        moduleGradeService.deleteByStudentId(id);
        semesterAverageService.deleteByStudentId(id);
        paymentService.deleteByStudentId(id);
    }


    public void updateWithAssociatedLists(Student student){
    if(student !=null && student.getId() != null){
            List<List<ModuleGrade>> resultModulesGrades= moduleGradeService.getToBeSavedAndToBeDeleted(moduleGradeService.findByStudentId(student.getId()),student.getModulesGrades());
            moduleGradeService.delete(resultModulesGrades.get(1));
            ListUtil.emptyIfNull(resultModulesGrades.get(0)).forEach(e -> e.setStudent(student));
            moduleGradeService.update(resultModulesGrades.get(0),true);
            List<List<SemesterAverage>> resultSemestersAverages= semesterAverageService.getToBeSavedAndToBeDeleted(semesterAverageService.findByStudentId(student.getId()),student.getSemestersAverages());
            semesterAverageService.delete(resultSemestersAverages.get(1));
            ListUtil.emptyIfNull(resultSemestersAverages.get(0)).forEach(e -> e.setStudent(student));
            semesterAverageService.update(resultSemestersAverages.get(0),true);
            List<List<Payment>> resultPayments= paymentService.getToBeSavedAndToBeDeleted(paymentService.findByStudentId(student.getId()),student.getPayments());
            paymentService.delete(resultPayments.get(1));
            ListUtil.emptyIfNull(resultPayments.get(0)).forEach(e -> e.setStudent(student));
            paymentService.update(resultPayments.get(0),true);
    }
    }


    public List<Student> findByTrainingId(Long id){
        return dao.findByTrainingId(id);
    }
    public int deleteByTrainingId(Long id){
        return dao.deleteByTrainingId(id);
    }
    public List<Student> findByDiplomaId(Long id){
        return dao.findByDiplomaId(id);
    }
    public int deleteByDiplomaId(Long id){
        return dao.deleteByDiplomaId(id);
    }



    public void configure() {
        super.configure(Student.class,StudentHistory.class, StudentHistoryCriteria.class, StudentSpecification.class);
    }

    @Autowired
    private SemesterAverageAdminService semesterAverageService ;
    @Autowired
    private DiplomaAdminService diplomaService ;
    @Autowired
    private TrainingAdminService trainingService ;
    @Autowired
    private PaymentAdminService paymentService ;
    @Autowired
    private ModuleGradeAdminService moduleGradeService ;

    public StudentAdminServiceImpl(StudentDao dao, StudentHistoryDao historyDao) {
        super(dao, historyDao);
    }

}