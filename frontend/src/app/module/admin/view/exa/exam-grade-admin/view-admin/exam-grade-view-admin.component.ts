import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ExamGradeService} from 'src/app/controller/service/ExamGrade.service';
import {ExamGradeDto} from 'src/app/controller/model/ExamGrade.model';
import {ExamGradeCriteria} from 'src/app/controller/criteria/ExamGradeCriteria.model';

import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {ExamDto} from 'src/app/controller/model/Exam.model';
import {ExamService} from 'src/app/controller/service/Exam.service';
@Component({
  selector: 'app-exam-grade-view-admin',
  templateUrl: './exam-grade-view-admin.component.html'
})
export class ExamGradeViewAdminComponent extends AbstractViewController<ExamGradeDto, ExamGradeCriteria, ExamGradeService> implements OnInit {


    constructor(private examGradeService: ExamGradeService, private studentService: StudentService, private examService: ExamService){
        super(examGradeService);
    }

    ngOnInit(): void {
        this.exam = new ExamDto();
        this.examService.findAll().subscribe((data) => this.exams = data);
        this.student = new StudentDto();
        this.studentService.findAll().subscribe((data) => this.students = data);
    }


    get exam(): ExamDto {
       return this.examService.item;
    }
    set exam(value: ExamDto) {
        this.examService.item = value;
    }
    get exams():Array<ExamDto> {
       return this.examService.items;
    }
    set exams(value: Array<ExamDto>) {
        this.examService.items = value;
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


}
