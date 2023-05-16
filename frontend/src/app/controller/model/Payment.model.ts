import {TrainingDto} from './Training.model';
import {SemesterDto} from './Semester.model';
import {StudentDto} from './Student.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaymentDto  extends BaseDto{

    public id: number;
    public amount: number;
   public paidDate: Date;
    public amountMax: string ;
    public amountMin: string ;
    public paidDateMax: string ;
    public paidDateMin: string ;
    public student: StudentDto ;
    public training: TrainingDto ;
    public semester: SemesterDto ;

}
