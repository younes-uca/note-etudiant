import {TrainingDto} from './Training.model';
import {SemesterDto} from './Semester.model';
import {ExamDto} from './Exam.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ModuleDto  extends BaseDto{

    public id: number;
    public code: string;
    public libelle: string;
     public trainings: Array<TrainingDto>;
     public semesters: Array<SemesterDto>;
     public exams: Array<ExamDto>;

}
