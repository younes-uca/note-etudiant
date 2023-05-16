import {Component, OnInit} from '@angular/core';
import {ExamGradeService} from 'src/app/controller/service/ExamGrade.service';
import {ExamGradeDto} from 'src/app/controller/model/ExamGrade.model';
import {ExamGradeCriteria} from 'src/app/controller/criteria/ExamGradeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ExamService } from 'src/app/controller/service/Exam.service';
import { StudentService } from 'src/app/controller/service/Student.service';

import {StudentDto} from 'src/app/controller/model/Student.model';
import {ExamDto} from 'src/app/controller/model/Exam.model';


@Component({
  selector: 'app-exam-grade-list-admin',
  templateUrl: './exam-grade-list-admin.component.html'
})
export class ExamGradeListAdminComponent extends AbstractListController<ExamGradeDto, ExamGradeCriteria, ExamGradeService>  implements OnInit {

    fileName = 'ExamGrade';

    exams :Array<ExamDto>;
    students :Array<StudentDto>;
  
    constructor(examGradeService: ExamGradeService, private examService: ExamService, private studentService: StudentService) {
        super(examGradeService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadExam();
      this.loadStudent();
    }

    public async loadExamGrades(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ExamGrade', 'list');
        isPermistted ? this.service.findAll().subscribe(examGrades => this.items = examGrades,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'exam?.id', header: 'Exam'},
            {field: 'student?.cin', header: 'Student'},
            {field: 'grade', header: 'Grade'},
        ];
    }


    public async loadExam(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ExamGrade', 'list');
        isPermistted ? this.examService.findAll().subscribe(exams => this.exams = exams,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadStudent(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ExamGrade', 'list');
        isPermistted ? this.studentService.findAllOptimized().subscribe(students => this.students = students,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ExamGradeDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Exam': e.exam?.id ,
                'Student': e.student?.cin ,
                 'Grade': e.grade ,
            }
        });

        this.criteriaData = [{
        //'Exam': this.criteria.exam?.id ? this.criteria.exam?.id : environment.emptyForExport ,
        //'Student': this.criteria.student?.cin ? this.criteria.student?.cin : environment.emptyForExport ,
            'Grade Min': this.criteria.gradeMin ? this.criteria.gradeMin : environment.emptyForExport ,
            'Grade Max': this.criteria.gradeMax ? this.criteria.gradeMax : environment.emptyForExport ,
        }];
      }
}
