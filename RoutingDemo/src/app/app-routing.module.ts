import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {Child1Component} from './child1/child1.component';
import {Child2Component} from './child2/child2.component';
import {RoleModule} from './role/role.module';

const routes: Routes = [
  // 每一个对象都是一个路由配置
  {
    path: '',
    redirectTo: 'child1',
    pathMatch: 'full'
  },
  {
    // 指定url地址child1对应的是Child1Component组件
    path: 'child1',
    component: Child1Component
  },
  {
    path: 'child2',
    component: Child2Component
  },
  {
    path: 'role',
    loadChildren: () => RoleModule
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
