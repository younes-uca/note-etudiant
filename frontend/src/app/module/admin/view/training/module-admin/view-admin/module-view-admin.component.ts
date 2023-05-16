import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ModuleService} from 'src/app/controller/service/Module.service';
import {ModuleDto} from 'src/app/controller/model/Module.model';
import {ModuleCriteria} from 'src/app/controller/criteria/ModuleCriteria.model';

import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterService} from 'src/app/controller/service/Semester.service';
import {ExamDto} from 'src/app/controller/model/Exam.model';
import {ExamService} from 'src/app/controller/service/Exam.service';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {TrainingService} from 'src/app/controller/service/Training.service';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {ExamGradeDto} from 'src/app/controller/model/ExamGrade.model';
import {ExamGradeService} from 'src/app/controller/service/ExamGrade.service';
@Component({
  selector: 'app-module-view-admin',
  templateUrl: './module-view-admin.component.html'
})
export class ModuleViewAdminComponent extends AbstractViewController<ModuleDto, ModuleCriteria, ModuleService> implements OnInit {

    trainings = new TrainingDto();
    trainingss: Array<TrainingDto> = [];
    semesters = new SemesterDto();
    semesterss: Array<SemesterDto> = [];
    exams = new ExamDto();
    examss: Array<ExamDto> = [];

    constructor(private moduleService: ModuleService, private semesterService: SemesterService, private examService: ExamService, private trainingService: TrainingService){
        super(moduleService);
    }

    ngOnInit(): void {
        this.semesters.training = new TrainingDto();
        this.trainingService.findAll().subscribe((data) => this.trainings = data);
        this.exams.semester = new SemesterDto();
        this.semesterService.findAll().subscribe((data) => this.semesters = data);
    }


    get training(): TrainingDto {
       return this.trainingService.item;
    }
    set training(value: TrainingDto) {
        this.trainingService.item = value;
    }
    get trainings():Array<TrainingDto> {
       return this.trainingService.items;
    }
    set trainings(value: Array<TrainingDto>) {
        this.trainingService.items = value;
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
