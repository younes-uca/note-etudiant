package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExamDto  extends AuditBaseDto {

    private String dateExam ;

    private ModuleDto module ;
    private SemesterDto semester ;

    private List<ExamGradeDto> examGrades ;


    public ExamDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateExam(){
        return this.dateExam;
    }
    public void setDateExam(String dateExam){
        this.dateExam = dateExam;
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



    public List<ExamGradeDto> getExamGrades(){
        return this.examGrades;
    }

    public void setExamGrades(List<ExamGradeDto> examGrades){
        this.examGrades = examGrades;
    }

}
