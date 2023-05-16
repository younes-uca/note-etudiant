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
@Table(name = "semester")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="semester_seq",sequenceName="semester_seq",allocationSize=1, initialValue = 1)
public class Semester   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private LocalDateTime startDate ;
    private LocalDateTime endDate ;

    private Training training ;
    

    private List<Module> modules ;

    public Semester(){
        super();
    }

    public Semester(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="semester_seq")
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
    public LocalDateTime getStartDate(){
        return this.startDate;
    }
    public void setStartDate(LocalDateTime startDate){
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate(){
        return this.endDate;
    }
    public void setEndDate(LocalDateTime endDate){
        this.endDate = endDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Training getTraining(){
        return this.training;
    }
    public void setTraining(Training training){
        this.training = training;
    }
    @OneToMany(mappedBy = "semesters")
    public List<Module> getModules(){
        return this.modules;
    }
    public void setModules(List<Module> modules){
        this.modules = modules;
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
        Semester semester = (Semester) o;
        return id != null && id.equals(semester.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

