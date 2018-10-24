import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {RoleRoutingModule} from './role-routing.module';
import {RoleComponent} from './role.component';
import {RoleEditorComponent} from './role-editor/role-editor.component';
import {RoleService} from './role.service';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    // 用来发送网络请求
    HttpClientModule,
    RoleRoutingModule
  ],
  declarations: [RoleComponent, RoleEditorComponent],
  // 声明到模块中,那么该模块下的所有组件都可以使用.
  providers: [RoleService]
})
export class RoleModule {
}
