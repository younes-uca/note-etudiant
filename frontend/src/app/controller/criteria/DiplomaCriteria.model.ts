import {TrainingCriteria} from './TrainingCriteria.model';
import {StudentCriteria} from './StudentCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DiplomaCriteria  extends   BaseCriteria  {

    public id: number;
    public dateIssued: Date;
    public dateIssuedFrom: Date;
    public dateIssuedTo: Date;
  public student: StudentCriteria ;
  public students: Array<StudentCriteria> ;
  public training: TrainingCriteria ;
  public trainings: Array<TrainingCriteria> ;

}
