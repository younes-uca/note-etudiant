package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SemesterAverageDto  extends AuditBaseDto {

    private BigDecimal average  ;
    private Boolean validated  ;

    private StudentDto student ;
    private SemesterDto semester ;



    public SemesterAverageDto(){
        super();
    }



    @Log
    public BigDecimal getAverage(){
        return this.average;
    }
    public void setAverage(BigDecimal average){
        this.average = average;
    }

    @Log
    public Boolean getValidated(){
        return this.validated;
    }
    public void setValidated(Boolean validated){
        this.validated = validated;
    }


    public StudentDto getStudent(){
        return this.student;
    }

    public void setStudent(StudentDto student){
        this.student = student;
    }
    public SemesterDto getSemester(){
        return this.semester;
    }

    public void setSemester(SemesterDto semester){
        this.semester = semester;
    }




}
