import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-training-create-admin',
  templateUrl: './training-create-admin.component.html'
})
export class TrainingCreateAdminComponent extends AbstractCreateController<TrainingDto, TrainingCriteria, TrainingService>  implements OnInit {

    private _semestersElement = new SemesterDto();
    private _studentsElement = new StudentDto();


   private _validTrainingCode = true;
   private _validTrainingLibelle = true;
    private _validSemestersCode = true;
    private _validSemestersLibelle = true;
    private _validStudentsCin = true;
    private _validStudentsFirstName = true;
    private _validStudentsLastName = true;

    constructor( private trainingService: TrainingService , private studentService: StudentService, private semesterService: SemesterService, private diplomaService: DiplomaService) {
        super(trainingService);
    }

    ngOnInit(): void {
        this.studentsElement.diploma = new DiplomaDto();
        this.diplomaService.findAll().subscribe((data) => this.diplomas = data);
}



    validateSemesters(){
        this.errorMessages = new Array();
        this.validateSemestersCode();
        this.validateSemestersLibelle();
    }
    validateStudents(){
        this.errorMessages = new Array();
        this.validateStudentsCin();
        this.validateStudentsFirstName();
        this.validateStudentsLastName();
    }


    public setValidation(value: boolean){
        this.validTrainingCode = value;
        this.validTrainingLibelle = value;
        this.validSemestersCode = value;
        this.validSemestersLibelle = value;
        this.validStudentsCin = value;
        this.validStudentsFirstName = value;
        this.validStudentsLastName = value;
    }

    public addSemesters() {
        if( this.item.semesters == null )
            this.item.semesters = new Array<SemesterDto>();
       this.validateSemesters();
       if (this.errorMessages.length === 0) {
              this.item.semesters.push({... this.semestersElement});
              this.semestersElement = new SemesterDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteSemester(p: SemesterDto) {
        this.item.semesters.forEach((element, index) => {
            if (element === p) { this.item.semesters.splice(index, 1); }
        });
    }

    public editSemester(p: SemesterDto) {
        this.semestersElement = {... p};
        this.activeTab = 0;
    }
    public addStudents() {
        if( this.item.students == null )
            this.item.students = new Array<StudentDto>();
       this.validateStudents();
       if (this.errorMessages.length === 0) {
              this.item.students.push({... this.studentsElement});
              this.studentsElement = new StudentDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteStudent(p: StudentDto) {
        this.item.students.forEach((element, index) => {
            if (element === p) { this.item.students.splice(index, 1); }
        });
    }

    public editStudent(p: StudentDto) {
        this.studentsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTrainingCode();
        this.validateTrainingLibelle();
    }

    public validateTrainingCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTrainingCode = false;
        } else {
            this.validTrainingCode = true;
        }
    }
    public validateTrainingLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTrainingLibelle = false;
        } else {
            this.validTrainingLibelle = true;
        }
    }

    public validateSemestersCode(){
        if (this.semestersElement.code == null) {
            this.errorMessages.push('Code de la semester est  invalide');
            this.validSemestersCode = false;
        } else {
            this.validSemestersCode = true;
        }
    }
    public validateSemestersLibelle(){
        if (this.semestersElement.libelle == null) {
            this.errorMessages.push('Libelle de la semester est  invalide');
            this.validSemestersLibelle = false;
        } else {
            this.validSemestersLibelle = true;
        }
    }
    public validateStudentsCin(){
        if (this.studentsElement.cin == null) {
            this.errorMessages.push('Cin de la student est  invalide');
            this.validStudentsCin = false;
        } else {
            this.validStudentsCin = true;
        }
    }
    public validateStudentsFirstName(){
        if (this.studentsElement.firstName == null) {
            this.errorMessages.push('FirstName de la student est  invalide');
            this.validStudentsFirstName = false;
        } else {
            this.validStudentsFirstName = true;
        }
    }
    public validateStudentsLastName(){
        if (this.studentsElement.lastName == null) {
            this.errorMessages.push('LastName de la student est  invalide');
            this.validStudentsLastName = false;
        } else {
            this.validStudentsLastName = true;
        }
    }


    get diploma(): DiplomaDto {
        return this.diplomaService.item;
    }
    set diploma(value: DiplomaDto) {
        this.diplomaService.item = value;
    }
    get diplomas(): Array<DiplomaDto> {
        return this.diplomaService.items;
    }
    set diplomas(value: Array<DiplomaDto>) {
        this.diplomaService.items = value;
    }
    get createDiplomaDialog(): boolean {
       return this.diplomaService.createDialog;
    }
    set createDiplomaDialog(value: boolean) {
        this.diplomaService.createDialog= value;
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

    get validSemestersCode(): boolean {
        return this._validSemestersCode;
    }
    set validSemestersCode(value: boolean) {
        this._validSemestersCode = value;
    }
    get validSemestersLibelle(): boolean {
        return this._validSemestersLibelle;
    }
    set validSemestersLibelle(value: boolean) {
        this._validSemestersLibelle = value;
    }
    get validStudentsCin(): boolean {
        return this._validStudentsCin;
    }
    set validStudentsCin(value: boolean) {
        this._validStudentsCin = value;
    }
    get validStudentsFirstName(): boolean {
        return this._validStudentsFirstName;
    }
    set validStudentsFirstName(value: boolean) {
        this._validStudentsFirstName = value;
    }
    get validStudentsLastName(): boolean {
        return this._validStudentsLastName;
    }
    set validStudentsLastName(value: boolean) {
        this._validStudentsLastName = value;
    }

    get semestersElement(): SemesterDto {
        if( this._semestersElement == null )
            this._semestersElement = new SemesterDto();
        return this._semestersElement;
    }

    set semestersElement(value: SemesterDto) {
        this._semestersElement = value;
    }
    get studentsElement(): StudentDto {
        if( this._studentsElement == null )
            this._studentsElement = new StudentDto();
        return this._studentsElement;
    }

    set studentsElement(value: StudentDto) {
        this._studentsElement = value;
    }

}
