package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.ModuleGrade;
import ma.sir.school.bean.history.ModuleGradeHistory;
import ma.sir.school.dao.criteria.core.ModuleGradeCriteria;
import ma.sir.school.dao.criteria.history.ModuleGradeHistoryCriteria;
import ma.sir.school.dao.facade.core.ModuleGradeDao;
import ma.sir.school.dao.facade.history.ModuleGradeHistoryDao;
import ma.sir.school.dao.specification.core.ModuleGradeSpecification;
import ma.sir.school.service.facade.admin.ModuleGradeAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.school.zynerator.util.VelocityPdf;
import ma.sir.school.ws.dto.ModuleGradeDto;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.school.service.facade.admin.StudentAdminService ;
import ma.sir.school.service.facade.admin.SemesterAdminService ;
import ma.sir.school.service.facade.admin.ModuleAdminService ;


import java.util.List;
@Service
public class ModuleGradeAdminServiceImpl extends AbstractServiceImpl<ModuleGrade,ModuleGradeHistory, ModuleGradeCriteria, ModuleGradeHistoryCriteria, ModuleGradeDao,
ModuleGradeHistoryDao> implements ModuleGradeAdminService {
    public static final String TEMPLATE = "template/moduleGrade.vm";
    public static final String FILE_NAME = "moduleGrade.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ModuleGradeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<ModuleGrade> findByStudentId(Long id){
        return dao.findByStudentId(id);
    }
    public int deleteByStudentId(Long id){
        return dao.deleteByStudentId(id);
    }
    public List<ModuleGrade> findByModuleId(Long id){
        return dao.findByModuleId(id);
    }
    public int deleteByModuleId(Long id){
        return dao.deleteByModuleId(id);
    }
    public List<ModuleGrade> findBySemesterId(Long id){
        return dao.findBySemesterId(id);
    }
    public int deleteBySemesterId(Long id){
        return dao.deleteBySemesterId(id);
    }



    public void configure() {
        super.configure(ModuleGrade.class,ModuleGradeHistory.class, ModuleGradeHistoryCriteria.class, ModuleGradeSpecification.class);
    }

    @Autowired
    private StudentAdminService studentService ;
    @Autowired
    private SemesterAdminService semesterService ;
    @Autowired
    private ModuleAdminService moduleService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ModuleGradeAdminServiceImpl(ModuleGradeDao dao, ModuleGradeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}