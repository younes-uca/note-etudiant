import {DiplomaDto} from './Diploma.model';
import {PaymentDto} from './Payment.model';
import {TrainingDto} from './Training.model';
import {ModuleGradeDto} from './ModuleGrade.model';
import {SemesterAverageDto} from './SemesterAverage.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class StudentDto  extends BaseDto{

    public id: number;
    public cin: string;
    public firstName: string;
    public lastName: string;
    public email: string;
    public phoneNumber: string;
    public address: string;
   public registrationDate: Date;
   public graduated: null | boolean;
    public registrationDateMax: string ;
    public registrationDateMin: string ;
    public training: TrainingDto ;
    public diploma: DiplomaDto ;
     public modulesGrades: Array<ModuleGradeDto>;
     public semestersAverages: Array<SemesterAverageDto>;
     public payments: Array<PaymentDto>;

}
