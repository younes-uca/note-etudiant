import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {StudentDto} from '../model/Student.model';
import {StudentCriteria} from '../criteria/StudentCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {DiplomaDto} from '../model/Diploma.model';
import {PaymentDto} from '../model/Payment.model';
import {TrainingDto} from '../model/Training.model';
import {ModuleGradeDto} from '../model/ModuleGrade.model';
import {SemesterAverageDto} from '../model/SemesterAverage.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService extends AbstractService<StudentDto, StudentCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/student/');
    }

    public constrcutDto(): StudentDto {
        return new StudentDto();
    }

    public constrcutCriteria(): StudentCriteria {
        return new StudentCriteria();
    }
}
