import {TrainingCriteria} from './TrainingCriteria.model';
import {SemesterCriteria} from './SemesterCriteria.model';
import {ExamCriteria} from './ExamCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ModuleCriteria  extends   BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
      public trainings: Array<TrainingCriteria>;
      public semesters: Array<SemesterCriteria>;
      public exams: Array<ExamCriteria>;

}
