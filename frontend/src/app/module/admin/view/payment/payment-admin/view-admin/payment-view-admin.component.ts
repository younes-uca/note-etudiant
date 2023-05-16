import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-payment-view-admin',
  templateUrl: './payment-view-admin.component.html'
})
export class PaymentViewAdminComponent extends AbstractViewController<PaymentDto, PaymentCriteria, PaymentService> implements OnInit {


    constructor(private paymentService: PaymentService, private studentService: StudentService, private semesterService: SemesterService, private trainingService: TrainingService){
        super(paymentService);
    }

    ngOnInit(): void {
        this.student = new StudentDto();
        this.studentService.findAll().subscribe((data) => this.students = data);
        this.Training = new TrainingDto();
        this.TrainingService.findAll().subscribe((data) => this.Trainings = data);
        this.semester = new SemesterDto();
        this.semesterService.findAll().subscribe((data) => this.semesters = data);
    }


    get student(): StudentDto {
       return this.studentService.item;
    }
    set student(value: StudentDto) {
        this.studentService.item = value;
    }
    get students():Array<StudentDto> {
       return this.studentService.items;
    }
    set students(value: Array<StudentDto>) {
        this.studentService.items = value;
    }
    get semester(): SemesterDto {
       return this.semesterService.item;
    }
    set semester(value: SemesterDto) {
        this.semesterService.item = value;
    }
    get semesters():Array<SemesterDto> {
       return this.semesterService.items;
    }
    set semesters(value: Array<SemesterDto>) {
        this.semesterService.items = value;
    }
    get Training(): TrainingDto {
       return this.trainingService.item;
    }
    set Training(value: TrainingDto) {
        this.trainingService.item = value;
    }
    get trainings():Array<TrainingDto> {
       return this.trainingService.items;
    }
    set trainings(value: Array<TrainingDto>) {
        this.trainingService.items = value;
    }


}
