package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SemesterAverageCriteria extends  BaseCriteria  {

    private String average;
    private String averageMin;
    private String averageMax;
    private Boolean validated;

    private StudentCriteria student ;
    private List<StudentCriteria> students ;
    private SemesterCriteria semester ;
    private List<SemesterCriteria> semesters ;


    public SemesterAverageCriteria(){}

    public String getAverage(){
        return this.average;
    }
    public void setAverage(String average){
        this.average = average;
    }   
    public String getAverageMin(){
        return this.averageMin;
    }
    public void setAverageMin(String averageMin){
        this.averageMin = averageMin;
    }
    public String getAverageMax(){
        return this.averageMax;
    }
    public void setAverageMax(String averageMax){
        this.averageMax = averageMax;
    }
      
    public Boolean getValidated(){
        return this.validated;
    }
    public void setValidated(Boolean validated){
        this.validated = validated;
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
