import {Component, OnInit} from '@angular/core';
import {SemesterService} from 'src/app/controller/service/Semester.service';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterCriteria} from 'src/app/controller/criteria/SemesterCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { TrainingService } from 'src/app/controller/service/Training.service';

import {TrainingDto} from 'src/app/controller/model/Training.model';
import {ModuleDto} from 'src/app/controller/model/Module.model';


@Component({
  selector: 'app-semester-list-admin',
  templateUrl: './semester-list-admin.component.html'
})
export class SemesterListAdminComponent extends AbstractListController<SemesterDto, SemesterCriteria, SemesterService>  implements OnInit {

    fileName = 'Semester';

    trainings :Array<TrainingDto>;
  
    constructor(semesterService: SemesterService, private trainingService: TrainingService) {
        super(semesterService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadTraining();
    }

    public async loadSemesters(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Semester', 'list');
        isPermistted ? this.service.findAll().subscribe(semesters => this.items = semesters,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'startDate', header: 'Start date'},
            {field: 'endDate', header: 'End date'},
            {field: 'training?.libelle', header: 'Training'},
        ];
    }


    public async loadTraining(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Semester', 'list');
        isPermistted ? this.trainingService.findAllOptimized().subscribe(trainings => this.trainings = trainings,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SemesterDto) {
        if (res.modules != null) {
             res.modules.forEach(d => { d.semester = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                'Start date': this.datePipe.transform(e.startDate , 'dd/MM/yyyy hh:mm'),
                'End date': this.datePipe.transform(e.endDate , 'dd/MM/yyyy hh:mm'),
                'Training': e.training?.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Start date Min': this.criteria.startDateFrom ? this.datePipe.transform(this.criteria.startDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Start date Max': this.criteria.startDateTo ? this.datePipe.transform(this.criteria.startDateTo , this.dateFormat) : environment.emptyForExport ,
            'End date Min': this.criteria.endDateFrom ? this.datePipe.transform(this.criteria.endDateFrom , this.dateFormat) : environment.emptyForExport ,
            'End date Max': this.criteria.endDateTo ? this.datePipe.transform(this.criteria.endDateTo , this.dateFormat) : environment.emptyForExport ,
        //'Training': this.criteria.training?.libelle ? this.criteria.training?.libelle : environment.emptyForExport ,
        }];
      }
}
