import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ModuleGradeDto} from '../model/ModuleGrade.model';
import {ModuleGradeCriteria} from '../criteria/ModuleGradeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ModuleDto} from '../model/Module.model';
import {SemesterDto} from '../model/Semester.model';
import {StudentDto} from '../model/Student.model';

@Injectable({
  providedIn: 'root'
})
export class ModuleGradeService extends AbstractService<ModuleGradeDto, ModuleGradeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/moduleGrade/');
    }

    public constrcutDto(): ModuleGradeDto {
        return new ModuleGradeDto();
    }

    public constrcutCriteria(): ModuleGradeCriteria {
        return new ModuleGradeCriteria();
    }
}
