package ma.sir.school.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "semester_average")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="semester_average_seq",sequenceName="semester_average_seq",allocationSize=1, initialValue = 1)
public class SemesterAverage   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal average = BigDecimal.ZERO;
    @Column(columnDefinition = "boolean default false")
    private Boolean validated = false;

    private Student student ;
    
    private Semester semester ;
    


    public SemesterAverage(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="semester_average_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Student getStudent(){
        return this.student;
    }
    public void setStudent(Student student){
        this.student = student;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Semester getSemester(){
        return this.semester;
    }
    public void setSemester(Semester semester){
        this.semester = semester;
    }
    public BigDecimal getAverage(){
        return this.average;
    }
    public void setAverage(BigDecimal average){
        this.average = average;
    }
    public Boolean  getValidated(){
        return this.validated;
    }
    public void setValidated(Boolean validated){
        this.validated = validated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterAverage semesterAverage = (SemesterAverage) o;
        return id != null && id.equals(semesterAverage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

