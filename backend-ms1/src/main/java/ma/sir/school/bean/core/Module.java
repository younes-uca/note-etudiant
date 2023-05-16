package ma.sir.school.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "module")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="module_seq",sequenceName="module_seq",allocationSize=1, initialValue = 1)
public class Module   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;


    private List<Training> trainings ;
    private List<Semester> semesters ;
    private List<Exam> exams ;

    public Module(){
        super();
    }

    public Module(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="module_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @OneToMany
    public List<Training> getTrainings(){
        return this.trainings;
    }
    public void setTrainings(List<Training> trainings){
        this.trainings = trainings;
    }
    @OneToMany(mappedBy = "modules")
    public List<Semester> getSemesters(){
        return this.semesters;
    }
    public void setSemesters(List<Semester> semesters){
        this.semesters = semesters;
    }
    @OneToMany(mappedBy = "module")
    public List<Exam> getExams(){
        return this.exams;
    }
    public void setExams(List<Exam> exams){
        this.exams = exams;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return id != null && id.equals(module.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

