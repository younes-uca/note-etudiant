package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "training")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="training_seq",sequenceName="training_seq",allocationSize=1, initialValue = 1)
public class TrainingHistory extends HistBusinessObject  {


    public TrainingHistory() {
    super();
    }

    public TrainingHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="training_seq")
    public Long getId() {
    return id;
    }
}

