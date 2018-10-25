import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {RoleRoutingModule} from './role-routing.module';
import {RoleListComponent} from './role-list/role-list.component';
import {RoleEditorComponent} from './role-editor/role-editor.component';
import {DxDataGridModule} from 'devextreme-angular';
import {RoleService} from './role.service';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    DxDataGridModule,
    HttpClientModule,
    RoleRoutingModule
  ],
  declarations: [RoleListComponent, RoleEditorComponent],
  providers: [RoleService]
})
export class RoleModule {
}
