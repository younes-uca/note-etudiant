import {ModuleCriteria} from './ModuleCriteria.model';
import {SemesterCriteria} from './SemesterCriteria.model';
import {ExamGradeCriteria} from './ExamGradeCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ExamCriteria  extends   BaseCriteria  {

    public id: number;
    public dateExam: Date;
    public dateExamFrom: Date;
    public dateExamTo: Date;
  public module: ModuleCriteria ;
  public modules: Array<ModuleCriteria> ;
  public semester: SemesterCriteria ;
  public semesters: Array<SemesterCriteria> ;
      public examGrades: Array<ExamGradeCriteria>;

}
