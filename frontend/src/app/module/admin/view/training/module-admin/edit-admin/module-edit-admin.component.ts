import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-module-edit-admin',
  templateUrl: './module-edit-admin.component.html'
})
export class ModuleEditAdminComponent extends AbstractEditController<ModuleDto, ModuleCriteria, ModuleService>   implements OnInit {

    private _trainingsElement = new TrainingDto();
    private _semestersElement = new SemesterDto();
    private _examsElement = new ExamDto();

    private _validModuleCode = true;
    private _validModuleLibelle = true;

    private _validTrainingsCode = true;
    private _validTrainingsLibelle = true;
    private _validSemestersCode = true;
    private _validSemestersLibelle = true;



    constructor( private moduleService: ModuleService , private semesterService: SemesterService, private examService: ExamService, private trainingService: TrainingService) {
        super(moduleService);
    }

    ngOnInit(): void {

        this.semestersElement.training = new TrainingDto();
        this.trainingService.findAll().subscribe((data) => this.trainings = data);

        this.examsElement.semester = new SemesterDto();
        this.semesterService.findAll().subscribe((data) => this.semesters = data);

}


    public validateTrainings(){
        this.errorMessages = new Array();
        this.validateTrainingsCode();
        this.validateTrainingsLibelle();
    }
    public validateSemesters(){
        this.errorMessages = new Array();
        this.validateSemestersCode();
        this.validateSemestersLibelle();
    }
    public validateExams(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        this.validModuleCode = value;
        this.validModuleLibelle = value;
        this.validTrainingsCode = value;
        this.validTrainingsLibelle = value;
        this.validSemestersCode = value;
        this.validSemestersLibelle = value;
        }
   public addTrainings() {
        if( this.item.trainings == null )
            this.item.trainings = new Array<TrainingDto>();
       this.validateTrainings();
       if (this.errorMessages.length === 0) {
            if(this.trainingsElement.id == null){
                this.item.trainings.push(this.trainingsElement);
            }else{
                const index = this.item.trainings.findIndex(e => e.id == this.trainingsElement.id);
                this.item.trainings[index] = this.trainingsElement;
            }
          this.trainingsElement = new TrainingDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteTraining(p: TrainingDto) {
        this.item.trainings.forEach((element, index) => {
            if (element === p) { this.item.trainings.splice(index, 1); }
        });
    }

    public editTraining(p: TrainingDto) {
        this.trainingsElement = {... p};
        this.activeTab = 0;
    }
   public addSemesters() {
        if( this.item.semesters == null )
            this.item.semesters = new Array<SemesterDto>();
       this.validateSemesters();
       if (this.errorMessages.length === 0) {
            if(this.semestersElement.id == null){
                this.item.semesters.push(this.semestersElement);
            }else{
                const index = this.item.semesters.findIndex(e => e.id == this.semestersElement.id);
                this.item.semesters[index] = this.semestersElement;
            }
          this.semestersElement = new SemesterDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
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
   public addExams() {
        if( this.item.exams == null )
            this.item.exams = new Array<ExamDto>();
       this.validateExams();
       if (this.errorMessages.length === 0) {
            if(this.examsElement.id == null){
                this.item.exams.push(this.examsElement);
            }else{
                const index = this.item.exams.findIndex(e => e.id == this.examsElement.id);
                this.item.exams[index] = this.examsElement;
            }
          this.examsElement = new ExamDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteExam(p: ExamDto) {
        this.item.exams.forEach((element, index) => {
            if (element === p) { this.item.exams.splice(index, 1); }
        });
    }

    public editExam(p: ExamDto) {
        this.examsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateModuleCode();
        this.validateModuleLibelle();
    }
    public validateModuleCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validModuleCode = false;
        } else {
            this.validModuleCode = true;
        }
    }
    public validateModuleLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validModuleLibelle = false;
        } else {
            this.validModuleLibelle = true;
        }
    }


    private validateTrainingsCode(){
        if (this.trainingsElement.code == null) {
        this.errorMessages.push('Code de la training est  invalide');
            this.validTrainingsCode = false;
        } else {
            this.validTrainingsCode = true;
        }
    }
    private validateTrainingsLibelle(){
        if (this.trainingsElement.libelle == null) {
        this.errorMessages.push('Libelle de la training est  invalide');
            this.validTrainingsLibelle = false;
        } else {
            this.validTrainingsLibelle = true;
        }
    }
    private validateSemestersCode(){
        if (this.semestersElement.code == null) {
        this.errorMessages.push('Code de la semester est  invalide');
            this.validSemestersCode = false;
        } else {
            this.validSemestersCode = true;
        }
    }
    private validateSemestersLibelle(){
        if (this.semestersElement.libelle == null) {
        this.errorMessages.push('Libelle de la semester est  invalide');
            this.validSemestersLibelle = false;
        } else {
            this.validSemestersLibelle = true;
        }
    }

   public async openCreateTraining(training: string) {
        const isPermistted = await this.roleService.isPermitted('Training', 'edit');
        if(isPermistted) {
             this.training = new TrainingDto();
             this.createTrainingDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateSemester(semester: string) {
        const isPermistted = await this.roleService.isPermitted('Semester', 'edit');
        if(isPermistted) {
             this.semester = new SemesterDto();
             this.createSemesterDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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

    get trainingsElement(): TrainingDto {
        if( this._trainingsElement == null )
            this._trainingsElement = new TrainingDto();
         return this._trainingsElement;
    }

    set trainingsElement(value: TrainingDto) {
        this._trainingsElement = value;
    }
    get semestersElement(): SemesterDto {
        if( this._semestersElement == null )
            this._semestersElement = new SemesterDto();
         return this._semestersElement;
    }

    set semestersElement(value: SemesterDto) {
        this._semestersElement = value;
    }
    get examsElement(): ExamDto {
        if( this._examsElement == null )
            this._examsElement = new ExamDto();
         return this._examsElement;
    }

    set examsElement(value: ExamDto) {
        this._examsElement = value;
    }

    get validModuleCode(): boolean {
        return this._validModuleCode;
    }
    set validModuleCode(value: boolean) {
        this._validModuleCode = value;
    }
    get validModuleLibelle(): boolean {
        return this._validModuleLibelle;
    }
    set validModuleLibelle(value: boolean) {
        this._validModuleLibelle = value;
    }

    get validTrainingsCode(): boolean {
        return this._validTrainingsCode;
    }
    set validTrainingsCode(value: boolean) {
        this._validTrainingsCode = value;
    }
    get validTrainingsLibelle(): boolean {
        return this._validTrainingsLibelle;
    }
    set validTrainingsLibelle(value: boolean) {
        this._validTrainingsLibelle = value;
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
}
