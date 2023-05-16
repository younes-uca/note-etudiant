import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DiplomaDto} from '../model/Diploma.model';
import {DiplomaCriteria} from '../criteria/DiplomaCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {TrainingDto} from '../model/Training.model';
import {StudentDto} from '../model/Student.model';

@Injectable({
  providedIn: 'root'
})
export class DiplomaService extends AbstractService<DiplomaDto, DiplomaCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/diploma/');
    }

    public constrcutDto(): DiplomaDto {
        return new DiplomaDto();
    }

    public constrcutCriteria(): DiplomaCriteria {
        return new DiplomaCriteria();
    }
}
