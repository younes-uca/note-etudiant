import {Component, OnInit} from '@angular/core';
import {TrainingService} from 'src/app/controller/service/Training.service';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {TrainingCriteria} from 'src/app/controller/criteria/TrainingCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';


import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {StudentDto} from 'src/app/controller/model/Student.model';


@Component({
  selector: 'app-training-list-admin',
  templateUrl: './training-list-admin.component.html'
})
export class TrainingListAdminComponent extends AbstractListController<TrainingDto, TrainingCriteria, TrainingService>  implements OnInit {

    fileName = 'Training';

  
    constructor(trainingService: TrainingService) {
        super(trainingService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadTrainings(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Training', 'list');
        isPermistted ? this.service.findAll().subscribe(trainings => this.items = trainings,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'duration', header: 'Duration'},
            {field: 'trainingCost', header: 'Training cost'},
        ];
    }



	public initDuplicate(res: TrainingDto) {
        if (res.semesters != null) {
             res.semesters.forEach(d => { d.training = null; d.id = null; });
        }
        if (res.students != null) {
             res.students.forEach(d => { d.training = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                 'Duration': e.duration ,
                 'Training cost': e.trainingCost ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Duration Min': this.criteria.durationMin ? this.criteria.durationMin : environment.emptyForExport ,
            'Duration Max': this.criteria.durationMax ? this.criteria.durationMax : environment.emptyForExport ,
            'Training cost Min': this.criteria.trainingCostMin ? this.criteria.trainingCostMin : environment.emptyForExport ,
            'Training cost Max': this.criteria.trainingCostMax ? this.criteria.trainingCostMax : environment.emptyForExport ,
        }];
      }
}
