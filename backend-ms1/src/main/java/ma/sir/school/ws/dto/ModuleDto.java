package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;


    private List<TrainingDto> trainings ;
    private List<SemesterDto> semesters ;
    private List<ExamDto> exams ;


    public ModuleDto(){
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





    public List<TrainingDto> getTrainings(){
        return this.trainings;
    }

    public void setTrainings(List<TrainingDto> trainings){
        this.trainings = trainings;
    }
    public List<SemesterDto> getSemesters(){
        return this.semesters;
    }

    public void setSemesters(List<SemesterDto> semesters){
        this.semesters = semesters;
    }
    public List<ExamDto> getExams(){
        return this.exams;
    }

    public void setExams(List<ExamDto> exams){
        this.exams = exams;
    }

}
