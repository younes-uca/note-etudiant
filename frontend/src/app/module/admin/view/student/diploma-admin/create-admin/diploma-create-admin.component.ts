import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {DiplomaService} from 'src/app/controller/service/Diploma.service';
import {DiplomaDto} from 'src/app/controller/model/Diploma.model';
import {DiplomaCriteria} from 'src/app/controller/criteria/DiplomaCriteria.model';
import {StudentDto} from 'src/app/controller/model/Student.model';
import {StudentService} from 'src/app/controller/service/Student.service';
import {TrainingDto} from 'src/app/controller/model/Training.model';
import {TrainingService} from 'src/app/controller/service/Training.service';
@Component({
  selector: 'app-diploma-create-admin',
  templateUrl: './diploma-create-admin.component.html'
})
export class DiplomaCreateAdminComponent extends AbstractCreateController<DiplomaDto, DiplomaCriteria, DiplomaService>  implements OnInit {



    private _validStudentCin = true;
    private _validStudentFirstName = true;
    private _validStudentLastName = true;
    private _validTrainingCode = true;
    private _validTrainingLibelle = true;

    constructor( private diplomaService: DiplomaService , private studentService: StudentService, private trainingService: TrainingService) {
        super(diplomaService);
    }

    ngOnInit(): void {
    this.student = new StudentDto();
    this.studentService.findAll().subscribe((data) => this.students = data);
    this.training = new TrainingDto();
    this.trainingService.findAll().subscribe((data) => this.trainings = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateStudent(student: string) {
    const isPermistted = await this.roleService.isPermitted('Student', 'add');
    if(isPermistted) {
         this.student = new StudentDto();
         this.createStudentDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get training(): TrainingDto {
        return this.trainingService.item;
    }
    set training(value: TrainingDto) {
        this.trainingService.item = value;
    }
    get trainings(): Array<TrainingDto> {
        return this.trainingService.items;
    }
    set trainings(value: Array<TrainingDto>) {
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


}
