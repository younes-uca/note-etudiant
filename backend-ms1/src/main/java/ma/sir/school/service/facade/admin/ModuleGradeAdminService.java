package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.ModuleGrade;
import ma.sir.school.dao.criteria.core.ModuleGradeCriteria;
import ma.sir.school.dao.criteria.history.ModuleGradeHistoryCriteria;
import ma.sir.school.zynerator.service.IService;

import ma.sir.school.ws.dto.ModuleGradeDto;

public interface ModuleGradeAdminService extends  IService<ModuleGrade,ModuleGradeCriteria, ModuleGradeHistoryCriteria>  {

    List<ModuleGrade> findByStudentId(Long id);
    int deleteByStudentId(Long id);
    List<ModuleGrade> findByModuleId(Long id);
    int deleteByModuleId(Long id);
    List<ModuleGrade> findBySemesterId(Long id);
    int deleteBySemesterId(Long id);

    HttpEntity<byte[]> createPdf(ModuleGradeDto dto) throws Exception;


}
