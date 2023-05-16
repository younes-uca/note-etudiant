package  ma.sir.school.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.school.bean.core.Module;
import ma.sir.school.bean.history.ModuleHistory;
import ma.sir.school.dao.criteria.core.ModuleCriteria;
import ma.sir.school.dao.criteria.history.ModuleHistoryCriteria;
import ma.sir.school.service.facade.admin.ModuleAdminService;
import ma.sir.school.ws.converter.ModuleConverter;
import ma.sir.school.ws.dto.ModuleDto;
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

@Api("Manages module services")
@RestController
@RequestMapping("/api/admin/module/")
public class ModuleRestAdmin  extends AbstractController<Module, ModuleDto, ModuleHistory, ModuleCriteria, ModuleHistoryCriteria, ModuleAdminService, ModuleConverter> {


    @ApiOperation("upload one module")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple modules")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all modules")
    @GetMapping("")
    public ResponseEntity<List<ModuleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all modules")
    @GetMapping("optimized")
    public ResponseEntity<List<ModuleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a module by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ModuleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  module")
    @PostMapping("")
    public ResponseEntity<ModuleDto> save(@RequestBody ModuleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  module")
    @PutMapping("")
    public ResponseEntity<ModuleDto> update(@RequestBody ModuleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of module")
    @PostMapping("multiple")
    public ResponseEntity<List<ModuleDto>> delete(@RequestBody List<ModuleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified module")
    @DeleteMapping("")
    public ResponseEntity<ModuleDto> delete(@RequestBody ModuleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified module")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple modules by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds a module and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ModuleDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds modules by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ModuleDto>> findByCriteria(@RequestBody ModuleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated modules by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ModuleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports modules by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ModuleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets module data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ModuleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets module history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets module paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ModuleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports module history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ModuleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets module history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ModuleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ModuleRestAdmin (ModuleAdminService service, ModuleConverter converter) {
        super(service, converter);
    }


}