package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainingDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private Integer duration  = 0 ;
    private BigDecimal trainingCost  ;


    private List<SemesterDto> semesters ;
    private List<StudentDto> students ;


    public TrainingDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public Integer getDuration(){
        return this.duration;
    }
    public void setDuration(Integer duration){
        this.duration = duration;
    }

    @Log
    public BigDecimal getTrainingCost(){
        return this.trainingCost;
    }
    public void setTrainingCost(BigDecimal trainingCost){
        this.trainingCost = trainingCost;
    }





    public List<SemesterDto> getSemesters(){
        return this.semesters;
    }

    public void setSemesters(List<SemesterDto> semesters){
        this.semesters = semesters;
    }
    public List<StudentDto> getStudents(){
        return this.students;
    }

    public void setStudents(List<StudentDto> students){
        this.students = students;
    }

}
