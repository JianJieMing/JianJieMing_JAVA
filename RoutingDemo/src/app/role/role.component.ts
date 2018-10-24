import {Component, OnInit} from '@angular/core';
import {RoleService} from './role.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
  // 因为声明到了模块中所以不用写了,如果某个Service只需要在该组件下使用,那么可以在这里声明.
  // providers: [RoleService]
})
export class RoleComponent implements OnInit {

  dataSource: any[] = [];

  // 依赖注入,自动将RoleService的对象通过构造方法传递进来.
  constructor(private roleService: RoleService) {
  }

  ngOnInit() {
    this.roleService.getRoleList().subscribe(resp => {
      // 把请求的数据赋值给成员变量.
      this.dataSource = resp;
    });
  }

}
