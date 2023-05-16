package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.Module;
import ma.sir.school.dao.criteria.core.ModuleCriteria;
import ma.sir.school.dao.criteria.history.ModuleHistoryCriteria;
import ma.sir.school.zynerator.service.IService;


public interface ModuleAdminService extends  IService<Module,ModuleCriteria, ModuleHistoryCriteria>  {




}
