package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "exam_grade")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="exam_grade_seq",sequenceName="exam_grade_seq",allocationSize=1, initialValue = 1)
public class ExamGradeHistory extends HistBusinessObject  {


    public ExamGradeHistory() {
    super();
    }

    public ExamGradeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="exam_grade_seq")
    public Long getId() {
    return id;
    }
}

