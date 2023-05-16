package ma.sir.school.service.impl.admin;

import ma.sir.school.bean.core.Payment;
import ma.sir.school.bean.history.PaymentHistory;
import ma.sir.school.dao.criteria.core.PaymentCriteria;
import ma.sir.school.dao.criteria.history.PaymentHistoryCriteria;
import ma.sir.school.dao.facade.core.PaymentDao;
import ma.sir.school.dao.facade.history.PaymentHistoryDao;
import ma.sir.school.dao.specification.core.PaymentSpecification;
import ma.sir.school.service.facade.admin.PaymentAdminService;
import ma.sir.school.zynerator.service.AbstractServiceImpl;
import ma.sir.school.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.school.zynerator.util.VelocityPdf;
import ma.sir.school.ws.dto.PaymentDto;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.school.service.facade.admin.StudentAdminService ;
import ma.sir.school.service.facade.admin.SemesterAdminService ;
import ma.sir.school.service.facade.admin.TrainingAdminService ;


import java.util.List;
@Service
public class PaymentAdminServiceImpl extends AbstractServiceImpl<Payment,PaymentHistory, PaymentCriteria, PaymentHistoryCriteria, PaymentDao,
PaymentHistoryDao> implements PaymentAdminService {
    public static final String TEMPLATE = "template/payment.vm";
    public static final String FILE_NAME = "payment.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<Payment> findByStudentId(Long id){
        return dao.findByStudentId(id);
    }
    public int deleteByStudentId(Long id){
        return dao.deleteByStudentId(id);
    }
    public List<Payment> findByTrainingId(Long id){
        return dao.findByTrainingId(id);
    }
    public int deleteByTrainingId(Long id){
        return dao.deleteByTrainingId(id);
    }
    public List<Payment> findBySemesterId(Long id){
        return dao.findBySemesterId(id);
    }
    public int deleteBySemesterId(Long id){
        return dao.deleteBySemesterId(id);
    }



    public void configure() {
        super.configure(Payment.class,PaymentHistory.class, PaymentHistoryCriteria.class, PaymentSpecification.class);
    }

    @Autowired
    private StudentAdminService studentService ;
    @Autowired
    private SemesterAdminService semesterService ;
    @Autowired
    private TrainingAdminService trainingService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentAdminServiceImpl(PaymentDao dao, PaymentHistoryDao historyDao) {
        super(dao, historyDao);
    }

}