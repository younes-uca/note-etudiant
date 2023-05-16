package ma.sir.school.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "module_grade")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="module_grade_seq",sequenceName="module_grade_seq",allocationSize=1, initialValue = 1)
public class ModuleGrade   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal grade = BigDecimal.ZERO;

    private Student student ;
    
    private Module module ;
    
    private Semester semester ;
    


    public ModuleGrade(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="module_grade_seq")
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
        ModuleGrade moduleGrade = (ModuleGrade) o;
        return id != null && id.equals(moduleGrade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

