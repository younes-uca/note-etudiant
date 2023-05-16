package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "module_grade")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="module_grade_seq",sequenceName="module_grade_seq",allocationSize=1, initialValue = 1)
public class ModuleGradeHistory extends HistBusinessObject  {


    public ModuleGradeHistory() {
    super();
    }

    public ModuleGradeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="module_grade_seq")
    public Long getId() {
    return id;
    }
}

