package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "exam")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="exam_seq",sequenceName="exam_seq",allocationSize=1, initialValue = 1)
public class ExamHistory extends HistBusinessObject  {


    public ExamHistory() {
    super();
    }

    public ExamHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="exam_seq")
    public Long getId() {
    return id;
    }
}

