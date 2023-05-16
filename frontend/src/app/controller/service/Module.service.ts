import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ModuleDto} from '../model/Module.model';
import {ModuleCriteria} from '../criteria/ModuleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {TrainingDto} from '../model/Training.model';
import {SemesterDto} from '../model/Semester.model';
import {ExamDto} from '../model/Exam.model';

@Injectable({
  providedIn: 'root'
})
export class ModuleService extends AbstractService<ModuleDto, ModuleCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/module/');
    }

    public constrcutDto(): ModuleDto {
        return new ModuleDto();
    }

    public constrcutCriteria(): ModuleCriteria {
        return new ModuleCriteria();
    }
}
