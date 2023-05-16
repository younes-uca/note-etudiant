import {Component, OnInit} from '@angular/core';
import {ModuleGradeService} from 'src/app/controller/service/ModuleGrade.service';
import {ModuleGradeDto} from 'src/app/controller/model/ModuleGrade.model';
import {ModuleGradeCriteria} from 'src/app/controller/criteria/ModuleGradeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StudentService } from 'src/app/controller/service/Student.service';
import { ModuleService } from 'src/app/controller/service/Module.service';
import { SemesterService } from 'src/app/controller/service/Semester.service';

import {ModuleDto} from 'src/app/controller/model/Module.model';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {StudentDto} from 'src/app/controller/model/Student.model';


@Component({
  selector: 'app-module-grade-list-admin',
  templateUrl: './module-grade-list-admin.component.html'
})
export class ModuleGradeListAdminComponent extends AbstractListController<ModuleGradeDto, ModuleGradeCriteria, ModuleGradeService>  implements OnInit {

    fileName = 'ModuleGrade';

    students :Array<StudentDto>;
    modules :Array<ModuleDto>;
    semesters :Array<SemesterDto>;
  
    constructor(moduleGradeService: ModuleGradeService, private studentService: StudentService, private moduleService: ModuleService, private semesterService: SemesterService) {
        super(moduleGradeService);
        this.pdfName='ModuleGrade.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStudent();
      this.loadModule();
      this.loadSemester();
    }

    public async loadModuleGrades(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ModuleGrade', 'list');
        isPermistted ? this.service.findAll().subscribe(moduleGrades => this.items = moduleGrades,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'student?.cin', header: 'Student'},
            {field: 'module?.libelle', header: 'Module'},
            {field: 'semester?.libelle', header: 'Semester'},
            {field: 'grade', header: 'Grade'},
        ];
    }


    public async loadStudent(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ModuleGrade', 'list');
        isPermistted ? this.studentService.findAllOptimized().subscribe(students => this.students = students,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadModule(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ModuleGrade', 'list');
        isPermistted ? this.moduleService.findAllOptimized().subscribe(modules => this.modules = modules,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSemester(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ModuleGrade', 'list');
        isPermistted ? this.semesterService.findAllOptimized().subscribe(semesters => this.semesters = semesters,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ModuleGradeDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Student': e.student?.cin ,
                'Module': e.module?.libelle ,
                'Semester': e.semester?.libelle ,
                 'Grade': e.grade ,
            }
        });

        this.criteriaData = [{
        //'Student': this.criteria.student?.cin ? this.criteria.student?.cin : environment.emptyForExport ,
        //'Module': this.criteria.module?.libelle ? this.criteria.module?.libelle : environment.emptyForExport ,
        //'Semester': this.criteria.semester?.libelle ? this.criteria.semester?.libelle : environment.emptyForExport ,
            'Grade Min': this.criteria.gradeMin ? this.criteria.gradeMin : environment.emptyForExport ,
            'Grade Max': this.criteria.gradeMax ? this.criteria.gradeMax : environment.emptyForExport ,
        }];
      }
}
