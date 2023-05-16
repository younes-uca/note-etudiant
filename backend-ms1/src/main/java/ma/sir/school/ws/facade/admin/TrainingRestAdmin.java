package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.Training;
import ma.sir.school.bean.history.TrainingHistory;
import ma.sir.school.dao.criteria.core.TrainingCriteria;
import ma.sir.school.dao.criteria.history.TrainingHistoryCriteria;
import ma.sir.school.service.facade.admin.TrainingAdminService;
import ma.sir.school.ws.converter.TrainingConverter;
import ma.sir.school.ws.dto.TrainingDto;
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

@Api("Manages training services")
@RestController
@RequestMapping("/api/admin/training/")
public class TrainingRestAdmin  extends AbstractController<Training, TrainingDto, TrainingHistory, TrainingCriteria, TrainingHistoryCriteria, TrainingAdminService, TrainingConverter> {


    @ApiOperation("upload one training")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple trainings")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all trainings")
    @GetMapping("")
    public ResponseEntity<List<TrainingDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all trainings")
    @GetMapping("optimized")
    public ResponseEntity<List<TrainingDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a training by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TrainingDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  training")
    @PostMapping("")
    public ResponseEntity<TrainingDto> save(@RequestBody TrainingDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  training")
    @PutMapping("")
    public ResponseEntity<TrainingDto> update(@RequestBody TrainingDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of training")
    @PostMapping("multiple")
    public ResponseEntity<List<TrainingDto>> delete(@RequestBody List<TrainingDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified training")
    @DeleteMapping("")
    public ResponseEntity<TrainingDto> delete(@RequestBody TrainingDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified training")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple trainings by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds a training and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TrainingDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds trainings by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TrainingDto>> findByCriteria(@RequestBody TrainingCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated trainings by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TrainingCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports trainings by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TrainingCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets training data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TrainingCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets training history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets training paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TrainingHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports training history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TrainingHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets training history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TrainingHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TrainingRestAdmin (TrainingAdminService service, TrainingConverter converter) {
        super(service, converter);
    }


}