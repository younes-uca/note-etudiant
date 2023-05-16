package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "diploma")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="diploma_seq",sequenceName="diploma_seq",allocationSize=1, initialValue = 1)
public class DiplomaHistory extends HistBusinessObject  {


    public DiplomaHistory() {
    super();
    }

    public DiplomaHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="diploma_seq")
    public Long getId() {
    return id;
    }
}

