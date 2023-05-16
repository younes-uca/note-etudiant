import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ExamService} from 'src/app/controller/service/Exam.service';
import {ExamDto} from 'src/app/controller/model/Exam.model';
import {ExamCriteria} from 'src/app/controller/criteria/ExamCriteria.model';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterService} from 'src/app/controller/service/Semester.service';
import {ExamGradeDto} from 'src/app/controller/model/ExamGrade.model';
import {ExamGradeService} from 'src/app/controller/service/ExamGrade.service';
import {ModuleDto} from 'src/app/controller/model/Module.model';
import {ModuleService} from 'src/app/controller/service/Module.service';
@Component({
  selector: 'app-exam-create-admin',
  templateUrl: './exam-create-admin.component.html'
})
export class ExamCreateAdminComponent extends AbstractCreateController<ExamDto, ExamCriteria, ExamService>  implements OnInit {

    private _examGradesElement = new ExamGradeDto();


    private _validModuleCode = true;
    private _validModuleLibelle = true;
    private _validSemesterCode = true;
    private _validSemesterLibelle = true;

    constructor( private examService: ExamService , private studentService: StudentService, private semesterService: SemesterService, private examGradeService: ExamGradeService, private moduleService: ModuleService) {
        super(examService);
    }

    ngOnInit(): void {
        this.examGradesElement.student = new StudentDto();
        this.studentService.findAll().subscribe((data) => this.students = data);
    this.module = new ModuleDto();
    this.moduleService.findAll().subscribe((data) => this.modules = data);
    this.semester = new SemesterDto();
    this.semesterService.findAll().subscribe((data) => this.semesters = data);
}



    validateExamGrades(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
    }

    public addExamGrades() {
        if( this.item.examGrades == null )
            this.item.examGrades = new Array<ExamGradeDto>();
       this.validateExamGrades();
       if (this.errorMessages.length === 0) {
              this.item.examGrades.push({... this.examGradesElement});
              this.examGradesElement = new ExamGradeDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteExamGrade(p: ExamGradeDto) {
        this.item.examGrades.forEach((element, index) => {
            if (element === p) { this.item.examGrades.splice(index, 1); }
        });
    }

    public editExamGrade(p: ExamGradeDto) {
        this.examGradesElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
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
    get module(): ModuleDto {
        return this.moduleService.item;
    }
    set module(value: ModuleDto) {
        this.moduleService.item = value;
    }
    get modules(): Array<ModuleDto> {
        return this.moduleService.items;
    }
    set modules(value: Array<ModuleDto>) {
        this.moduleService.items = value;
    }
    get createModuleDialog(): boolean {
       return this.moduleService.createDialog;
    }
    set createModuleDialog(value: boolean) {
        this.moduleService.createDialog= value;
    }
    get semester(): SemesterDto {
        return this.semesterService.item;
    }
    set semester(value: SemesterDto) {
        this.semesterService.item = value;
    }
    get semesters(): Array<SemesterDto> {
        return this.semesterService.items;
    }
    set semesters(value: Array<SemesterDto>) {
        this.semesterService.items = value;
    }
    get createSemesterDialog(): boolean {
       return this.semesterService.createDialog;
    }
    set createSemesterDialog(value: boolean) {
        this.semesterService.createDialog= value;
    }




    get validModuleCode(): boolean {
        return this._validModuleCode;
    }
    set validModuleCode(value: boolean) {
        this._validModuleCode = value;
    }
    get validModuleLibelle(): boolean {
        return this._validModuleLibelle;
    }
    set validModuleLibelle(value: boolean) {
        this._validModuleLibelle = value;
    }
    get validSemesterCode(): boolean {
        return this._validSemesterCode;
    }
    set validSemesterCode(value: boolean) {
        this._validSemesterCode = value;
    }
    get validSemesterLibelle(): boolean {
        return this._validSemesterLibelle;
    }
    set validSemesterLibelle(value: boolean) {
        this._validSemesterLibelle = value;
    }

    get examGradesElement(): ExamGradeDto {
        if( this._examGradesElement == null )
            this._examGradesElement = new ExamGradeDto();
        return this._examGradesElement;
    }

    set examGradesElement(value: ExamGradeDto) {
        this._examGradesElement = value;
    }

}
