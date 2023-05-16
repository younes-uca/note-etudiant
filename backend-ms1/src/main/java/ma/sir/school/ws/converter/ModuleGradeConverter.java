package  ma.sir.school.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.school.bean.core.Student;
import ma.sir.school.bean.core.Module;
import ma.sir.school.bean.core.Semester;

import ma.sir.school.zynerator.util.StringUtil;
import ma.sir.school.zynerator.converter.AbstractConverter;
import ma.sir.school.zynerator.util.DateUtil;
import ma.sir.school.bean.history.ModuleGradeHistory;
import ma.sir.school.bean.core.ModuleGrade;
import ma.sir.school.ws.dto.ModuleGradeDto;

@Component
public class ModuleGradeConverter extends AbstractConverter<ModuleGrade, ModuleGradeDto, ModuleGradeHistory> {

    @Autowired
    private StudentConverter studentConverter ;
    @Autowired
    private SemesterConverter semesterConverter ;
    @Autowired
    private ModuleConverter moduleConverter ;
    private boolean student;
    private boolean module;
    private boolean semester;

    public  ModuleGradeConverter(){
        super(ModuleGrade.class, ModuleGradeDto.class, ModuleGradeHistory.class);
    }

    @Override
    public ModuleGrade toItem(ModuleGradeDto dto) {
        if (dto == null) {
            return null;
        } else {
        ModuleGrade item = new ModuleGrade();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getGrade()))
                item.setGrade(dto.getGrade());
            if(dto.getStudent() != null && dto.getStudent().getId() != null){
                item.setStudent(new Student());
                item.getStudent().setId(dto.getStudent().getId());
            }

            if(dto.getModule() != null && dto.getModule().getId() != null){
                item.setModule(new Module());
                item.getModule().setId(dto.getModule().getId());
            }

            if(dto.getSemester() != null && dto.getSemester().getId() != null){
                item.setSemester(new Semester());
                item.getSemester().setId(dto.getSemester().getId());
            }



        return item;
        }
    }

    @Override
    public ModuleGradeDto toDto(ModuleGrade item) {
        if (item == null) {
            return null;
        } else {
            ModuleGradeDto dto = new ModuleGradeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getGrade()))
                dto.setGrade(item.getGrade());
        if(this.student && item.getStudent()!=null) {
            dto.setStudent(studentConverter.toDto(item.getStudent())) ;
        }
        if(this.module && item.getModule()!=null) {
            dto.setModule(moduleConverter.toDto(item.getModule())) ;
        }
        if(this.semester && item.getSemester()!=null) {
            dto.setSemester(semesterConverter.toDto(item.getSemester())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.student = value;
        this.module = value;
        this.semester = value;
    }


    public StudentConverter getStudentConverter(){
        return this.studentConverter;
    }
    public void setStudentConverter(StudentConverter studentConverter ){
        this.studentConverter = studentConverter;
    }
    public SemesterConverter getSemesterConverter(){
        return this.semesterConverter;
    }
    public void setSemesterConverter(SemesterConverter semesterConverter ){
        this.semesterConverter = semesterConverter;
    }
    public ModuleConverter getModuleConverter(){
        return this.moduleConverter;
    }
    public void setModuleConverter(ModuleConverter moduleConverter ){
        this.moduleConverter = moduleConverter;
    }
    public boolean  isStudent(){
        return this.student;
    }
    public void  setStudent(boolean student){
        this.student = student;
    }
    public boolean  isModule(){
        return this.module;
    }
    public void  setModule(boolean module){
        this.module = module;
    }
    public boolean  isSemester(){
        return this.semester;
    }
    public void  setSemester(boolean semester){
        this.semester = semester;
    }
}
