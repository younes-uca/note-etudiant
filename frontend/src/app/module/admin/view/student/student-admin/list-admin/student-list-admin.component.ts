import {Component, OnInit} from '@angular/core';
import {StudentService} from 'src/app/controller/service/Student.service';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentCriteria} from 'src/app/controller/criteria/StudentCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { TrainingService } from 'src/app/controller/service/Training.service';
import { DiplomaService } from 'src/app/controller/service/Diploma.service';

import {DiplomaDto} from 'src/app/controller/model/Diploma.model';
import {PaymentDto} from 'src/app/controller/model/Payment.model';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {ModuleGradeDto} from 'src/app/controller/model/ModuleGrade.model';
import {SemesterAverageDto} from 'src/app/controller/model/SemesterAverage.model';


@Component({
  selector: 'app-student-list-admin',
  templateUrl: './student-list-admin.component.html'
})
export class StudentListAdminComponent extends AbstractListController<StudentDto, StudentCriteria, StudentService>  implements OnInit {

    fileName = 'Student';

     yesOrNoGraduated :any[] =[];
    trainings :Array<TrainingDto>;
    diplomas :Array<DiplomaDto>;
  
    constructor(studentService: StudentService, private trainingService: TrainingService, private diplomaService: DiplomaService) {
        super(studentService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadTraining();
      this.loadDiploma();
    this.yesOrNoGraduated =  [{label: 'Graduated', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadStudents(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Student', 'list');
        isPermistted ? this.service.findAll().subscribe(students => this.items = students,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'firstName', header: 'First name'},
            {field: 'lastName', header: 'Last name'},
            {field: 'email', header: 'Email'},
            {field: 'phoneNumber', header: 'Phone number'},
            {field: 'address', header: 'Address'},
            {field: 'registrationDate', header: 'Registration date'},
            {field: 'training?.libelle', header: 'Training'},
            {field: 'graduated', header: 'Graduated'},
            {field: 'diploma?.id', header: 'Diploma'},
        ];
    }


    public async loadTraining(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Student', 'list');
        isPermistted ? this.trainingService.findAllOptimized().subscribe(trainings => this.trainings = trainings,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadDiploma(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Student', 'list');
        isPermistted ? this.diplomaService.findAll().subscribe(diplomas => this.diplomas = diplomas,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: StudentDto) {
        if (res.modulesGrades != null) {
             res.modulesGrades.forEach(d => { d.student = null; d.id = null; });
        }
        if (res.semestersAverages != null) {
             res.semestersAverages.forEach(d => { d.student = null; d.id = null; });
        }
        if (res.payments != null) {
             res.payments.forEach(d => { d.student = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Cin': e.cin ,
                 'First name': e.firstName ,
                 'Last name': e.lastName ,
                 'Email': e.email ,
                 'Phone number': e.phoneNumber ,
                 'Address': e.address ,
                'Registration date': this.datePipe.transform(e.registrationDate , 'dd/MM/yyyy hh:mm'),
                'Training': e.training?.libelle ,
                'Graduated': e.graduated? 'Vrai' : 'Faux' ,
                'Diploma': e.diploma?.id ,
            }
        });

        this.criteriaData = [{
            'Cin': this.criteria.cin ? this.criteria.cin : environment.emptyForExport ,
            'First name': this.criteria.firstName ? this.criteria.firstName : environment.emptyForExport ,
            'Last name': this.criteria.lastName ? this.criteria.lastName : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
            'Phone number': this.criteria.phoneNumber ? this.criteria.phoneNumber : environment.emptyForExport ,
            'Address': this.criteria.address ? this.criteria.address : environment.emptyForExport ,
            'Registration date Min': this.criteria.registrationDateFrom ? this.datePipe.transform(this.criteria.registrationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Registration date Max': this.criteria.registrationDateTo ? this.datePipe.transform(this.criteria.registrationDateTo , this.dateFormat) : environment.emptyForExport ,
        //'Training': this.criteria.training?.libelle ? this.criteria.training?.libelle : environment.emptyForExport ,
            'Graduated': this.criteria.graduated ? (this.criteria.graduated ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        //'Diploma': this.criteria.diploma?.id ? this.criteria.diploma?.id : environment.emptyForExport ,
        }];
      }
}
