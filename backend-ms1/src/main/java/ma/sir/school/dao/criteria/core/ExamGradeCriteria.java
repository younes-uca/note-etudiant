package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ExamGradeCriteria extends  BaseCriteria  {

    private String grade;
    private String gradeMin;
    private String gradeMax;

    private ExamCriteria exam ;
    private List<ExamCriteria> exams ;
    private StudentCriteria student ;
    private List<StudentCriteria> students ;


    public ExamGradeCriteria(){}

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
      

    public ExamCriteria getExam(){
        return this.exam;
    }

    public void setExam(ExamCriteria exam){
        this.exam = exam;
    }
    public List<ExamCriteria> getExams(){
        return this.exams;
    }

    public void setExams(List<ExamCriteria> exams){
        this.exams = exams;
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
}
