import {Component, OnInit} from '@angular/core';
import {ExamService} from 'src/app/controller/service/Exam.service';
import {ExamDto} from 'src/app/controller/model/Exam.model';
import {ExamCriteria} from 'src/app/controller/criteria/ExamCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ModuleService } from 'src/app/controller/service/Module.service';
import { SemesterService } from 'src/app/controller/service/Semester.service';

import {ModuleDto} from 'src/app/controller/model/Module.model';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {ExamGradeDto} from 'src/app/controller/model/ExamGrade.model';


@Component({
  selector: 'app-exam-list-admin',
  templateUrl: './exam-list-admin.component.html'
})
export class ExamListAdminComponent extends AbstractListController<ExamDto, ExamCriteria, ExamService>  implements OnInit {

    fileName = 'Exam';

    modules :Array<ModuleDto>;
    semesters :Array<SemesterDto>;
  
    constructor(examService: ExamService, private moduleService: ModuleService, private semesterService: SemesterService) {
        super(examService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadModule();
      this.loadSemester();
    }

    public async loadExams(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Exam', 'list');
        isPermistted ? this.service.findAll().subscribe(exams => this.items = exams,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'module?.libelle', header: 'Module'},
            {field: 'semester?.libelle', header: 'Semester'},
            {field: 'dateExam', header: 'Date exam'},
        ];
    }


    public async loadModule(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Exam', 'list');
        isPermistted ? this.moduleService.findAllOptimized().subscribe(modules => this.modules = modules,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSemester(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Exam', 'list');
        isPermistted ? this.semesterService.findAllOptimized().subscribe(semesters => this.semesters = semesters,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ExamDto) {
        if (res.examGrades != null) {
             res.examGrades.forEach(d => { d.exam = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Module': e.module?.libelle ,
                'Semester': e.semester?.libelle ,
                'Date exam': this.datePipe.transform(e.dateExam , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
        //'Module': this.criteria.module?.libelle ? this.criteria.module?.libelle : environment.emptyForExport ,
        //'Semester': this.criteria.semester?.libelle ? this.criteria.semester?.libelle : environment.emptyForExport ,
            'Date exam Min': this.criteria.dateExamFrom ? this.datePipe.transform(this.criteria.dateExamFrom , this.dateFormat) : environment.emptyForExport ,
            'Date exam Max': this.criteria.dateExamTo ? this.datePipe.transform(this.criteria.dateExamTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
