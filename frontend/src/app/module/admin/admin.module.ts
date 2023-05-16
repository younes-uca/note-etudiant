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
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import { ExamAdminModule } from './view/exam/exam-admin.module';
import { ExamAdminRoutingModule } from './view/exam/exam-admin-routing.module';
import { StudentAdminModule } from './view/student/student-admin.module';
import { StudentAdminRoutingModule } from './view/student/student-admin-routing.module';
import { PaymentAdminModule } from './view/payment/payment-admin.module';
import { PaymentAdminRoutingModule } from './view/payment/payment-admin-routing.module';
import { TrainingAdminModule } from './view/training/training-admin.module';
import { TrainingAdminRoutingModule } from './view/training/training-admin-routing.module';
import { ModulAdminModule } from './view/modul/modul-admin.module';
import { ModulAdminRoutingModule } from './view/modul/modul-admin-routing.module';
import { SemesteAdminModule } from './view/semeste/semeste-admin.module';
import { SemesteAdminRoutingModule } from './view/semeste/semeste-admin-routing.module';
import { ExaAdminModule } from './view/exa/exa-admin.module';
import { ExaAdminRoutingModule } from './view/exa/exa-admin-routing.module';


import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';


@NgModule({
  declarations: [
   LoginAdminComponent,
   RegisterAdminComponent
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
  ExamAdminModule,
  ExamAdminRoutingModule,
  StudentAdminModule,
  StudentAdminRoutingModule,
  PaymentAdminModule,
  PaymentAdminRoutingModule,
  TrainingAdminModule,
  TrainingAdminRoutingModule,
  ModulAdminModule,
  ModulAdminRoutingModule,
  SemesteAdminModule,
  SemesteAdminRoutingModule,
  ExaAdminModule,
  ExaAdminRoutingModule,
  ],
  exports: [
  LoginAdminComponent,
  RegisterAdminComponent,

    ExamAdminModule,
    StudentAdminModule,
    PaymentAdminModule,
    TrainingAdminModule,
    ModulAdminModule,
    SemesteAdminModule,
    ExaAdminModule,
  ],
  entryComponents: [],
})
export class AdminModule { }
