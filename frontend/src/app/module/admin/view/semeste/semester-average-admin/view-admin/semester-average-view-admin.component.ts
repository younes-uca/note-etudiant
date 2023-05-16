import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SemesterAverageService} from 'src/app/controller/service/SemesterAverage.service';
import {SemesterAverageDto} from 'src/app/controller/model/SemesterAverage.model';
import {SemesterAverageCriteria} from 'src/app/controller/criteria/SemesterAverageCriteria.model';

import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterService} from 'src/app/controller/service/Semester.service';
@Component({
  selector: 'app-semester-average-view-admin',
  templateUrl: './semester-average-view-admin.component.html'
})
export class SemesterAverageViewAdminComponent extends AbstractViewController<SemesterAverageDto, SemesterAverageCriteria, SemesterAverageService> implements OnInit {


    constructor(private semesterAverageService: SemesterAverageService, private studentService: StudentService, private semesterService: SemesterService){
        super(semesterAverageService);
    }

    ngOnInit(): void {
        this.student = new StudentDto();
        this.studentService.findAll().subscribe((data) => this.students = data);
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


}
