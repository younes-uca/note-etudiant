package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SemesterCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private LocalDateTime startDate;
    private LocalDateTime startDateFrom;
    private LocalDateTime startDateTo;
    private LocalDateTime endDate;
    private LocalDateTime endDateFrom;
    private LocalDateTime endDateTo;

    private TrainingCriteria training ;
    private List<TrainingCriteria> trainings ;


    public SemesterCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public LocalDateTime getStartDate(){
        return this.startDate;
    }
    public void setStartDate(LocalDateTime startDate){
        this.startDate = startDate;
    }
    public LocalDateTime getStartDateFrom(){
        return this.startDateFrom;
    }
    public void setStartDateFrom(LocalDateTime startDateFrom){
        this.startDateFrom = startDateFrom;
    }
    public LocalDateTime getStartDateTo(){
        return this.startDateTo;
    }
    public void setStartDateTo(LocalDateTime startDateTo){
        this.startDateTo = startDateTo;
    }
    public LocalDateTime getEndDate(){
        return this.endDate;
    }
    public void setEndDate(LocalDateTime endDate){
        this.endDate = endDate;
    }
    public LocalDateTime getEndDateFrom(){
        return this.endDateFrom;
    }
    public void setEndDateFrom(LocalDateTime endDateFrom){
        this.endDateFrom = endDateFrom;
    }
    public LocalDateTime getEndDateTo(){
        return this.endDateTo;
    }
    public void setEndDateTo(LocalDateTime endDateTo){
        this.endDateTo = endDateTo;
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
