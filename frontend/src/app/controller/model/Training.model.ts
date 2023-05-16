import {SemesterDto} from './Semester.model';
import {StudentDto} from './Student.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class TrainingDto  extends BaseDto{

    public id: number;
    public code: string;
    public libelle: string;
   public duration: number;
    public trainingCost: number;
    public durationMax: string ;
    public durationMin: string ;
    public trainingCostMax: string ;
    public trainingCostMin: string ;
     public semesters: Array<SemesterDto>;
     public students: Array<StudentDto>;

}
