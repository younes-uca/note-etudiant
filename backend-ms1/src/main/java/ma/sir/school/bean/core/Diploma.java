package ma.sir.school.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "diploma")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="diploma_seq",sequenceName="diploma_seq",allocationSize=1, initialValue = 1)
public class Diploma   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateIssued ;

    private Student student ;
    
    private Training training ;
    


    public Diploma(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="diploma_seq")
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
    public Training getTraining(){
        return this.training;
    }
    public void setTraining(Training training){
        this.training = training;
    }
    public LocalDateTime getDateIssued(){
        return this.dateIssued;
    }
    public void setDateIssued(LocalDateTime dateIssued){
        this.dateIssued = dateIssued;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diploma diploma = (Diploma) o;
        return id != null && id.equals(diploma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

