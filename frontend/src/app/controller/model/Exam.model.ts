import {ModuleDto} from './Module.model';
import {SemesterDto} from './Semester.model';
import {ExamGradeDto} from './ExamGrade.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ExamDto  extends BaseDto{

    public id: number;
   public dateExam: Date;
    public dateExamMax: string ;
    public dateExamMin: string ;
    public module: ModuleDto ;
    public semester: SemesterDto ;
     public examGrades: Array<ExamGradeDto>;

}
