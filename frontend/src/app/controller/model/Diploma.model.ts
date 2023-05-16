import {TrainingDto} from './Training.model';
import {StudentDto} from './Student.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DiplomaDto  extends BaseDto{

    public id: number;
   public dateIssued: Date;
    public dateIssuedMax: string ;
    public dateIssuedMin: string ;
    public student: StudentDto ;
    public training: TrainingDto ;

}
