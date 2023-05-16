package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleGradeDto  extends AuditBaseDto {

    private BigDecimal grade  ;

    private StudentDto student ;
    private ModuleDto module ;
    private SemesterDto semester ;



    public ModuleGradeDto(){
        super();
    }



    @Log
    public BigDecimal getGrade(){
        return this.grade;
    }
    public void setGrade(BigDecimal grade){
        this.grade = grade;
    }


    public StudentDto getStudent(){
        return this.student;
    }

    public void setStudent(StudentDto student){
        this.student = student;
    }
    public ModuleDto getModule(){
        return this.module;
    }

    public void setModule(ModuleDto module){
        this.module = module;
    }
    public SemesterDto getSemester(){
        return this.semester;
    }

    public void setSemester(SemesterDto semester){
        this.semester = semester;
    }




}
