import {Component, OnInit} from '@angular/core';
import {PaymentService} from 'src/app/controller/service/Payment.service';
import {PaymentDto} from 'src/app/controller/model/Payment.model';
import {PaymentCriteria} from 'src/app/controller/criteria/PaymentCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StudentService } from 'src/app/controller/service/Student.service';
import { TrainingService } from 'src/app/controller/service/Training.service';
import { SemesterService } from 'src/app/controller/service/Semester.service';

import {TrainingDto} from 'src/app/controller/model/Training.model';
import {SemesterDto} from 'src/app/controller/model/Semester.model';
import {StudentDto} from 'src/app/controller/model/Student.model';


@Component({
  selector: 'app-payment-list-admin',
  templateUrl: './payment-list-admin.component.html'
})
export class PaymentListAdminComponent extends AbstractListController<PaymentDto, PaymentCriteria, PaymentService>  implements OnInit {

    fileName = 'Payment';

    students :Array<StudentDto>;
    Trainings :Array<TrainingDto>;
    semesters :Array<SemesterDto>;
  
    constructor(paymentService: PaymentService, private studentService: StudentService, private trainingService: TrainingService, private semesterService: SemesterService) {
        super(paymentService);
        this.pdfName='Payment.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStudent();
      this.loadTraining();
      this.loadSemester();
    }

    public async loadPayments(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Payment', 'list');
        isPermistted ? this.service.findAll().subscribe(payments => this.items = payments,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'student?.cin', header: 'Student'},
            {field: 'Training?.libelle', header: 'Training'},
            {field: 'semester?.libelle', header: 'Semester'},
            {field: 'amount', header: 'Amount'},
            {field: 'paidDate', header: 'Paid date'},
        ];
    }


    public async loadStudent(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Payment', 'list');
        isPermistted ? this.studentService.findAllOptimized().subscribe(students => this.students = students,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadTraining(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Payment', 'list');
        isPermistted ? this.trainingService.findAllOptimized().subscribe(trainings => this.trainings = trainings,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSemester(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Payment', 'list');
        isPermistted ? this.semesterService.findAllOptimized().subscribe(semesters => this.semesters = semesters,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaymentDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Student': e.student?.cin ,
                'Training': e.Training?.libelle ,
                'Semester': e.semester?.libelle ,
                 'Amount': e.amount ,
                'Paid date': this.datePipe.transform(e.paidDate , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
        //'Student': this.criteria.student?.cin ? this.criteria.student?.cin : environment.emptyForExport ,
        //'Training': this.criteria.Training?.libelle ? this.criteria.Training?.libelle : environment.emptyForExport ,
        //'Semester': this.criteria.semester?.libelle ? this.criteria.semester?.libelle : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
            'Paid date Min': this.criteria.paidDateFrom ? this.datePipe.transform(this.criteria.paidDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Paid date Max': this.criteria.paidDateTo ? this.datePipe.transform(this.criteria.paidDateTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
