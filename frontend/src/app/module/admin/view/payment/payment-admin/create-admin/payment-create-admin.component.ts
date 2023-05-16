import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaymentService} from 'src/app/controller/service/Payment.service';
import {PaymentDto} from 'src/app/controller/model/Payment.model';
import {PaymentCriteria} from 'src/app/controller/criteria/PaymentCriteria.model';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterService} from 'src/app/controller/service/Semester.service';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {TrainingService} from 'src/app/controller/service/Training.service';
@Component({
  selector: 'app-payment-create-admin',
  templateUrl: './payment-create-admin.component.html'
})
export class PaymentCreateAdminComponent extends AbstractCreateController<PaymentDto, PaymentCriteria, PaymentService>  implements OnInit {



    private _validStudentCin = true;
    private _validStudentFirstName = true;
    private _validStudentLastName = true;
    private _validTrainingCode = true;
    private _validTrainingLibelle = true;
    private _validSemesterCode = true;
    private _validSemesterLibelle = true;

    constructor( private paymentService: PaymentService , private studentService: StudentService, private semesterService: SemesterService, private trainingService: TrainingService) {
        super(paymentService);
    }

    ngOnInit(): void {
    this.student = new StudentDto();
    this.studentService.findAll().subscribe((data) => this.students = data);
    this.Training = new TrainingDto();
    this.trainingService.findAll().subscribe((data) => this.trainings = data);
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
    get Training(): TrainingDto {
        return this.trainingService.item;
    }
    set Training(value: TrainingDto) {
        this.trainingService.item = value;
    }
    get Trainings(): Array<TrainingDto> {
        return this.trainingService.items;
    }
    set Trainings(value: Array<TrainingDto>) {
        this.trainingService.items = value;
    }
    get createTrainingDialog(): boolean {
       return this.trainingService.createDialog;
    }
    set createTrainingDialog(value: boolean) {
        this.trainingService.createDialog= value;
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
    get validTrainingCode(): boolean {
        return this._validTrainingCode;
    }
    set validTrainingCode(value: boolean) {
        this._validTrainingCode = value;
    }
    get validTrainingLibelle(): boolean {
        return this._validTrainingLibelle;
    }
    set validTrainingLibelle(value: boolean) {
        this._validTrainingLibelle = value;
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
