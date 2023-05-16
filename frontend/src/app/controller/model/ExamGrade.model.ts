import {StudentDto} from './Student.model';
import {ExamDto} from './Exam.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ExamGradeDto  extends BaseDto{

    public id: number;
    public grade: number;
    public gradeMax: string ;
    public gradeMin: string ;
    public exam: ExamDto ;
    public student: StudentDto ;

}
