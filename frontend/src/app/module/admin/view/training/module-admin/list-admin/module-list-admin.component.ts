import {Component, OnInit} from '@angular/core';
import {ModuleService} from 'src/app/controller/service/Module.service';
import {ModuleDto} from 'src/app/controller/model/Module.model';
import {ModuleCriteria} from 'src/app/controller/criteria/ModuleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';


import {TrainingDto} from 'src/app/controller/model/Training.model';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {ExamDto} from 'src/app/controller/model/Exam.model';


@Component({
  selector: 'app-module-list-admin',
  templateUrl: './module-list-admin.component.html'
})
export class ModuleListAdminComponent extends AbstractListController<ModuleDto, ModuleCriteria, ModuleService>  implements OnInit {

    fileName = 'Module';

  
    constructor(moduleService: ModuleService) {
        super(moduleService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadModules(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Module', 'list');
        isPermistted ? this.service.findAll().subscribe(modules => this.items = modules,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: ModuleDto) {
        if (res.trainings != null) {
             res.trainings.forEach(d => { d.module = null; d.id = null; });
        }
        if (res.semesters != null) {
             res.semesters.forEach(d => { d.module = null; d.id = null; });
        }
        if (res.exams != null) {
             res.exams.forEach(d => { d.module = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
