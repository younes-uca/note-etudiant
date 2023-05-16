import {SemesterCriteria} from './SemesterCriteria.model';
import {StudentCriteria} from './StudentCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class TrainingCriteria  extends   BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
     public duration: number;
     public durationMin: number;
     public durationMax: number;
     public trainingCost: number;
     public trainingCostMin: number;
     public trainingCostMax: number;
      public semesters: Array<SemesterCriteria>;
      public students: Array<StudentCriteria>;

}
