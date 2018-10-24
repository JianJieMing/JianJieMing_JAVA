import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {RoleComponent} from './role.component';
import {RoleEditorComponent} from './role-editor/role-editor.component';

const routes: Routes = [
  /*
  /role/list 列表页
  /role/add 添加页面
  /role/modify/1 id为1的角色的修改页面
   */
  {
    path: 'list',
    component: RoleComponent
  },
  {
    path: 'add',
    component: RoleEditorComponent
  },
  {
    path: 'modify/:roleId',
    component: RoleEditorComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoleRoutingModule {
}
