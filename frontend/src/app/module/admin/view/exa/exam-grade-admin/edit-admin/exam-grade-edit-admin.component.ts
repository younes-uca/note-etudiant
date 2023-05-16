import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ExamGradeService} from 'src/app/controller/service/ExamGrade.service';
import {ExamGradeDto} from 'src/app/controller/model/ExamGrade.model';
import {ExamGradeCriteria} from 'src/app/controller/criteria/ExamGradeCriteria.model';


import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {ExamDto} from 'src/app/controller/model/Exam.model';
import {ExamService} from 'src/app/controller/service/Exam.service';

@Component({
  selector: 'app-exam-grade-edit-admin',
  templateUrl: './exam-grade-edit-admin.component.html'
})
export class ExamGradeEditAdminComponent extends AbstractEditController<ExamGradeDto, ExamGradeCriteria, ExamGradeService>   implements OnInit {



    private _validStudentCin = true;
    private _validStudentFirstName = true;
    private _validStudentLastName = true;



    constructor( private examGradeService: ExamGradeService , private studentService: StudentService, private examService: ExamService) {
        super(examGradeService);
    }

    ngOnInit(): void {
    this.exam = new ExamDto();
    this.examService.findAll().subscribe((data) => this.exams = data);
    this.student = new StudentDto();
    this.studentService.findAll().subscribe((data) => this.students = data);
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }




   get exam(): ExamDto {
       return this.examService.item;
   }
  set exam(value: ExamDto) {
        this.examService.item = value;
   }
   get exams(): Array<ExamDto> {
        return this.examService.items;
   }
   set exams(value: Array<ExamDto>) {
        this.examService.items = value;
   }
   get createExamDialog(): boolean {
       return this.examService.createDialog;
   }
  set createExamDialog(value: boolean) {
       this.examService.createDialog= value;
   }
   get student(): StudentDto {
       return this.studentService.item;
   }
  set student(value: StudentDto) {
        this.studentService.item = value;
   }
   get students(): Array<StudentDto> {
        return this.studentService.items;
   }
   set students(value: Array<StudentDto>) {
        this.studentService.items = value;
   }
   get createStudentDialog(): boolean {
       return this.studentService.createDialog;
   }
  set createStudentDialog(value: boolean) {
       this.studentService.createDialog= value;
   }



    get validStudentCin(): boolean {
        return this._validStudentCin;
    }
    set validStudentCin(value: boolean) {
        this._validStudentCin = value;
    }
    get validStudentFirstName(): boolean {
        return this._validStudentFirstName;
    }
    set validStudentFirstName(value: boolean) {
        this._validStudentFirstName = value;
    }
    get validStudentLastName(): boolean {
        return this._validStudentLastName;
    }
    set validStudentLastName(value: boolean) {
        this._validStudentLastName = value;
    }
}
