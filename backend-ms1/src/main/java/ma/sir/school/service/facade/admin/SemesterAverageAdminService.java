package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.SemesterAverage;
import ma.sir.school.dao.criteria.core.SemesterAverageCriteria;
import ma.sir.school.dao.criteria.history.SemesterAverageHistoryCriteria;
import ma.sir.school.zynerator.service.IService;

import ma.sir.school.ws.dto.SemesterAverageDto;

public interface SemesterAverageAdminService extends  IService<SemesterAverage,SemesterAverageCriteria, SemesterAverageHistoryCriteria>  {

    List<SemesterAverage> findByStudentId(Long id);
    int deleteByStudentId(Long id);
    List<SemesterAverage> findBySemesterId(Long id);
    int deleteBySemesterId(Long id);

    HttpEntity<byte[]> createPdf(SemesterAverageDto dto) throws Exception;


}
