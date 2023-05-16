package  ma.sir.school.dao.criteria.core;


import ma.sir.school.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class StudentCriteria extends  BaseCriteria  {

    private String cin;
    private String cinLike;
    private String firstName;
    private String firstNameLike;
    private String lastName;
    private String lastNameLike;
    private String email;
    private String emailLike;
    private String phoneNumber;
    private String phoneNumberLike;
    private String address;
    private String addressLike;
    private LocalDateTime registrationDate;
    private LocalDateTime registrationDateFrom;
    private LocalDateTime registrationDateTo;
    private Boolean graduated;

    private TrainingCriteria training ;
    private List<TrainingCriteria> trainings ;
    private DiplomaCriteria diploma ;
    private List<DiplomaCriteria> diplomas ;


    public StudentCriteria(){}

    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getCinLike(){
        return this.cinLike;
    }
    public void setCinLike(String cinLike){
        this.cinLike = cinLike;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstNameLike(){
        return this.firstNameLike;
    }
    public void setFirstNameLike(String firstNameLike){
        this.firstNameLike = firstNameLike;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastNameLike(){
        return this.lastNameLike;
    }
    public void setLastNameLike(String lastNameLike){
        this.lastNameLike = lastNameLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumberLike(){
        return this.phoneNumberLike;
    }
    public void setPhoneNumberLike(String phoneNumberLike){
        this.phoneNumberLike = phoneNumberLike;
    }

    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddressLike(){
        return this.addressLike;
    }
    public void setAddressLike(String addressLike){
        this.addressLike = addressLike;
    }

    public LocalDateTime getRegistrationDate(){
        return this.registrationDate;
    }
    public void setRegistrationDate(LocalDateTime registrationDate){
        this.registrationDate = registrationDate;
    }
    public LocalDateTime getRegistrationDateFrom(){
        return this.registrationDateFrom;
    }
    public void setRegistrationDateFrom(LocalDateTime registrationDateFrom){
        this.registrationDateFrom = registrationDateFrom;
    }
    public LocalDateTime getRegistrationDateTo(){
        return this.registrationDateTo;
    }
    public void setRegistrationDateTo(LocalDateTime registrationDateTo){
        this.registrationDateTo = registrationDateTo;
    }
    public Boolean getGraduated(){
        return this.graduated;
    }
    public void setGraduated(Boolean graduated){
        this.graduated = graduated;
    }

    public TrainingCriteria getTraining(){
        return this.training;
    }

    public void setTraining(TrainingCriteria training){
        this.training = training;
    }
    public List<TrainingCriteria> getTrainings(){
        return this.trainings;
    }

    public void setTrainings(List<TrainingCriteria> trainings){
        this.trainings = trainings;
    }
    public DiplomaCriteria getDiploma(){
        return this.diploma;
    }

    public void setDiploma(DiplomaCriteria diploma){
        this.diploma = diploma;
    }
    public List<DiplomaCriteria> getDiplomas(){
        return this.diplomas;
    }

    public void setDiplomas(List<DiplomaCriteria> diplomas){
        this.diplomas = diplomas;
    }
}
