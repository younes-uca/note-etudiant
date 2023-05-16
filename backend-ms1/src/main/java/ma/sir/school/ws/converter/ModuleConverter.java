package  ma.sir.school.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.school.zynerator.util.ListUtil;


import ma.sir.school.zynerator.util.StringUtil;
import ma.sir.school.zynerator.converter.AbstractConverter;
import ma.sir.school.zynerator.util.DateUtil;
import ma.sir.school.bean.history.ModuleHistory;
import ma.sir.school.bean.core.Module;
import ma.sir.school.ws.dto.ModuleDto;

@Component
public class ModuleConverter extends AbstractConverter<Module, ModuleDto, ModuleHistory> {

    @Autowired
    private SemesterConverter semesterConverter ;
    @Autowired
    private ExamConverter examConverter ;
    @Autowired
    private TrainingConverter trainingConverter ;
    @Autowired
    private StudentConverter studentConverter ;
    @Autowired
    private ExamGradeConverter examGradeConverter ;
    private boolean trainings;
    private boolean semesters;
    private boolean exams;

    public  ModuleConverter(){
        super(Module.class, ModuleDto.class, ModuleHistory.class);
        init(true);
    }

    @Override
    public Module toItem(ModuleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Module item = new Module();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());

            if(this.trainings && ListUtil.isNotEmpty(dto.getTrainings()))
                item.setTrainings(trainingConverter.toItem(dto.getTrainings()));
            if(this.semesters && ListUtil.isNotEmpty(dto.getSemesters()))
                item.setSemesters(semesterConverter.toItem(dto.getSemesters()));
            if(this.exams && ListUtil.isNotEmpty(dto.getExams()))
                item.setExams(examConverter.toItem(dto.getExams()));

        return item;
        }
    }

    @Override
    public ModuleDto toDto(Module item) {
        if (item == null) {
            return null;
        } else {
            ModuleDto dto = new ModuleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.trainings && ListUtil.isNotEmpty(item.getTrainings())){
            trainingConverter.init(true);
            trainingConverter.setModule(false);
            dto.setTrainings(trainingConverter.toDto(item.getTrainings()));
            trainingConverter.setModule(true);

        }
        if(this.semesters && ListUtil.isNotEmpty(item.getSemesters())){
            semesterConverter.init(true);
            semesterConverter.setModule(false);
            dto.setSemesters(semesterConverter.toDto(item.getSemesters()));
            semesterConverter.setModule(true);

        }
        if(this.exams && ListUtil.isNotEmpty(item.getExams())){
            examConverter.init(true);
            examConverter.setModule(false);
            dto.setExams(examConverter.toDto(item.getExams()));
            examConverter.setModule(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.trainings = value;
        this.semesters = value;
        this.exams = value;
    }

    public void initObject(boolean value) {
    }


    public SemesterConverter getSemesterConverter(){
        return this.semesterConverter;
    }
    public void setSemesterConverter(SemesterConverter semesterConverter ){
        this.semesterConverter = semesterConverter;
    }
    public ExamConverter getExamConverter(){
        return this.examConverter;
    }
    public void setExamConverter(ExamConverter examConverter ){
        this.examConverter = examConverter;
    }
    public TrainingConverter getTrainingConverter(){
        return this.trainingConverter;
    }
    public void setTrainingConverter(TrainingConverter trainingConverter ){
        this.trainingConverter = trainingConverter;
    }
    public StudentConverter getStudentConverter(){
        return this.studentConverter;
    }
    public void setStudentConverter(StudentConverter studentConverter ){
        this.studentConverter = studentConverter;
    }
    public ExamGradeConverter getExamGradeConverter(){
        return this.examGradeConverter;
    }
    public void setExamGradeConverter(ExamGradeConverter examGradeConverter ){
        this.examGradeConverter = examGradeConverter;
    }
    public boolean  isTrainings(){
        return this.trainings ;
    }
    public void  setTrainings(boolean trainings ){
        this.trainings  = trainings ;
    }
    public boolean  isSemesters(){
        return this.semesters ;
    }
    public void  setSemesters(boolean semesters ){
        this.semesters  = semesters ;
    }
    public boolean  isExams(){
        return this.exams ;
    }
    public void  setExams(boolean exams ){
        this.exams  = exams ;
    }
}
