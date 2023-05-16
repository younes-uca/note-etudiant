package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "payment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_seq",sequenceName="payment_seq",allocationSize=1, initialValue = 1)
public class PaymentHistory extends HistBusinessObject  {


    public PaymentHistory() {
    super();
    }

    public PaymentHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_seq")
    public Long getId() {
    return id;
    }
}

