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
@Table(name = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="student_seq",sequenceName="student_seq",allocationSize=1, initialValue = 1)
public class Student   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String cin;
    @Column(length = 500)
    private String firstName;
    @Column(length = 500)
    private String lastName;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String phoneNumber;
    @Column(length = 500)
    private String address;
    private LocalDateTime registrationDate ;
    @Column(columnDefinition = "boolean default false")
    private Boolean graduated = false;

    private Training training ;
    
    private Diploma diploma ;
    

    private List<ModuleGrade> modulesGrades ;
    private List<SemesterAverage> semestersAverages ;
    private List<Payment> payments ;

    public Student(){
        super();
    }

    public Student(Long id,String cin){
        this.id = id;
        this.cin = cin ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="student_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public LocalDateTime getRegistrationDate(){
        return this.registrationDate;
    }
    public void setRegistrationDate(LocalDateTime registrationDate){
        this.registrationDate = registrationDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Training getTraining(){
        return this.training;
    }
    public void setTraining(Training training){
        this.training = training;
    }
    @OneToMany(mappedBy = "student")
    public List<ModuleGrade> getModulesGrades(){
        return this.modulesGrades;
    }
    public void setModulesGrades(List<ModuleGrade> modulesGrades){
        this.modulesGrades = modulesGrades;
    }
    @OneToMany(mappedBy = "student")
    public List<SemesterAverage> getSemestersAverages(){
        return this.semestersAverages;
    }
    public void setSemestersAverages(List<SemesterAverage> semestersAverages){
        this.semestersAverages = semestersAverages;
    }
    @OneToMany(mappedBy = "student")
    public List<Payment> getPayments(){
        return this.payments;
    }
    public void setPayments(List<Payment> payments){
        this.payments = payments;
    }
    public Boolean  getGraduated(){
        return this.graduated;
    }
    public void setGraduated(Boolean graduated){
        this.graduated = graduated;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Diploma getDiploma(){
        return this.diploma;
    }
    public void setDiploma(Diploma diploma){
        this.diploma = diploma;
    }

    @Transient
    public String getLabel() {
        label = cin;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id != null && id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

