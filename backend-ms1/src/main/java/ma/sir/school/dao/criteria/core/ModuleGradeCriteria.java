package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ModuleGradeCriteria extends  BaseCriteria  {

    private String grade;
    private String gradeMin;
    private String gradeMax;

    private StudentCriteria student ;
    private List<StudentCriteria> students ;
    private ModuleCriteria module ;
    private List<ModuleCriteria> modules ;
    private SemesterCriteria semester ;
    private List<SemesterCriteria> semesters ;


    public ModuleGradeCriteria(){}

    public String getGrade(){
        return this.grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }   
    public String getGradeMin(){
        return this.gradeMin;
    }
    public void setGradeMin(String gradeMin){
        this.gradeMin = gradeMin;
    }
    public String getGradeMax(){
        return this.gradeMax;
    }
    public void setGradeMax(String gradeMax){
        this.gradeMax = gradeMax;
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
