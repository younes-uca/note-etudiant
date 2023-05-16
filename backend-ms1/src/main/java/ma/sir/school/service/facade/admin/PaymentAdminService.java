package ma.sir.school.service.facade.admin;

import java.util.List;
import ma.sir.school.bean.core.Payment;
import ma.sir.school.dao.criteria.core.PaymentCriteria;
import ma.sir.school.dao.criteria.history.PaymentHistoryCriteria;
import ma.sir.school.zynerator.service.IService;

import ma.sir.school.ws.dto.PaymentDto;

public interface PaymentAdminService extends  IService<Payment,PaymentCriteria, PaymentHistoryCriteria>  {

    List<Payment> findByStudentId(Long id);
    int deleteByStudentId(Long id);
    List<Payment> findByTrainingId(Long id);
    int deleteByTrainingId(Long id);
    List<Payment> findBySemesterId(Long id);
    int deleteBySemesterId(Long id);

    HttpEntity<byte[]> createPdf(PaymentDto dto) throws Exception;


}
