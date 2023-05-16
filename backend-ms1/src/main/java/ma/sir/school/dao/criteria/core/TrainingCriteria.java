package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;

public class TrainingCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String duration;
    private String durationMin;
    private String durationMax;
    private String trainingCost;
    private String trainingCostMin;
    private String trainingCostMax;



    public TrainingCriteria(){}

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

    public String getDuration(){
        return this.duration;
    }
    public void setDuration(String duration){
        this.duration = duration;
    }   
    public String getDurationMin(){
        return this.durationMin;
    }
    public void setDurationMin(String durationMin){
        this.durationMin = durationMin;
    }
    public String getDurationMax(){
        return this.durationMax;
    }
    public void setDurationMax(String durationMax){
        this.durationMax = durationMax;
    }
      
    public String getTrainingCost(){
        return this.trainingCost;
    }
    public void setTrainingCost(String trainingCost){
        this.trainingCost = trainingCost;
    }   
    public String getTrainingCostMin(){
        return this.trainingCostMin;
    }
    public void setTrainingCostMin(String trainingCostMin){
        this.trainingCostMin = trainingCostMin;
    }
    public String getTrainingCostMax(){
        return this.trainingCostMax;
    }
    public void setTrainingCostMax(String trainingCostMax){
        this.trainingCostMax = trainingCostMax;
    }
      

}
