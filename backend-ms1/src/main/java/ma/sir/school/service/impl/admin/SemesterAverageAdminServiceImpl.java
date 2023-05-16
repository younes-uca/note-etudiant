package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.SemesterAverage;
import ma.sir.school.bean.history.SemesterAverageHistory;
import ma.sir.school.dao.criteria.core.SemesterAverageCriteria;
import ma.sir.school.dao.criteria.history.SemesterAverageHistoryCriteria;
import ma.sir.school.dao.facade.core.SemesterAverageDao;
import ma.sir.school.dao.facade.history.SemesterAverageHistoryDao;
import ma.sir.school.dao.specification.core.SemesterAverageSpecification;
import ma.sir.school.service.facade.admin.SemesterAverageAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.school.zynerator.util.VelocityPdf;
import ma.sir.school.ws.dto.SemesterAverageDto;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.school.service.facade.admin.StudentAdminService ;
import ma.sir.school.service.facade.admin.SemesterAdminService ;


import java.util.List;
@Service
public class SemesterAverageAdminServiceImpl extends AbstractServiceImpl<SemesterAverage,SemesterAverageHistory, SemesterAverageCriteria, SemesterAverageHistoryCriteria, SemesterAverageDao,
SemesterAverageHistoryDao> implements SemesterAverageAdminService {
    public static final String TEMPLATE = "template/semesterAverage.vm";
    public static final String FILE_NAME = "semesterAverage.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SemesterAverageDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<SemesterAverage> findByStudentId(Long id){
        return dao.findByStudentId(id);
    }
    public int deleteByStudentId(Long id){
        return dao.deleteByStudentId(id);
    }
    public List<SemesterAverage> findBySemesterId(Long id){
        return dao.findBySemesterId(id);
    }
    public int deleteBySemesterId(Long id){
        return dao.deleteBySemesterId(id);
    }



    public void configure() {
        super.configure(SemesterAverage.class,SemesterAverageHistory.class, SemesterAverageHistoryCriteria.class, SemesterAverageSpecification.class);
    }

    @Autowired
    private StudentAdminService studentService ;
    @Autowired
    private SemesterAdminService semesterService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SemesterAverageAdminServiceImpl(SemesterAverageDao dao, SemesterAverageHistoryDao historyDao) {
        super(dao, historyDao);
    }

}