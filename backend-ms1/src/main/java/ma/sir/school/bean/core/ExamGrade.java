package ma.sir.school.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "exam_grade")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="exam_grade_seq",sequenceName="exam_grade_seq",allocationSize=1, initialValue = 1)
public class ExamGrade   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal grade = BigDecimal.ZERO;

    private Exam exam ;
    
    private Student student ;
    


    public ExamGrade(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="exam_grade_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Exam getExam(){
        return this.exam;
    }
    public void setExam(Exam exam){
        this.exam = exam;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Student getStudent(){
        return this.student;
    }
    public void setStudent(Student student){
        this.student = student;
    }
    public BigDecimal getGrade(){
        return this.grade;
    }
    public void setGrade(BigDecimal grade){
        this.grade = grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamGrade examGrade = (ExamGrade) o;
        return id != null && id.equals(examGrade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

