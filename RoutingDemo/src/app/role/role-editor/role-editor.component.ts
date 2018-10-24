import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {RoleService} from '../role.service';

@Component({
  selector: 'app-role-editor',
  templateUrl: './role-editor.component.html',
  styleUrls: ['./role-editor.component.css']
})
export class RoleEditorComponent implements OnInit {

  constructor(private route: ActivatedRoute, private roleService: RoleService) {
    // 对路由参数进行注册
    // 只要访问了该组件,下面的Lambda事件就会执行.
    this.route.paramMap.subscribe(params => {
      // Lambda表达式本质上是一个函数
      const roleId = params.get('roleId');
      console.log(roleId);
      // 对roleId做是否为null的判断,就可以区分出点击的是添加按钮还是修改按钮访问的该组件.
    });
  }

  ngOnInit() {
    const body = {roleId: 10, name: '卡特琳娜'};
    this.roleService.addRole(body).subscribe(resp => console.log(resp));
  }

}
