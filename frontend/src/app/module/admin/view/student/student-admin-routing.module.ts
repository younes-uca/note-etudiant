
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { StudentListAdminComponent } from './student-admin/list-admin/student-list-admin.component';
import { DiplomaListAdminComponent } from './diploma-admin/list-admin/diploma-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'student',
                            children: [
                                {
                                    path: 'list',
                                    component: StudentListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'diploma',
                            children: [
                                {
                                    path: 'list',
                                    component: DiplomaListAdminComponent ,
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
export class StudentAdminRoutingModule { }
