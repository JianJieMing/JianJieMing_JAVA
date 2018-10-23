import {Component} from '@angular/core';
import {from} from 'rxjs';
import {filter, map, toArray} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo';
  modules: ModulInfo[] = [
    {
      moduleId: 1,
      moduleName: '管理员管理',
      selected: true
    },
    {
      moduleId: 2,
      moduleName: '角色管理',
      selected: true
    },
    {
      moduleId: 3,
      moduleName: '资费管理',
      selected: false
    },
    {
      moduleId: 4,
      moduleName: '账务账号',
      selected: false
    },
    {
      moduleId: 5,
      moduleName: '业务账号',
      selected: true
    }
  ];
  flag = true;

  text = '输入框中的文字';

  pageSize = 1;

  onTestClick() {
    this.pageSize++;
    // 在ts里,声明变量可以使用let 或者 const
    // let声明的是变量,const声明的是常量
    // this.modules[3].selected = !this.modules[3].selected;
    for (const module of this.modules) {
      module.selected = this.flag;
    }
    this.flag = !this.flag;
  }

  onSaveClick() {
    // console.log(this.modules);
    // 1.第一种方式
    // const body = {
    //   roleName: ''
    // };
    // const body: any = {};
    // body.roleName = this.text;
    // body.moduleIds = [];
    // for (const module of this.modules) {
    //   if (module.selected) {
    //     body.moduleIds.push(module.moduleId);
    //   }
    // }
    // console.log(body);
    // 2.第二种方式,很神奇的方式,RxJS框架处理数据
    // 数组放进from里就是开始遍历数组
    from(this.modules).pipe(
      // 写的就是处理数据的步骤,学名,各种操作符
      filter(module => module.selected),
      map(module => module.moduleId),
      toArray(),
      map(ids => {
        return {roleName: this.text, moduleIds: ids};
      })
    ).subscribe(id => console.log(id));
  }

  onParentClick(i) {
    console.log('父组件中调用的函数' + i);
    for (const module of this.modules) {
      module.selected = this.flag;
    }
    this.flag = !this.flag;
  }

  onPageSelected(index) {
    console.log(index);
  }

}

class ModulInfo {
  constructor(
    public moduleId: number,
    public moduleName: string,
    // 加一个问号就是可填可不填
    public selected?: boolean) {
  }

  // 给函数设置返回值
  getModuleId?(params?: number | string): number | string {
    return this.moduleId;
  }
}

