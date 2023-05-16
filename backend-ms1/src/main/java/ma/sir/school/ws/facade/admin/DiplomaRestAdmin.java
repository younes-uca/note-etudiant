package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.Diploma;
import ma.sir.school.bean.history.DiplomaHistory;
import ma.sir.school.dao.criteria.core.DiplomaCriteria;
import ma.sir.school.dao.criteria.history.DiplomaHistoryCriteria;
import ma.sir.school.service.facade.admin.DiplomaAdminService;
import ma.sir.school.ws.converter.DiplomaConverter;
import ma.sir.school.ws.dto.DiplomaDto;
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

@Api("Manages diploma services")
@RestController
@RequestMapping("/api/admin/diploma/")
public class DiplomaRestAdmin  extends AbstractController<Diploma, DiplomaDto, DiplomaHistory, DiplomaCriteria, DiplomaHistoryCriteria, DiplomaAdminService, DiplomaConverter> {


    @ApiOperation("upload one diploma")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple diplomas")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all diplomas")
    @GetMapping("")
    public ResponseEntity<List<DiplomaDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a diploma by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DiplomaDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  diploma")
    @PostMapping("")
    public ResponseEntity<DiplomaDto> save(@RequestBody DiplomaDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  diploma")
    @PutMapping("")
    public ResponseEntity<DiplomaDto> update(@RequestBody DiplomaDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of diploma")
    @PostMapping("multiple")
    public ResponseEntity<List<DiplomaDto>> delete(@RequestBody List<DiplomaDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified diploma")
    @DeleteMapping("")
    public ResponseEntity<DiplomaDto> delete(@RequestBody DiplomaDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified diploma")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple diplomas by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by student id")
    @GetMapping("student/id/{id}")
    public List<Diploma> findByStudentId(@PathVariable Long id){
        return service.findByStudentId(id);
    }
    @ApiOperation("delete by student id")
    @DeleteMapping("student/id/{id}")
    public int deleteByStudentId(@PathVariable Long id){
        return service.deleteByStudentId(id);
    }
    @ApiOperation("find by training id")
    @GetMapping("training/id/{id}")
    public List<Diploma> findByTrainingId(@PathVariable Long id){
        return service.findByTrainingId(id);
    }
    @ApiOperation("delete by training id")
    @DeleteMapping("training/id/{id}")
    public int deleteByTrainingId(@PathVariable Long id){
        return service.deleteByTrainingId(id);
    }
    @ApiOperation("Finds diplomas by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DiplomaDto>> findByCriteria(@RequestBody DiplomaCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated diplomas by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DiplomaCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports diplomas by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DiplomaCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets diploma data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DiplomaCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets diploma history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets diploma paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DiplomaHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports diploma history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DiplomaHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets diploma history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DiplomaHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DiplomaRestAdmin (DiplomaAdminService service, DiplomaConverter converter) {
        super(service, converter);
    }


}