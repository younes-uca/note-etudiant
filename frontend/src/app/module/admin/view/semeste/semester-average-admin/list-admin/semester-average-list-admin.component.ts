import {Component, OnInit} from '@angular/core';
import {SemesterAverageService} from 'src/app/controller/service/SemesterAverage.service';
import {SemesterAverageDto} from 'src/app/controller/model/SemesterAverage.model';
import {SemesterAverageCriteria} from 'src/app/controller/criteria/SemesterAverageCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StudentService } from 'src/app/controller/service/Student.service';
import { SemesterService } from 'src/app/controller/service/Semester.service';

import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {StudentDto} from 'src/app/controller/model/Student.model';


@Component({
  selector: 'app-semester-average-list-admin',
  templateUrl: './semester-average-list-admin.component.html'
})
export class SemesterAverageListAdminComponent extends AbstractListController<SemesterAverageDto, SemesterAverageCriteria, SemesterAverageService>  implements OnInit {

    fileName = 'SemesterAverage';

     yesOrNoValidated :any[] =[];
    students :Array<StudentDto>;
    semesters :Array<SemesterDto>;
  
    constructor(semesterAverageService: SemesterAverageService, private studentService: StudentService, private semesterService: SemesterService) {
        super(semesterAverageService);
        this.pdfName='SemesterAverage.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStudent();
      this.loadSemester();
    this.yesOrNoValidated =  [{label: 'Validated', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadSemesterAverages(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SemesterAverage', 'list');
        isPermistted ? this.service.findAll().subscribe(semesterAverages => this.items = semesterAverages,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'student?.cin', header: 'Student'},
            {field: 'semester?.libelle', header: 'Semester'},
            {field: 'average', header: 'Average'},
            {field: 'validated', header: 'Validated'},
        ];
    }


    public async loadStudent(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SemesterAverage', 'list');
        isPermistted ? this.studentService.findAllOptimized().subscribe(students => this.students = students,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSemester(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SemesterAverage', 'list');
        isPermistted ? this.semesterService.findAllOptimized().subscribe(semesters => this.semesters = semesters,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SemesterAverageDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Student': e.student?.cin ,
                'Semester': e.semester?.libelle ,
                 'Average': e.average ,
                'Validated': e.validated? 'Vrai' : 'Faux' ,
            }
        });

        this.criteriaData = [{
        //'Student': this.criteria.student?.cin ? this.criteria.student?.cin : environment.emptyForExport ,
        //'Semester': this.criteria.semester?.libelle ? this.criteria.semester?.libelle : environment.emptyForExport ,
            'Average Min': this.criteria.averageMin ? this.criteria.averageMin : environment.emptyForExport ,
            'Average Max': this.criteria.averageMax ? this.criteria.averageMax : environment.emptyForExport ,
            'Validated': this.criteria.validated ? (this.criteria.validated ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        }];
      }
}
