import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-semester-create-admin',
  templateUrl: './semester-create-admin.component.html'
})
export class SemesterCreateAdminComponent extends AbstractCreateController<SemesterDto, SemesterCriteria, SemesterService>  implements OnInit {

    private _modulesElement = new ModuleDto();


   private _validSemesterCode = true;
   private _validSemesterLibelle = true;
    private _validTrainingCode = true;
    private _validTrainingLibelle = true;
    private _validModulesCode = true;
    private _validModulesLibelle = true;

    constructor( private semesterService: SemesterService , private trainingService: TrainingService, private moduleService: ModuleService) {
        super(semesterService);
    }

    ngOnInit(): void {
    this.training = new TrainingDto();
    this.trainingService.findAll().subscribe((data) => this.trainings = data);
}



    validateModules(){
        this.errorMessages = new Array();
        this.validateModulesCode();
        this.validateModulesLibelle();
    }


    public setValidation(value: boolean){
        this.validSemesterCode = value;
        this.validSemesterLibelle = value;
        this.validModulesCode = value;
        this.validModulesLibelle = value;
    }

    public addModules() {
        if( this.item.modules == null )
            this.item.modules = new Array<ModuleDto>();
       this.validateModules();
       if (this.errorMessages.length === 0) {
              this.item.modules.push({... this.modulesElement});
              this.modulesElement = new ModuleDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteModule(p: ModuleDto) {
        this.item.modules.forEach((element, index) => {
            if (element === p) { this.item.modules.splice(index, 1); }
        });
    }

    public editModule(p: ModuleDto) {
        this.modulesElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSemesterCode();
        this.validateSemesterLibelle();
    }

    public validateSemesterCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validSemesterCode = false;
        } else {
            this.validSemesterCode = true;
        }
    }
    public validateSemesterLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validSemesterLibelle = false;
        } else {
            this.validSemesterLibelle = true;
        }
    }

    public validateModulesCode(){
        if (this.modulesElement.code == null) {
            this.errorMessages.push('Code de la module est  invalide');
            this.validModulesCode = false;
        } else {
            this.validModulesCode = true;
        }
    }
    public validateModulesLibelle(){
        if (this.modulesElement.libelle == null) {
            this.errorMessages.push('Libelle de la module est  invalide');
            this.validModulesLibelle = false;
        } else {
            this.validModulesLibelle = true;
        }
    }

    public async openCreateTraining(training: string) {
    const isPermistted = await this.roleService.isPermitted('Training', 'add');
    if(isPermistted) {
         this.training = new TrainingDto();
         this.createTrainingDialog = true;
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



    get validSemesterCode(): boolean {
        return this._validSemesterCode;
    }

    set validSemesterCode(value: boolean) {
         this._validSemesterCode = value;
    }
    get validSemesterLibelle(): boolean {
        return this._validSemesterLibelle;
    }

    set validSemesterLibelle(value: boolean) {
         this._validSemesterLibelle = value;
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
    get validModulesCode(): boolean {
        return this._validModulesCode;
    }
    set validModulesCode(value: boolean) {
        this._validModulesCode = value;
    }
    get validModulesLibelle(): boolean {
        return this._validModulesLibelle;
    }
    set validModulesLibelle(value: boolean) {
        this._validModulesLibelle = value;
    }

    get modulesElement(): ModuleDto {
        if( this._modulesElement == null )
            this._modulesElement = new ModuleDto();
        return this._modulesElement;
    }

    set modulesElement(value: ModuleDto) {
        this._modulesElement = value;
    }

}
