package  ma.sir.school.ws.dto;

import ma.sir.school.zynerator.audit.Log;
import ma.sir.school.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto  extends AuditBaseDto {

    private BigDecimal amount  ;
    private String paidDate ;

    private StudentDto student ;
    private TrainingDto training ;
    private SemesterDto semester ;



    public PaymentDto(){
        super();
    }



    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getPaidDate(){
        return this.paidDate;
    }
    public void setPaidDate(String paidDate){
        this.paidDate = paidDate;
    }


    public StudentDto getStudent(){
        return this.student;
    }

    public void setStudent(StudentDto student){
        this.student = student;
    }
    public TrainingDto getTraining(){
        return this.Training;
    }

    public void setTraining(TrainingDto Training){
        this.Training = Training;
    }
    public SemesterDto getSemester(){
        return this.semester;
    }

    public void setSemester(SemesterDto semester){
        this.semester = semester;
    }




}
