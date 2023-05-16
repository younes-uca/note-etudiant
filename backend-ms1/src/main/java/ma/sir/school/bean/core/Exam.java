package ma.sir.school.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "exam")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="exam_seq",sequenceName="exam_seq",allocationSize=1, initialValue = 1)
public class Exam   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateExam ;

    private Module module ;
    
    private Semester semester ;
    

    private List<ExamGrade> examGrades ;

    public Exam(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="exam_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Module getModule(){
        return this.module;
    }
    public void setModule(Module module){
        this.module = module;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Semester getSemester(){
        return this.semester;
    }
    public void setSemester(Semester semester){
        this.semester = semester;
    }
    public LocalDateTime getDateExam(){
        return this.dateExam;
    }
    public void setDateExam(LocalDateTime dateExam){
        this.dateExam = dateExam;
    }
    @OneToMany(mappedBy = "exam")
    public List<ExamGrade> getExamGrades(){
        return this.examGrades;
    }
    public void setExamGrades(List<ExamGrade> examGrades){
        this.examGrades = examGrades;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id != null && id.equals(exam.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

