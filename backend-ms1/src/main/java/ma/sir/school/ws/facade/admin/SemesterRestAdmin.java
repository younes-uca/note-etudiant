package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.Semester;
import ma.sir.school.bean.history.SemesterHistory;
import ma.sir.school.dao.criteria.core.SemesterCriteria;
import ma.sir.school.dao.criteria.history.SemesterHistoryCriteria;
import ma.sir.school.service.facade.admin.SemesterAdminService;
import ma.sir.school.ws.converter.SemesterConverter;
import ma.sir.school.ws.dto.SemesterDto;
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

@Api("Manages semester services")
@RestController
@RequestMapping("/api/admin/semester/")
public class SemesterRestAdmin  extends AbstractController<Semester, SemesterDto, SemesterHistory, SemesterCriteria, SemesterHistoryCriteria, SemesterAdminService, SemesterConverter> {


    @ApiOperation("upload one semester")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple semesters")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all semesters")
    @GetMapping("")
    public ResponseEntity<List<SemesterDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all semesters")
    @GetMapping("optimized")
    public ResponseEntity<List<SemesterDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a semester by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SemesterDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  semester")
    @PostMapping("")
    public ResponseEntity<SemesterDto> save(@RequestBody SemesterDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  semester")
    @PutMapping("")
    public ResponseEntity<SemesterDto> update(@RequestBody SemesterDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of semester")
    @PostMapping("multiple")
    public ResponseEntity<List<SemesterDto>> delete(@RequestBody List<SemesterDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified semester")
    @DeleteMapping("")
    public ResponseEntity<SemesterDto> delete(@RequestBody SemesterDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified semester")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple semesters by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by training id")
    @GetMapping("training/id/{id}")
    public List<Semester> findByTrainingId(@PathVariable Long id){
        return service.findByTrainingId(id);
    }
    @ApiOperation("delete by training id")
    @DeleteMapping("training/id/{id}")
    public int deleteByTrainingId(@PathVariable Long id){
        return service.deleteByTrainingId(id);
    }
    @ApiOperation("Finds a semester and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<SemesterDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds semesters by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SemesterDto>> findByCriteria(@RequestBody SemesterCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated semesters by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SemesterCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports semesters by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SemesterCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets semester data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SemesterCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets semester history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets semester paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SemesterHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports semester history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SemesterHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets semester history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SemesterHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SemesterRestAdmin (SemesterAdminService service, SemesterConverter converter) {
        super(service, converter);
    }


}