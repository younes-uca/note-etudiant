package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="student_seq",sequenceName="student_seq",allocationSize=1, initialValue = 1)
public class StudentHistory extends HistBusinessObject  {


    public StudentHistory() {
    super();
    }

    public StudentHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="student_seq")
    public Long getId() {
    return id;
    }
}

