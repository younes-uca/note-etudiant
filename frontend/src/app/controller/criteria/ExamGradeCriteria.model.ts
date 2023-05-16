import {StudentCriteria} from './StudentCriteria.model';
import {ExamCriteria} from './ExamCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ExamGradeCriteria  extends   BaseCriteria  {

    public id: number;
     public grade: number;
     public gradeMin: number;
     public gradeMax: number;
  public exam: ExamCriteria ;
  public exams: Array<ExamCriteria> ;
  public student: StudentCriteria ;
  public students: Array<StudentCriteria> ;

}
