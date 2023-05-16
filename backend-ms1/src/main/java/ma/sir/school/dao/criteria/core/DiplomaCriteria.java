package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DiplomaCriteria extends  BaseCriteria  {

    private LocalDateTime dateIssued;
    private LocalDateTime dateIssuedFrom;
    private LocalDateTime dateIssuedTo;

    private StudentCriteria student ;
    private List<StudentCriteria> students ;
    private TrainingCriteria training ;
    private List<TrainingCriteria> trainings ;


    public DiplomaCriteria(){}

    public LocalDateTime getDateIssued(){
        return this.dateIssued;
    }
    public void setDateIssued(LocalDateTime dateIssued){
        this.dateIssued = dateIssued;
    }
    public LocalDateTime getDateIssuedFrom(){
        return this.dateIssuedFrom;
    }
    public void setDateIssuedFrom(LocalDateTime dateIssuedFrom){
        this.dateIssuedFrom = dateIssuedFrom;
    }
    public LocalDateTime getDateIssuedTo(){
        return this.dateIssuedTo;
    }
    public void setDateIssuedTo(LocalDateTime dateIssuedTo){
        this.dateIssuedTo = dateIssuedTo;
    }

    public StudentCriteria getStudent(){
        return this.student;
    }

    public void setStudent(StudentCriteria student){
        this.student = student;
    }
    public List<StudentCriteria> getStudents(){
        return this.students;
    }

    public void setStudents(List<StudentCriteria> students){
        this.students = students;
    }
    public TrainingCriteria getTraining(){
        return this.training;
    }

    public void setTraining(TrainingCriteria training){
        this.training = training;
    }
    public List<TrainingCriteria> getTrainings(){
        return this.trainings;
    }

    public void setTrainings(List<TrainingCriteria> trainings){
        this.trainings = trainings;
    }
}
