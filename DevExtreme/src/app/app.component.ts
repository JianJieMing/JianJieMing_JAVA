import {Component} from '@angular/core';
import {confirm} from 'devextreme/ui/dialog';
import {AppService} from './app.service';
import {map, toArray} from 'rxjs/operators';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [AppService]
})
export class AppComponent {

  constructor(private appService: AppService,
              private router: Router) {
  }

  title = 'DevExtreme';

  // 告诉TreeView以何种形式动态加载菜单.
  // 这个函数的返回值就是一个数组.
  // 将数据转换成以下那种格式.
  createChildren = (parent) => {
    console.log(parent);
    const parentId = parent ? parent.itemData.id : null;
    console.log(parentId);
    let menus: any[] = [];
    this.appService.findMenus(parentId)
      .pipe(
        map(menu => {
          return {
            id: menu.menuId,
            parentId: menu.parentId,
            text: menu.menuName,
            hasItems: !menu.menuPath,
            path: menu.menuPath
          };
        }),
        // 把一个一个发射过来的数据转换成数组.
        toArray()
      )
      .subscribe(items => menus = items);
    return menus;
  }

  onTestClick() {
    console.log('o(*￣︶￣*)o');
    // notify('警告', 'error', 1000);
    // 返回值是一个Promise,用法类似于Observable,两者可以互相转换.
    confirm('超级管理员', '确认删除如下数据吗?')
      .then(result => {
        console.log(result);
      });
  }

  onMenuClick(item: any) {
    console.log(item);
    // 获取被点击的菜单绑定的数据
    const menu = item.itemData;
    // 在ts代码中进行路由的跳转
    this.router.navigateByUrl(menu.path);
  }
}
