package  ma.sir.school.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.school.zynerator.util.ListUtil;


import ma.sir.school.zynerator.util.StringUtil;
import ma.sir.school.zynerator.converter.AbstractConverter;
import ma.sir.school.zynerator.util.DateUtil;
import ma.sir.school.bean.history.TrainingHistory;
import ma.sir.school.bean.core.Training;
import ma.sir.school.ws.dto.TrainingDto;

@Component
public class TrainingConverter extends AbstractConverter<Training, TrainingDto, TrainingHistory> {

    @Autowired
    private SemesterConverter semesterConverter ;
    @Autowired
    private PaymentConverter paymentConverter ;
    @Autowired
    private StudentConverter studentConverter ;
    @Autowired
    private DiplomaConverter diplomaConverter ;
    @Autowired
    private SemesterAverageConverter semesterAverageConverter ;
    @Autowired
    private ModuleConverter moduleConverter ;
    @Autowired
    private ModuleGradeConverter moduleGradeConverter ;
    private boolean semesters;
    private boolean students;

    public  TrainingConverter(){
        super(Training.class, TrainingDto.class, TrainingHistory.class);
        init(true);
    }

    @Override
    public Training toItem(TrainingDto dto) {
        if (dto == null) {
            return null;
        } else {
        Training item = new Training();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDuration()))
                item.setDuration(dto.getDuration());
            if(StringUtil.isNotEmpty(dto.getTrainingCost()))
                item.setTrainingCost(dto.getTrainingCost());

            if(this.semesters && ListUtil.isNotEmpty(dto.getSemesters()))
                item.setSemesters(semesterConverter.toItem(dto.getSemesters()));
            if(this.students && ListUtil.isNotEmpty(dto.getStudents()))
                item.setStudents(studentConverter.toItem(dto.getStudents()));

        return item;
        }
    }

    @Override
    public TrainingDto toDto(Training item) {
        if (item == null) {
            return null;
        } else {
            TrainingDto dto = new TrainingDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getDuration()))
                dto.setDuration(item.getDuration());
            if(StringUtil.isNotEmpty(item.getTrainingCost()))
                dto.setTrainingCost(item.getTrainingCost());
        if(this.semesters && ListUtil.isNotEmpty(item.getSemesters())){
            semesterConverter.init(true);
            semesterConverter.setTraining(false);
            dto.setSemesters(semesterConverter.toDto(item.getSemesters()));
            semesterConverter.setTraining(true);

        }
        if(this.students && ListUtil.isNotEmpty(item.getStudents())){
            studentConverter.init(true);
            studentConverter.setTraining(false);
            dto.setStudents(studentConverter.toDto(item.getStudents()));
            studentConverter.setTraining(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.semesters = value;
        this.students = value;
    }

    public void initObject(boolean value) {
    }


    public SemesterConverter getSemesterConverter(){
        return this.semesterConverter;
    }
    public void setSemesterConverter(SemesterConverter semesterConverter ){
        this.semesterConverter = semesterConverter;
    }
    public PaymentConverter getPaymentConverter(){
        return this.paymentConverter;
    }
    public void setPaymentConverter(PaymentConverter paymentConverter ){
        this.paymentConverter = paymentConverter;
    }
    public StudentConverter getStudentConverter(){
        return this.studentConverter;
    }
    public void setStudentConverter(StudentConverter studentConverter ){
        this.studentConverter = studentConverter;
    }
    public DiplomaConverter getDiplomaConverter(){
        return this.diplomaConverter;
    }
    public void setDiplomaConverter(DiplomaConverter diplomaConverter ){
        this.diplomaConverter = diplomaConverter;
    }
    public SemesterAverageConverter getSemesterAverageConverter(){
        return this.semesterAverageConverter;
    }
    public void setSemesterAverageConverter(SemesterAverageConverter semesterAverageConverter ){
        this.semesterAverageConverter = semesterAverageConverter;
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
    public boolean  isSemesters(){
        return this.semesters ;
    }
    public void  setSemesters(boolean semesters ){
        this.semesters  = semesters ;
    }
    public boolean  isStudents(){
        return this.students ;
    }
    public void  setStudents(boolean students ){
        this.students  = students ;
    }
}
