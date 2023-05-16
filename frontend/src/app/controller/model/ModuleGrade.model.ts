import {ModuleDto} from './Module.model';
import {SemesterDto} from './Semester.model';
import {StudentDto} from './Student.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ModuleGradeDto  extends BaseDto{

    public id: number;
    public grade: number;
    public gradeMax: string ;
    public gradeMin: string ;
    public student: StudentDto ;
    public module: ModuleDto ;
    public semester: SemesterDto ;

}
