package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.Student;
import ma.sir.school.bean.history.StudentHistory;
import ma.sir.school.dao.criteria.core.StudentCriteria;
import ma.sir.school.dao.criteria.history.StudentHistoryCriteria;
import ma.sir.school.service.facade.admin.StudentAdminService;
import ma.sir.school.ws.converter.StudentConverter;
import ma.sir.school.ws.dto.StudentDto;
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

@Api("Manages student services")
@RestController
@RequestMapping("/api/admin/student/")
public class StudentRestAdmin  extends AbstractController<Student, StudentDto, StudentHistory, StudentCriteria, StudentHistoryCriteria, StudentAdminService, StudentConverter> {


    @ApiOperation("upload one student")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple students")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all students")
    @GetMapping("")
    public ResponseEntity<List<StudentDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all students")
    @GetMapping("optimized")
    public ResponseEntity<List<StudentDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a student by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  student")
    @PostMapping("")
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  student")
    @PutMapping("")
    public ResponseEntity<StudentDto> update(@RequestBody StudentDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of student")
    @PostMapping("multiple")
    public ResponseEntity<List<StudentDto>> delete(@RequestBody List<StudentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified student")
    @DeleteMapping("")
    public ResponseEntity<StudentDto> delete(@RequestBody StudentDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified student")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple students by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by training id")
    @GetMapping("training/id/{id}")
    public List<Student> findByTrainingId(@PathVariable Long id){
        return service.findByTrainingId(id);
    }
    @ApiOperation("delete by training id")
    @DeleteMapping("training/id/{id}")
    public int deleteByTrainingId(@PathVariable Long id){
        return service.deleteByTrainingId(id);
    }
    @ApiOperation("find by diploma id")
    @GetMapping("diploma/id/{id}")
    public List<Student> findByDiplomaId(@PathVariable Long id){
        return service.findByDiplomaId(id);
    }
    @ApiOperation("delete by diploma id")
    @DeleteMapping("diploma/id/{id}")
    public int deleteByDiplomaId(@PathVariable Long id){
        return service.deleteByDiplomaId(id);
    }
    @ApiOperation("Finds a student and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<StudentDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds students by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StudentDto>> findByCriteria(@RequestBody StudentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated students by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StudentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports students by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StudentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets student data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StudentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets student history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets student paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StudentHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports student history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StudentHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets student history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StudentHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public StudentRestAdmin (StudentAdminService service, StudentConverter converter) {
        super(service, converter);
    }


}