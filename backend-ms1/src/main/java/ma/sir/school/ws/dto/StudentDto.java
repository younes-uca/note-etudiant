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
public class StudentDto  extends AuditBaseDto {

    private String cin  ;
    private String firstName  ;
    private String lastName  ;
    private String email  ;
    private String phoneNumber  ;
    private String address  ;
    private String registrationDate ;
    private Boolean graduated  ;

    private TrainingDto training ;
    private DiplomaDto diploma ;

    private List<ModuleGradeDto> modulesGrades ;
    private List<SemesterAverageDto> semestersAverages ;
    private List<PaymentDto> payments ;


    public StudentDto(){
        super();
    }



    @Log
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }

    @Log
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Log
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Log
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getRegistrationDate(){
        return this.registrationDate;
    }
    public void setRegistrationDate(String registrationDate){
        this.registrationDate = registrationDate;
    }

    @Log
    public Boolean getGraduated(){
        return this.graduated;
    }
    public void setGraduated(Boolean graduated){
        this.graduated = graduated;
    }


    public TrainingDto getTraining(){
        return this.training;
    }

    public void setTraining(TrainingDto training){
        this.training = training;
    }
    public DiplomaDto getDiploma(){
        return this.diploma;
    }

    public void setDiploma(DiplomaDto diploma){
        this.diploma = diploma;
    }



    public List<ModuleGradeDto> getModulesGrades(){
        return this.modulesGrades;
    }

    public void setModulesGrades(List<ModuleGradeDto> modulesGrades){
        this.modulesGrades = modulesGrades;
    }
    public List<SemesterAverageDto> getSemestersAverages(){
        return this.semestersAverages;
    }

    public void setSemestersAverages(List<SemesterAverageDto> semestersAverages){
        this.semestersAverages = semestersAverages;
    }
    public List<PaymentDto> getPayments(){
        return this.payments;
    }

    public void setPayments(List<PaymentDto> payments){
        this.payments = payments;
    }

}
