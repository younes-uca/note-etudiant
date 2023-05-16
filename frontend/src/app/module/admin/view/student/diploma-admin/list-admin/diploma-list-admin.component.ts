import {Component, OnInit} from '@angular/core';
import {DiplomaService} from 'src/app/controller/service/Diploma.service';
import {DiplomaDto} from 'src/app/controller/model/Diploma.model';
import {DiplomaCriteria} from 'src/app/controller/criteria/DiplomaCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StudentService } from 'src/app/controller/service/Student.service';
import { TrainingService } from 'src/app/controller/service/Training.service';

import {TrainingDto} from 'src/app/controller/model/Training.model';
import {StudentDto} from 'src/app/controller/model/Student.model';


@Component({
  selector: 'app-diploma-list-admin',
  templateUrl: './diploma-list-admin.component.html'
})
export class DiplomaListAdminComponent extends AbstractListController<DiplomaDto, DiplomaCriteria, DiplomaService>  implements OnInit {

    fileName = 'Diploma';

    students :Array<StudentDto>;
    trainings :Array<TrainingDto>;
  
    constructor(diplomaService: DiplomaService, private studentService: StudentService, private trainingService: TrainingService) {
        super(diplomaService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStudent();
      this.loadTraining();
    }

    public async loadDiplomas(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Diploma', 'list');
        isPermistted ? this.service.findAll().subscribe(diplomas => this.items = diplomas,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'student?.cin', header: 'Student'},
            {field: 'training?.libelle', header: 'Training'},
            {field: 'dateIssued', header: 'Date issued'},
        ];
    }


    public async loadStudent(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Diploma', 'list');
        isPermistted ? this.studentService.findAllOptimized().subscribe(students => this.students = students,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadTraining(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Diploma', 'list');
        isPermistted ? this.trainingService.findAllOptimized().subscribe(trainings => this.trainings = trainings,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DiplomaDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Student': e.student?.cin ,
                'Training': e.training?.libelle ,
                'Date issued': this.datePipe.transform(e.dateIssued , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
        //'Student': this.criteria.student?.cin ? this.criteria.student?.cin : environment.emptyForExport ,
        //'Training': this.criteria.training?.libelle ? this.criteria.training?.libelle : environment.emptyForExport ,
            'Date issued Min': this.criteria.dateIssuedFrom ? this.datePipe.transform(this.criteria.dateIssuedFrom , this.dateFormat) : environment.emptyForExport ,
            'Date issued Max': this.criteria.dateIssuedTo ? this.datePipe.transform(this.criteria.dateIssuedTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
