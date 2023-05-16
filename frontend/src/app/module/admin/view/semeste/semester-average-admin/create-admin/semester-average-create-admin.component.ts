import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SemesterAverageService} from 'src/app/controller/service/SemesterAverage.service';
import {SemesterAverageDto} from 'src/app/controller/model/SemesterAverage.model';
import {SemesterAverageCriteria} from 'src/app/controller/criteria/SemesterAverageCriteria.model';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterService} from 'src/app/controller/service/Semester.service';
@Component({
  selector: 'app-semester-average-create-admin',
  templateUrl: './semester-average-create-admin.component.html'
})
export class SemesterAverageCreateAdminComponent extends AbstractCreateController<SemesterAverageDto, SemesterAverageCriteria, SemesterAverageService>  implements OnInit {



    private _validStudentCin = true;
    private _validStudentFirstName = true;
    private _validStudentLastName = true;
    private _validSemesterCode = true;
    private _validSemesterLibelle = true;

    constructor( private semesterAverageService: SemesterAverageService , private studentService: StudentService, private semesterService: SemesterService) {
        super(semesterAverageService);
    }

    ngOnInit(): void {
    this.student = new StudentDto();
    this.studentService.findAll().subscribe((data) => this.students = data);
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
