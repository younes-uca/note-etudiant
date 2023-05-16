import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DiplomaService} from 'src/app/controller/service/Diploma.service';
import {DiplomaDto} from 'src/app/controller/model/Diploma.model';
import {DiplomaCriteria} from 'src/app/controller/criteria/DiplomaCriteria.model';

import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {TrainingService} from 'src/app/controller/service/Training.service';
@Component({
  selector: 'app-diploma-view-admin',
  templateUrl: './diploma-view-admin.component.html'
})
export class DiplomaViewAdminComponent extends AbstractViewController<DiplomaDto, DiplomaCriteria, DiplomaService> implements OnInit {


    constructor(private diplomaService: DiplomaService, private studentService: StudentService, private trainingService: TrainingService){
        super(diplomaService);
    }

    ngOnInit(): void {
        this.student = new StudentDto();
        this.studentService.findAll().subscribe((data) => this.students = data);
        this.training = new TrainingDto();
        this.trainingService.findAll().subscribe((data) => this.trainings = data);
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
