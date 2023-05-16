package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.ExamGrade;
import ma.sir.school.bean.history.ExamGradeHistory;
import ma.sir.school.dao.criteria.core.ExamGradeCriteria;
import ma.sir.school.dao.criteria.history.ExamGradeHistoryCriteria;
import ma.sir.school.service.facade.admin.ExamGradeAdminService;
import ma.sir.school.ws.converter.ExamGradeConverter;
import ma.sir.school.ws.dto.ExamGradeDto;
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

@Api("Manages examGrade services")
@RestController
@RequestMapping("/api/admin/examGrade/")
public class ExamGradeRestAdmin  extends AbstractController<ExamGrade, ExamGradeDto, ExamGradeHistory, ExamGradeCriteria, ExamGradeHistoryCriteria, ExamGradeAdminService, ExamGradeConverter> {


    @ApiOperation("upload one examGrade")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple examGrades")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all examGrades")
    @GetMapping("")
    public ResponseEntity<List<ExamGradeDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a examGrade by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ExamGradeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  examGrade")
    @PostMapping("")
    public ResponseEntity<ExamGradeDto> save(@RequestBody ExamGradeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  examGrade")
    @PutMapping("")
    public ResponseEntity<ExamGradeDto> update(@RequestBody ExamGradeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of examGrade")
    @PostMapping("multiple")
    public ResponseEntity<List<ExamGradeDto>> delete(@RequestBody List<ExamGradeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified examGrade")
    @DeleteMapping("")
    public ResponseEntity<ExamGradeDto> delete(@RequestBody ExamGradeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified examGrade")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple examGrades by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by exam id")
    @GetMapping("exam/id/{id}")
    public List<ExamGrade> findByExamId(@PathVariable Long id){
        return service.findByExamId(id);
    }
    @ApiOperation("delete by exam id")
    @DeleteMapping("exam/id/{id}")
    public int deleteByExamId(@PathVariable Long id){
        return service.deleteByExamId(id);
    }
    @ApiOperation("find by student id")
    @GetMapping("student/id/{id}")
    public List<ExamGrade> findByStudentId(@PathVariable Long id){
        return service.findByStudentId(id);
    }
    @ApiOperation("delete by student id")
    @DeleteMapping("student/id/{id}")
    public int deleteByStudentId(@PathVariable Long id){
        return service.deleteByStudentId(id);
    }
    @ApiOperation("Finds examGrades by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ExamGradeDto>> findByCriteria(@RequestBody ExamGradeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated examGrades by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ExamGradeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports examGrades by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ExamGradeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets examGrade data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ExamGradeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets examGrade history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets examGrade paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ExamGradeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports examGrade history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ExamGradeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets examGrade history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ExamGradeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ExamGradeRestAdmin (ExamGradeAdminService service, ExamGradeConverter converter) {
        super(service, converter);
    }


}