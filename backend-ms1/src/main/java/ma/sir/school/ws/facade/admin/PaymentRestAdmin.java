package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.Payment;
import ma.sir.school.bean.history.PaymentHistory;
import ma.sir.school.dao.criteria.core.PaymentCriteria;
import ma.sir.school.dao.criteria.history.PaymentHistoryCriteria;
import ma.sir.school.service.facade.admin.PaymentAdminService;
import ma.sir.school.ws.converter.PaymentConverter;
import ma.sir.school.ws.dto.PaymentDto;
import ma.sir.school.zynerator.controller.AbstractController;
import ma.sir.school.zynerator.dto.AuditEntityDto;
import ma.sir.school.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.school.zynerator.process.Result;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.school.zynerator.dto.FileTempDto;

@Api("Manages payment services")
@RestController
@RequestMapping("/api/admin/payment/")
public class PaymentRestAdmin  extends AbstractController<Payment, PaymentDto, PaymentHistory, PaymentCriteria, PaymentHistoryCriteria, PaymentAdminService, PaymentConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaymentDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one payment")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple payments")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all payments")
    @GetMapping("")
    public ResponseEntity<List<PaymentDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a payment by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaymentDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  payment")
    @PostMapping("")
    public ResponseEntity<PaymentDto> save(@RequestBody PaymentDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  payment")
    @PutMapping("")
    public ResponseEntity<PaymentDto> update(@RequestBody PaymentDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of payment")
    @PostMapping("multiple")
    public ResponseEntity<List<PaymentDto>> delete(@RequestBody List<PaymentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified payment")
    @DeleteMapping("")
    public ResponseEntity<PaymentDto> delete(@RequestBody PaymentDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified payment")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple payments by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by student id")
    @GetMapping("student/id/{id}")
    public List<Payment> findByStudentId(@PathVariable Long id){
        return service.findByStudentId(id);
    }
    @ApiOperation("delete by student id")
    @DeleteMapping("student/id/{id}")
    public int deleteByStudentId(@PathVariable Long id){
        return service.deleteByStudentId(id);
    }
    @ApiOperation("find by Training id")
    @GetMapping("training/id/{id}")
    public List<Payment> findByTrainingId(@PathVariable Long id){
        return service.findByTrainingId(id);
    }
    @ApiOperation("delete by Training id")
    @DeleteMapping("training/id/{id}")
    public int deleteByTrainingId(@PathVariable Long id){
        return service.deleteByTrainingId(id);
    }
    @ApiOperation("find by semester id")
    @GetMapping("semester/id/{id}")
    public List<Payment> findBySemesterId(@PathVariable Long id){
        return service.findBySemesterId(id);
    }
    @ApiOperation("delete by semester id")
    @DeleteMapping("semester/id/{id}")
    public int deleteBySemesterId(@PathVariable Long id){
        return service.deleteBySemesterId(id);
    }
    @ApiOperation("Finds payments by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaymentDto>> findByCriteria(@RequestBody PaymentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated payments by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaymentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports payments by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaymentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets payment data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaymentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets payment history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets payment paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody PaymentHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports payment history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody PaymentHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets payment history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody PaymentHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public PaymentRestAdmin (PaymentAdminService service, PaymentConverter converter) {
        super(service, converter);
    }


}