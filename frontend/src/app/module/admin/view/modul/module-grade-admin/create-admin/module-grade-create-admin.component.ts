import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ModuleGradeService} from 'src/app/controller/service/ModuleGrade.service';
import {ModuleGradeDto} from 'src/app/controller/model/ModuleGrade.model';
import {ModuleGradeCriteria} from 'src/app/controller/criteria/ModuleGradeCriteria.model';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterService} from 'src/app/controller/service/Semester.service';
import {ModuleDto} from 'src/app/controller/model/Module.model';
import {ModuleService} from 'src/app/controller/service/Module.service';
@Component({
  selector: 'app-module-grade-create-admin',
  templateUrl: './module-grade-create-admin.component.html'
})
export class ModuleGradeCreateAdminComponent extends AbstractCreateController<ModuleGradeDto, ModuleGradeCriteria, ModuleGradeService>  implements OnInit {



    private _validStudentCin = true;
    private _validStudentFirstName = true;
    private _validStudentLastName = true;
    private _validModuleCode = true;
    private _validModuleLibelle = true;
    private _validSemesterCode = true;
    private _validSemesterLibelle = true;

    constructor( private moduleGradeService: ModuleGradeService , private studentService: StudentService, private semesterService: SemesterService, private moduleService: ModuleService) {
        super(moduleGradeService);
    }

    ngOnInit(): void {
    this.student = new StudentDto();
    this.studentService.findAll().subscribe((data) => this.students = data);
    this.module = new ModuleDto();
    this.moduleService.findAll().subscribe((data) => this.modules = data);
    this.semester = new SemesterDto();
    this.semesterService.findAll().subscribe((data) => this.semesters = data);
}





    public setValidation(value: boolean){
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


}
