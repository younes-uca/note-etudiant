package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExamGradeDto  extends AuditBaseDto {

    private BigDecimal grade  ;

    private ExamDto exam ;
    private StudentDto student ;



    public ExamGradeDto(){
        super();
    }



    @Log
    public BigDecimal getGrade(){
        return this.grade;
    }
    public void setGrade(BigDecimal grade){
        this.grade = grade;
    }


    public ExamDto getExam(){
        return this.exam;
    }

    public void setExam(ExamDto exam){
        this.exam = exam;
    }
    public StudentDto getStudent(){
        return this.student;
    }

    public void setStudent(StudentDto student){
        this.student = student;
    }




}
