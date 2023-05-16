package ma.sir.school.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.school.zynerator.repository.AbstractRepository;
import ma.sir.school.bean.core.Module;
import org.springframework.stereotype.Repository;
import ma.sir.school.bean.core.Module;
import java.util.List;


@Repository
public interface ModuleDao extends AbstractRepository<Module,Long>  {
    Module findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Module(item.id,item.libelle) FROM Module item")
    List<Module> findAllOptimized();
}
