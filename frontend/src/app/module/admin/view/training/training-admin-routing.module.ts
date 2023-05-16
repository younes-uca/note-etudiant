
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ModuleListAdminComponent } from './module-admin/list-admin/module-list-admin.component';
import { SemesterListAdminComponent } from './semester-admin/list-admin/semester-list-admin.component';
import { TrainingListAdminComponent } from './training-admin/list-admin/training-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'module',
                            children: [
                                {
                                    path: 'list',
                                    component: ModuleListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'semester',
                            children: [
                                {
                                    path: 'list',
                                    component: SemesterListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'training',
                            children: [
                                {
                                    path: 'list',
                                    component: TrainingListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class TrainingAdminRoutingModule { }
