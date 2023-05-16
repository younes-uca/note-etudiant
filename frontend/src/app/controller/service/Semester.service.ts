import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SemesterDto} from '../model/Semester.model';
import {SemesterCriteria} from '../criteria/SemesterCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {TrainingDto} from '../model/Training.model';
import {ModuleDto} from '../model/Module.model';

@Injectable({
  providedIn: 'root'
})
export class SemesterService extends AbstractService<SemesterDto, SemesterCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/semester/');
    }

    public constrcutDto(): SemesterDto {
        return new SemesterDto();
    }

    public constrcutCriteria(): SemesterCriteria {
        return new SemesterCriteria();
    }
}
