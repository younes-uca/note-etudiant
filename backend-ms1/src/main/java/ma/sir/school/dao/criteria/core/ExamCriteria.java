package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ExamCriteria extends  BaseCriteria  {

    private LocalDateTime dateExam;
    private LocalDateTime dateExamFrom;
    private LocalDateTime dateExamTo;

    private ModuleCriteria module ;
    private List<ModuleCriteria> modules ;
    private SemesterCriteria semester ;
    private List<SemesterCriteria> semesters ;


    public ExamCriteria(){}

    public LocalDateTime getDateExam(){
        return this.dateExam;
    }
    public void setDateExam(LocalDateTime dateExam){
        this.dateExam = dateExam;
    }
    public LocalDateTime getDateExamFrom(){
        return this.dateExamFrom;
    }
    public void setDateExamFrom(LocalDateTime dateExamFrom){
        this.dateExamFrom = dateExamFrom;
    }
    public LocalDateTime getDateExamTo(){
        return this.dateExamTo;
    }
    public void setDateExamTo(LocalDateTime dateExamTo){
        this.dateExamTo = dateExamTo;
    }

    public ModuleCriteria getModule(){
        return this.module;
    }

    public void setModule(ModuleCriteria module){
        this.module = module;
    }
    public List<ModuleCriteria> getModules(){
        return this.modules;
    }

    public void setModules(List<ModuleCriteria> modules){
        this.modules = modules;
    }
    public SemesterCriteria getSemester(){
        return this.semester;
    }

    public void setSemester(SemesterCriteria semester){
        this.semester = semester;
    }
    public List<SemesterCriteria> getSemesters(){
        return this.semesters;
    }

    public void setSemesters(List<SemesterCriteria> semesters){
        this.semesters = semesters;
    }
}
