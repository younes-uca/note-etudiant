import {ModuleCriteria} from './ModuleCriteria.model';
import {SemesterCriteria} from './SemesterCriteria.model';
import {StudentCriteria} from './StudentCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ModuleGradeCriteria  extends   BaseCriteria  {

    public id: number;
     public grade: number;
     public gradeMin: number;
     public gradeMax: number;
  public student: StudentCriteria ;
  public students: Array<StudentCriteria> ;
  public module: ModuleCriteria ;
  public modules: Array<ModuleCriteria> ;
  public semester: SemesterCriteria ;
  public semesters: Array<SemesterCriteria> ;

}
