package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiplomaDto  extends AuditBaseDto {

    private String dateIssued ;

    private StudentDto student ;
    private TrainingDto training ;



    public DiplomaDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateIssued(){
        return this.dateIssued;
    }
    public void setDateIssued(String dateIssued){
        this.dateIssued = dateIssued;
    }


    public StudentDto getStudent(){
        return this.student;
    }

    public void setStudent(StudentDto student){
        this.student = student;
    }
    public TrainingDto getTraining(){
        return this.training;
    }

    public void setTraining(TrainingDto training){
        this.training = training;
    }




}
