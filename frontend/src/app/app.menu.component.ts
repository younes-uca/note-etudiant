import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {
  trigger,
  state,
  style,
  transition,
  animate,
} from '@angular/animations';
import { AppComponent } from './app.component';
import { AppMainComponent } from './app.main.component';

import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { RoleService } from 'src/app/zynerator/security/Role.service';

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html',
  animations: [
    trigger('inline', [
      state(
        'hidden',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visible',
        style({
          height: '*',
        })
      ),
      state(
        'hiddenAnimated',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visibleAnimated',
        style({
          height: '*',
        })
      ),
      transition(
        'visibleAnimated => hiddenAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
      transition(
        'hiddenAnimated => visibleAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
    ]),
  ],
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelsuperadmin:any[];
  modelanonymous: any[];
    modeladmin : any[];
  constructor(public app: AppComponent,
   public appMain: AppMainComponent,
   private roleService: RoleService,
   private authService:AuthService,
  private router: Router) {}

  ngOnInit() {


    this.modeladmin =
      [
              {
                label: 'Student',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste student',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/student/student/list']
                    },
                    {
                      label: 'Liste module',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/training/module/list']
                    },
                    {
                      label: 'Liste payment',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/payment/payment/list']
                    },
                    {
                      label: 'Liste exam grade',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/exa/exam-grade/list']
                    },
                    {
                      label: 'Liste exam',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/exam/exam/list']
                    },
                    {
                      label: 'Liste semester average',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/semeste/semester-average/list']
                    },
                    {
                      label: 'Liste semester',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/training/semester/list']
                    },
                    {
                      label: 'Liste training',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/training/training/list']
                    },
                    {
                      label: 'Liste module grade',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/modul/module-grade/list']
                    },
                    {
                      label: 'Liste diploma',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/student/diploma/list']
                    },
                ]
              },
    ]
        if (this.authService.authenticated) {
      if (this.authService.authenticatedUser.roles) {

        this.authService.authenticatedUser.roles.forEach(role => {
          const roleName: string = this.getRole(role);
          this.roleService._role.next(roleName.toUpperCase());
          eval('this.model = this.model' + this.getRole(role));
        })
      }

    }
  }
  getRole(text){
  const [role, ...rest] = text.split('_');
  return rest.join('').toLowerCase();
}
  onMenuClick(event) {
    this.appMain.onMenuClick(event);
  }
}
