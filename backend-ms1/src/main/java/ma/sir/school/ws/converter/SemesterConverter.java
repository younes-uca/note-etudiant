package  ma.sir.school.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.school.zynerator.util.ListUtil;

import ma.sir.school.bean.core.Training;

import ma.sir.school.zynerator.util.StringUtil;
import ma.sir.school.zynerator.converter.AbstractConverter;
import ma.sir.school.zynerator.util.DateUtil;
import ma.sir.school.bean.history.SemesterHistory;
import ma.sir.school.bean.core.Semester;
import ma.sir.school.ws.dto.SemesterDto;

@Component
public class SemesterConverter extends AbstractConverter<Semester, SemesterDto, SemesterHistory> {

    @Autowired
    private ExamConverter examConverter ;
    @Autowired
    private TrainingConverter trainingConverter ;
    @Autowired
    private ModuleConverter moduleConverter ;
    private boolean training;
    private boolean modules;

    public  SemesterConverter(){
        super(Semester.class, SemesterDto.class, SemesterHistory.class);
        init(true);
    }

    @Override
    public Semester toItem(SemesterDto dto) {
        if (dto == null) {
            return null;
        } else {
        Semester item = new Semester();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getStartDate()))
                item.setStartDate(DateUtil.stringEnToDate(dto.getStartDate()));
            if(StringUtil.isNotEmpty(dto.getEndDate()))
                item.setEndDate(DateUtil.stringEnToDate(dto.getEndDate()));
            if(dto.getTraining() != null && dto.getTraining().getId() != null){
                item.setTraining(new Training());
                item.getTraining().setId(dto.getTraining().getId());
            }


            if(this.modules && ListUtil.isNotEmpty(dto.getModules()))
                item.setModules(moduleConverter.toItem(dto.getModules()));

        return item;
        }
    }

    @Override
    public SemesterDto toDto(Semester item) {
        if (item == null) {
            return null;
        } else {
            SemesterDto dto = new SemesterDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(item.getStartDate()!=null)
                dto.setStartDate(DateUtil.dateTimeToString(item.getStartDate()));
            if(item.getEndDate()!=null)
                dto.setEndDate(DateUtil.dateTimeToString(item.getEndDate()));
        if(this.training && item.getTraining()!=null) {
            dto.setTraining(trainingConverter.toDto(item.getTraining())) ;
        }
        if(this.modules && ListUtil.isNotEmpty(item.getModules())){
            moduleConverter.init(true);
            moduleConverter.setSemester(false);
            dto.setModules(moduleConverter.toDto(item.getModules()));
            moduleConverter.setSemester(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.modules = value;
    }

    public void initObject(boolean value) {
        this.training = value;
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
    public ModuleConverter getModuleConverter(){
        return this.moduleConverter;
    }
    public void setModuleConverter(ModuleConverter moduleConverter ){
        this.moduleConverter = moduleConverter;
    }
    public boolean  isTraining(){
        return this.training;
    }
    public void  setTraining(boolean training){
        this.training = training;
    }
    public boolean  isModules(){
        return this.modules ;
    }
    public void  setModules(boolean modules ){
        this.modules  = modules ;
    }
}
