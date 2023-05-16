
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';

@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {
                            path: 'login',
                            children: [
                                {
                                    path: '',
                                    component: LoginAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'register',
                            children: [
                                {
                                    path: '',
                                    component: RegisterAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {

                            path: 'exam',
                            loadChildren: () => import('./view/exam/exam-admin-routing.module').then(x=>x.ExamAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'student',
                            loadChildren: () => import('./view/student/student-admin-routing.module').then(x=>x.StudentAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'payment',
                            loadChildren: () => import('./view/payment/payment-admin-routing.module').then(x=>x.PaymentAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'training',
                            loadChildren: () => import('./view/training/training-admin-routing.module').then(x=>x.TrainingAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'modul',
                            loadChildren: () => import('./view/modul/modul-admin-routing.module').then(x=>x.ModulAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'semeste',
                            loadChildren: () => import('./view/semeste/semeste-admin-routing.module').then(x=>x.SemesteAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'exa',
                            loadChildren: () => import('./view/exa/exa-admin-routing.module').then(x=>x.ExaAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AdminRoutingModule { }
