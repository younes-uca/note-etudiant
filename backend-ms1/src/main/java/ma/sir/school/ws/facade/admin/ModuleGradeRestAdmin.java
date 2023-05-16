package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.ModuleGrade;
import ma.sir.school.bean.history.ModuleGradeHistory;
import ma.sir.school.dao.criteria.core.ModuleGradeCriteria;
import ma.sir.school.dao.criteria.history.ModuleGradeHistoryCriteria;
import ma.sir.school.service.facade.admin.ModuleGradeAdminService;
import ma.sir.school.ws.converter.ModuleGradeConverter;
import ma.sir.school.ws.dto.ModuleGradeDto;
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

@Api("Manages moduleGrade services")
@RestController
@RequestMapping("/api/admin/moduleGrade/")
public class ModuleGradeRestAdmin  extends AbstractController<ModuleGrade, ModuleGradeDto, ModuleGradeHistory, ModuleGradeCriteria, ModuleGradeHistoryCriteria, ModuleGradeAdminService, ModuleGradeConverter> {


    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ModuleGradeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one moduleGrade")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple moduleGrades")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all moduleGrades")
    @GetMapping("")
    public ResponseEntity<List<ModuleGradeDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a moduleGrade by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ModuleGradeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  moduleGrade")
    @PostMapping("")
    public ResponseEntity<ModuleGradeDto> save(@RequestBody ModuleGradeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  moduleGrade")
    @PutMapping("")
    public ResponseEntity<ModuleGradeDto> update(@RequestBody ModuleGradeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of moduleGrade")
    @PostMapping("multiple")
    public ResponseEntity<List<ModuleGradeDto>> delete(@RequestBody List<ModuleGradeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified moduleGrade")
    @DeleteMapping("")
    public ResponseEntity<ModuleGradeDto> delete(@RequestBody ModuleGradeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified moduleGrade")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple moduleGrades by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by student id")
    @GetMapping("student/id/{id}")
    public List<ModuleGrade> findByStudentId(@PathVariable Long id){
        return service.findByStudentId(id);
    }
    @ApiOperation("delete by student id")
    @DeleteMapping("student/id/{id}")
    public int deleteByStudentId(@PathVariable Long id){
        return service.deleteByStudentId(id);
    }
    @ApiOperation("find by module id")
    @GetMapping("module/id/{id}")
    public List<ModuleGrade> findByModuleId(@PathVariable Long id){
        return service.findByModuleId(id);
    }
    @ApiOperation("delete by module id")
    @DeleteMapping("module/id/{id}")
    public int deleteByModuleId(@PathVariable Long id){
        return service.deleteByModuleId(id);
    }
    @ApiOperation("find by semester id")
    @GetMapping("semester/id/{id}")
    public List<ModuleGrade> findBySemesterId(@PathVariable Long id){
        return service.findBySemesterId(id);
    }
    @ApiOperation("delete by semester id")
    @DeleteMapping("semester/id/{id}")
    public int deleteBySemesterId(@PathVariable Long id){
        return service.deleteBySemesterId(id);
    }
    @ApiOperation("Finds moduleGrades by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ModuleGradeDto>> findByCriteria(@RequestBody ModuleGradeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated moduleGrades by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ModuleGradeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports moduleGrades by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ModuleGradeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets moduleGrade data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ModuleGradeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets moduleGrade history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets moduleGrade paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ModuleGradeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports moduleGrade history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ModuleGradeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets moduleGrade history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ModuleGradeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ModuleGradeRestAdmin (ModuleGradeAdminService service, ModuleGradeConverter converter) {
        super(service, converter);
    }


}