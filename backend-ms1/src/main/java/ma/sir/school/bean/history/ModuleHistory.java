package ma.sir.school.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.school.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "module")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="module_seq",sequenceName="module_seq",allocationSize=1, initialValue = 1)
public class ModuleHistory extends HistBusinessObject  {


    public ModuleHistory() {
    super();
    }

    public ModuleHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="module_seq")
    public Long getId() {
    return id;
    }
}

