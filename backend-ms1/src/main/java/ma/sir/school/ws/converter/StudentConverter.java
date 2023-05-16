package  ma.sir.school.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.school.zynerator.util.ListUtil;

import ma.sir.school.bean.core.Training;

import ma.sir.school.zynerator.util.StringUtil;
import ma.sir.school.zynerator.converter.AbstractConverter;
import ma.sir.school.zynerator.util.DateUtil;
import ma.sir.school.bean.history.StudentHistory;
import ma.sir.school.bean.core.Student;
import ma.sir.school.ws.dto.StudentDto;

@Component
public class StudentConverter extends AbstractConverter<Student, StudentDto, StudentHistory> {

    @Autowired
    private SemesterConverter semesterConverter ;
    @Autowired
    private TrainingConverter trainingConverter ;
    @Autowired
    private PaymentConverter paymentConverter ;
    @Autowired
    private SemesterAverageConverter semesterAverageConverter ;
    @Autowired
    private DiplomaConverter diplomaConverter ;
    @Autowired
    private ModuleConverter moduleConverter ;
    @Autowired
    private ModuleGradeConverter moduleGradeConverter ;
    private boolean training;
    private boolean diploma;
    private boolean modulesGrades;
    private boolean semestersAverages;
    private boolean payments;

    public  StudentConverter(){
        super(Student.class, StudentDto.class, StudentHistory.class);
        init(true);
    }

    @Override
    public Student toItem(StudentDto dto) {
        if (dto == null) {
            return null;
        } else {
        Student item = new Student();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            if(StringUtil.isNotEmpty(dto.getFirstName()))
                item.setFirstName(dto.getFirstName());
            if(StringUtil.isNotEmpty(dto.getLastName()))
                item.setLastName(dto.getLastName());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getPhoneNumber()))
                item.setPhoneNumber(dto.getPhoneNumber());
            if(StringUtil.isNotEmpty(dto.getAddress()))
                item.setAddress(dto.getAddress());
            if(StringUtil.isNotEmpty(dto.getRegistrationDate()))
                item.setRegistrationDate(DateUtil.stringEnToDate(dto.getRegistrationDate()));
            if(dto.getGraduated() != null)
                item.setGraduated(dto.getGraduated());
            if(dto.getTraining() != null && dto.getTraining().getId() != null){
                item.setTraining(new Training());
                item.getTraining().setId(dto.getTraining().getId());
            }

            if(this.diploma && dto.getDiploma()!=null)
                item.setDiploma(diplomaConverter.toItem(dto.getDiploma())) ;


            if(this.modulesGrades && ListUtil.isNotEmpty(dto.getModulesGrades()))
                item.setModulesGrades(moduleGradeConverter.toItem(dto.getModulesGrades()));
            if(this.semestersAverages && ListUtil.isNotEmpty(dto.getSemestersAverages()))
                item.setSemestersAverages(semesterAverageConverter.toItem(dto.getSemestersAverages()));
            if(this.payments && ListUtil.isNotEmpty(dto.getPayments()))
                item.setPayments(paymentConverter.toItem(dto.getPayments()));

        return item;
        }
    }

    @Override
    public StudentDto toDto(Student item) {
        if (item == null) {
            return null;
        } else {
            StudentDto dto = new StudentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getFirstName()))
                dto.setFirstName(item.getFirstName());
            if(StringUtil.isNotEmpty(item.getLastName()))
                dto.setLastName(item.getLastName());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getPhoneNumber()))
                dto.setPhoneNumber(item.getPhoneNumber());
            if(StringUtil.isNotEmpty(item.getAddress()))
                dto.setAddress(item.getAddress());
            if(item.getRegistrationDate()!=null)
                dto.setRegistrationDate(DateUtil.dateTimeToString(item.getRegistrationDate()));
                dto.setGraduated(item.getGraduated());
        if(this.training && item.getTraining()!=null) {
            dto.setTraining(trainingConverter.toDto(item.getTraining())) ;
        }
        if(this.diploma && item.getDiploma()!=null) {
            diplomaConverter.setStudent(false);
            dto.setDiploma(diplomaConverter.toDto(item.getDiploma())) ;
            diplomaConverter.setStudent(true);
        }
        if(this.modulesGrades && ListUtil.isNotEmpty(item.getModulesGrades())){
            moduleGradeConverter.init(true);
            moduleGradeConverter.setStudent(false);
            dto.setModulesGrades(moduleGradeConverter.toDto(item.getModulesGrades()));
            moduleGradeConverter.setStudent(true);

        }
        if(this.semestersAverages && ListUtil.isNotEmpty(item.getSemestersAverages())){
            semesterAverageConverter.init(true);
            semesterAverageConverter.setStudent(false);
            dto.setSemestersAverages(semesterAverageConverter.toDto(item.getSemestersAverages()));
            semesterAverageConverter.setStudent(true);

        }
        if(this.payments && ListUtil.isNotEmpty(item.getPayments())){
            paymentConverter.init(true);
            paymentConverter.setStudent(false);
            dto.setPayments(paymentConverter.toDto(item.getPayments()));
            paymentConverter.setStudent(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.modulesGrades = value;
        this.semestersAverages = value;
        this.payments = value;
    }

    public void initObject(boolean value) {
        this.training = value;
        this.diploma = value;
    }


    public SemesterConverter getSemesterConverter(){
        return this.semesterConverter;
    }
    public void setSemesterConverter(SemesterConverter semesterConverter ){
        this.semesterConverter = semesterConverter;
    }
    public TrainingConverter getTrainingConverter(){
        return this.trainingConverter;
    }
    public void setTrainingConverter(TrainingConverter trainingConverter ){
        this.trainingConverter = trainingConverter;
    }
    public PaymentConverter getPaymentConverter(){
        return this.paymentConverter;
    }
    public void setPaymentConverter(PaymentConverter paymentConverter ){
        this.paymentConverter = paymentConverter;
    }
    public SemesterAverageConverter getSemesterAverageConverter(){
        return this.semesterAverageConverter;
    }
    public void setSemesterAverageConverter(SemesterAverageConverter semesterAverageConverter ){
        this.semesterAverageConverter = semesterAverageConverter;
    }
    public DiplomaConverter getDiplomaConverter(){
        return this.diplomaConverter;
    }
    public void setDiplomaConverter(DiplomaConverter diplomaConverter ){
        this.diplomaConverter = diplomaConverter;
    }
    public ModuleConverter getModuleConverter(){
        return this.moduleConverter;
    }
    public void setModuleConverter(ModuleConverter moduleConverter ){
        this.moduleConverter = moduleConverter;
    }
    public ModuleGradeConverter getModuleGradeConverter(){
        return this.moduleGradeConverter;
    }
    public void setModuleGradeConverter(ModuleGradeConverter moduleGradeConverter ){
        this.moduleGradeConverter = moduleGradeConverter;
    }
    public boolean  isTraining(){
        return this.training;
    }
    public void  setTraining(boolean training){
        this.training = training;
    }
    public boolean  isDiploma(){
        return this.diploma;
    }
    public void  setDiploma(boolean diploma){
        this.diploma = diploma;
    }
    public boolean  isModulesGrades(){
        return this.modulesGrades ;
    }
    public void  setModulesGrades(boolean modulesGrades ){
        this.modulesGrades  = modulesGrades ;
    }
    public boolean  isSemestersAverages(){
        return this.semestersAverages ;
    }
    public void  setSemestersAverages(boolean semestersAverages ){
        this.semestersAverages  = semestersAverages ;
    }
    public boolean  isPayments(){
        return this.payments ;
    }
    public void  setPayments(boolean payments ){
        this.payments  = payments ;
    }
}
