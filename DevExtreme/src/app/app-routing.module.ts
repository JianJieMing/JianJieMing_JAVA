import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RoleModule} from './role/role.module';

const routes: Routes = [
  {
    path: 'role',
    loadChildren: () => RoleModule
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
