import {TrainingCriteria} from './TrainingCriteria.model';
import {SemesterCriteria} from './SemesterCriteria.model';
import {StudentCriteria} from './StudentCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PaymentCriteria  extends   BaseCriteria  {

    public id: number;
     public amount: number;
     public amountMin: number;
     public amountMax: number;
    public paidDate: Date;
    public paidDateFrom: Date;
    public paidDateTo: Date;
  public student: StudentCriteria ;
  public students: Array<StudentCriteria> ;
  public training: TrainingCriteria ;
  public trainings: Array<TrainingCriteria> ;
  public semester: SemesterCriteria ;
  public semesters: Array<SemesterCriteria> ;

}
