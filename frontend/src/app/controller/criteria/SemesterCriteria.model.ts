import {TrainingCriteria} from './TrainingCriteria.model';
import {ModuleCriteria} from './ModuleCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SemesterCriteria  extends   BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
    public startDate: Date;
    public startDateFrom: Date;
    public startDateTo: Date;
    public endDate: Date;
    public endDateFrom: Date;
    public endDateTo: Date;
  public training: TrainingCriteria ;
  public trainings: Array<TrainingCriteria> ;
      public modules: Array<ModuleCriteria>;

}
