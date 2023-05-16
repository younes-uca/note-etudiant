import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ExamDto} from '../model/Exam.model';
import {ExamCriteria} from '../criteria/ExamCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ModuleDto} from '../model/Module.model';
import {SemesterDto} from '../model/Semester.model';
import {ExamGradeDto} from '../model/ExamGrade.model';

@Injectable({
  providedIn: 'root'
})
export class ExamService extends AbstractService<ExamDto, ExamCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/exam/');
    }

    public constrcutDto(): ExamDto {
        return new ExamDto();
    }

    public constrcutCriteria(): ExamCriteria {
        return new ExamCriteria();
    }
}
