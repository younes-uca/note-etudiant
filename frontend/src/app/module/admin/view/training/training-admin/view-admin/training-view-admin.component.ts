import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TrainingService} from 'src/app/controller/service/Training.service';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {TrainingCriteria} from 'src/app/controller/criteria/TrainingCriteria.model';

import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {SemesterService} from 'src/app/controller/service/Semester.service';
import {PaymentDto} from 'src/app/controller/model/Payment.model';
import {PaymentService} from 'src/app/controller/service/Payment.service';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {DiplomaDto} from 'src/app/controller/model/Diploma.model';
import {DiplomaService} from 'src/app/controller/service/Diploma.service';
import {SemesterAverageDto} from 'src/app/controller/model/SemesterAverage.model';
import {SemesterAverageService} from 'src/app/controller/service/SemesterAverage.service';
import {ModuleDto} from 'src/app/controller/model/Module.model';
import {ModuleService} from 'src/app/controller/service/Module.service';
import {ModuleGradeDto} from 'src/app/controller/model/ModuleGrade.model';
import {ModuleGradeService} from 'src/app/controller/service/ModuleGrade.service';
@Component({
  selector: 'app-training-view-admin',
  templateUrl: './training-view-admin.component.html'
})
export class TrainingViewAdminComponent extends AbstractViewController<TrainingDto, TrainingCriteria, TrainingService> implements OnInit {

    semesters = new SemesterDto();
    semesterss: Array<SemesterDto> = [];
    students = new StudentDto();
    studentss: Array<StudentDto> = [];

    constructor(private trainingService: TrainingService, private studentService: StudentService, private semesterService: SemesterService, private diplomaService: DiplomaService){
        super(trainingService);
    }

    ngOnInit(): void {
        this.students.diploma = new DiplomaDto();
        this.diplomaService.findAll().subscribe((data) => this.diplomas = data);
    }


    get diploma(): DiplomaDto {
       return this.diplomaService.item;
    }
    set diploma(value: DiplomaDto) {
        this.diplomaService.item = value;
    }
    get diplomas():Array<DiplomaDto> {
       return this.diplomaService.items;
    }
    set diplomas(value: Array<DiplomaDto>) {
        this.diplomaService.items = value;
    }


}
