package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.SemesterAverage;
import ma.sir.school.bean.history.SemesterAverageHistory;
import ma.sir.school.dao.criteria.core.SemesterAverageCriteria;
import ma.sir.school.dao.criteria.history.SemesterAverageHistoryCriteria;
import ma.sir.school.service.facade.admin.SemesterAverageAdminService;
import ma.sir.school.ws.converter.SemesterAverageConverter;
import ma.sir.school.ws.dto.SemesterAverageDto;
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

@Api("Manages semesterAverage services")
@RestController
@RequestMapping("/api/admin/semesterAverage/")
public class SemesterAverageRestAdmin  extends AbstractController<SemesterAverage, SemesterAverageDto, SemesterAverageHistory, SemesterAverageCriteria, SemesterAverageHistoryCriteria, SemesterAverageAdminService, SemesterAverageConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody SemesterAverageDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one semesterAverage")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple semesterAverages")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all semesterAverages")
    @GetMapping("")
    public ResponseEntity<List<SemesterAverageDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a semesterAverage by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SemesterAverageDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  semesterAverage")
    @PostMapping("")
    public ResponseEntity<SemesterAverageDto> save(@RequestBody SemesterAverageDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  semesterAverage")
    @PutMapping("")
    public ResponseEntity<SemesterAverageDto> update(@RequestBody SemesterAverageDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of semesterAverage")
    @PostMapping("multiple")
    public ResponseEntity<List<SemesterAverageDto>> delete(@RequestBody List<SemesterAverageDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified semesterAverage")
    @DeleteMapping("")
    public ResponseEntity<SemesterAverageDto> delete(@RequestBody SemesterAverageDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified semesterAverage")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple semesterAverages by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by student id")
    @GetMapping("student/id/{id}")
    public List<SemesterAverage> findByStudentId(@PathVariable Long id){
        return service.findByStudentId(id);
    }
    @ApiOperation("delete by student id")
    @DeleteMapping("student/id/{id}")
    public int deleteByStudentId(@PathVariable Long id){
        return service.deleteByStudentId(id);
    }
    @ApiOperation("find by semester id")
    @GetMapping("semester/id/{id}")
    public List<SemesterAverage> findBySemesterId(@PathVariable Long id){
        return service.findBySemesterId(id);
    }
    @ApiOperation("delete by semester id")
    @DeleteMapping("semester/id/{id}")
    public int deleteBySemesterId(@PathVariable Long id){
        return service.deleteBySemesterId(id);
    }
    @ApiOperation("Finds semesterAverages by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SemesterAverageDto>> findByCriteria(@RequestBody SemesterAverageCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated semesterAverages by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SemesterAverageCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports semesterAverages by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SemesterAverageCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets semesterAverage data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SemesterAverageCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets semesterAverage history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets semesterAverage paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SemesterAverageHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports semesterAverage history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SemesterAverageHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets semesterAverage history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SemesterAverageHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SemesterAverageRestAdmin (SemesterAverageAdminService service, SemesterAverageConverter converter) {
        super(service, converter);
    }


}