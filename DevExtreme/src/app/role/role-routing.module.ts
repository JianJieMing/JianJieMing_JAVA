import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RoleListComponent} from './role-list/role-list.component';
import {RoleEditorComponent} from './role-editor/role-editor.component';

const routes: Routes = [
  {
    path: 'list',
    component: RoleListComponent
  },
  {
    path: 'add',
    component: RoleEditorComponent
  },
  {
    path: 'modify',
    component: RoleEditorComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoleRoutingModule { }
