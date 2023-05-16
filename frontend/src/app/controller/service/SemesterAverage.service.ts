import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SemesterAverageDto} from '../model/SemesterAverage.model';
import {SemesterAverageCriteria} from '../criteria/SemesterAverageCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SemesterDto} from '../model/Semester.model';
import {StudentDto} from '../model/Student.model';

@Injectable({
  providedIn: 'root'
})
export class SemesterAverageService extends AbstractService<SemesterAverageDto, SemesterAverageCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/semesterAverage/');
    }

    public constrcutDto(): SemesterAverageDto {
        return new SemesterAverageDto();
    }

    public constrcutCriteria(): SemesterAverageCriteria {
        return new SemesterAverageCriteria();
    }
}
