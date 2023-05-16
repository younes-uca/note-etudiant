import {SemesterCriteria} from './SemesterCriteria.model';
import {StudentCriteria} from './StudentCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SemesterAverageCriteria  extends   BaseCriteria  {

    public id: number;
     public average: number;
     public averageMin: number;
     public averageMax: number;
    public validated: null | boolean;
  public student: StudentCriteria ;
  public students: Array<StudentCriteria> ;
  public semester: SemesterCriteria ;
  public semesters: Array<SemesterCriteria> ;

}
