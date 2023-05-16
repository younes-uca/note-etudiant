package ma.sir.school.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "payment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_seq",sequenceName="payment_seq",allocationSize=1, initialValue = 1)
public class Payment   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal amount = BigDecimal.ZERO;
    private LocalDateTime paidDate ;

    private Student student ;
    
    private Training Training ;
    
    private Semester semester ;
    


    public Payment(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_seq")
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
        return this.Training;
    }
    public void setTraining(Training Training){
        this.Training = Training;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Semester getSemester(){
        return this.semester;
    }
    public void setSemester(Semester semester){
        this.semester = semester;
    }
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    public LocalDateTime getPaidDate(){
        return this.paidDate;
    }
    public void setPaidDate(LocalDateTime paidDate){
        this.paidDate = paidDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id != null && id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

