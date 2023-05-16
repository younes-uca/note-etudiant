import {SemesterDto} from './Semester.model';
import {StudentDto} from './Student.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SemesterAverageDto  extends BaseDto{

    public id: number;
    public average: number;
   public validated: null | boolean;
    public averageMax: string ;
    public averageMin: string ;
    public student: StudentDto ;
    public semester: SemesterDto ;

}
