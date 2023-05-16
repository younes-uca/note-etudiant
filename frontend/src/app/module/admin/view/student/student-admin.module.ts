import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from "primeng/fileupload";

import { StudentCreateAdminComponent } from './student-admin/create-admin/student-create-admin.component';
import { StudentEditAdminComponent } from './student-admin/edit-admin/student-edit-admin.component';
import { StudentViewAdminComponent } from './student-admin/view-admin/student-view-admin.component';
import { StudentListAdminComponent } from './student-admin/list-admin/student-list-admin.component';
import { DiplomaCreateAdminComponent } from './diploma-admin/create-admin/diploma-create-admin.component';
import { DiplomaEditAdminComponent } from './diploma-admin/edit-admin/diploma-edit-admin.component';
import { DiplomaViewAdminComponent } from './diploma-admin/view-admin/diploma-view-admin.component';
import { DiplomaListAdminComponent } from './diploma-admin/list-admin/diploma-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    StudentCreateAdminComponent,
    StudentListAdminComponent,
    StudentViewAdminComponent,
    StudentEditAdminComponent,
    DiplomaCreateAdminComponent,
    DiplomaListAdminComponent,
    DiplomaViewAdminComponent,
    DiplomaEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
  ],
  exports: [
  StudentCreateAdminComponent,
  StudentListAdminComponent,
  StudentViewAdminComponent,
  StudentEditAdminComponent,
  DiplomaCreateAdminComponent,
  DiplomaListAdminComponent,
  DiplomaViewAdminComponent,
  DiplomaEditAdminComponent,
  ],
  entryComponents: [],
})
export class StudentAdminModule { }