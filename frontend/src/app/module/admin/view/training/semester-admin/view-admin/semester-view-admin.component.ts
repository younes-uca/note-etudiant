import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SemesterService} from 'src/app/controller/service/Semester.service';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterCriteria} from 'src/app/controller/criteria/SemesterCriteria.model';

import {ExamDto} from 'src/app/controller/model/Exam.model';
import {ExamService} from 'src/app/controller/service/Exam.service';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {TrainingService} from 'src/app/controller/service/Training.service';
import {ModuleDto} from 'src/app/controller/model/Module.model';
import {ModuleService} from 'src/app/controller/service/Module.service';
@Component({
  selector: 'app-semester-view-admin',
  templateUrl: './semester-view-admin.component.html'
})
export class SemesterViewAdminComponent extends AbstractViewController<SemesterDto, SemesterCriteria, SemesterService> implements OnInit {

    modules = new ModuleDto();
    moduless: Array<ModuleDto> = [];

    constructor(private semesterService: SemesterService, private trainingService: TrainingService, private moduleService: ModuleService){
        super(semesterService);
    }

    ngOnInit(): void {
        this.training = new TrainingDto();
        this.trainingService.findAll().subscribe((data) => this.trainings = data);
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


}
