package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.Exam;
import ma.sir.school.bean.history.ExamHistory;
import ma.sir.school.dao.criteria.core.ExamCriteria;
import ma.sir.school.dao.criteria.history.ExamHistoryCriteria;
import ma.sir.school.service.facade.admin.ExamAdminService;
import ma.sir.school.ws.converter.ExamConverter;
import ma.sir.school.ws.dto.ExamDto;
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

@Api("Manages exam services")
@RestController
@RequestMapping("/api/admin/exam/")
public class ExamRestAdmin  extends AbstractController<Exam, ExamDto, ExamHistory, ExamCriteria, ExamHistoryCriteria, ExamAdminService, ExamConverter> {


    @ApiOperation("upload one exam")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple exams")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all exams")
    @GetMapping("")
    public ResponseEntity<List<ExamDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a exam by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ExamDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  exam")
    @PostMapping("")
    public ResponseEntity<ExamDto> save(@RequestBody ExamDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  exam")
    @PutMapping("")
    public ResponseEntity<ExamDto> update(@RequestBody ExamDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of exam")
    @PostMapping("multiple")
    public ResponseEntity<List<ExamDto>> delete(@RequestBody List<ExamDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified exam")
    @DeleteMapping("")
    public ResponseEntity<ExamDto> delete(@RequestBody ExamDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified exam")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple exams by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by module id")
    @GetMapping("module/id/{id}")
    public List<Exam> findByModuleId(@PathVariable Long id){
        return service.findByModuleId(id);
    }
    @ApiOperation("delete by module id")
    @DeleteMapping("module/id/{id}")
    public int deleteByModuleId(@PathVariable Long id){
        return service.deleteByModuleId(id);
    }
    @ApiOperation("find by semester id")
    @GetMapping("semester/id/{id}")
    public List<Exam> findBySemesterId(@PathVariable Long id){
        return service.findBySemesterId(id);
    }
    @ApiOperation("delete by semester id")
    @DeleteMapping("semester/id/{id}")
    public int deleteBySemesterId(@PathVariable Long id){
        return service.deleteBySemesterId(id);
    }
    @ApiOperation("Finds a exam and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ExamDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds exams by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ExamDto>> findByCriteria(@RequestBody ExamCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated exams by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ExamCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports exams by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ExamCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets exam data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ExamCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets exam history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets exam paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ExamHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports exam history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ExamHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets exam history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ExamHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ExamRestAdmin (ExamAdminService service, ExamConverter converter) {
        super(service, converter);
    }


}