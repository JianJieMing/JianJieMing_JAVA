import {Injectable} from '@angular/core';
import {from, Observable} from 'rxjs';
import {filter} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  items: any[] = [
    {
      menuId: 1,
      menuName: '角色管理'
    },
    {
      menuId: 2,
      menuName: '角色列表',
      menuPath: '/role/list',
      parentId: 1
    },
    {
      menuId: 3,
      menuName: '添加角色',
      menuPath: '/role/add',
      parentId: 1
    },
    {
      menuId: 4,
      menuName: '修改角色',
      menuPath: '/role/modify',
      parentId: 1
    },
    {
      menuId: 5,
      menuName: '管理员'
    },
    {
      menuId: 6,
      menuName: '管理员列表',
      menuPath: '/admin/list',
      parentId: 5
    },
    {
      menuId: 7,
      menuName: '管理员添加',
      menuPath: '/admin/add',
      parentId: 5
    },
    {
      menuId: 8,
      menuName: '管理员修改',
      menuPath: '/admin/modify',
      parentId: 5
    },
    {
      menuId: 9,
      menuName: '资费管理'
    },
    {
      menuId: 10,
      menuName: '资费列表',
      menuPath: '/fee/list',
      parentId: 9
    },
    {
      menuId: 11,
      menuName: '资费添加',
      menuPath: '/fee/add',
      parentId: 9
    },
    {
      menuId: 12,
      menuName: '资费修改',
      menuPath: '/fee/modify',
      parentId: 9
    }
  ];

  constructor() {
  }

  // 可以根据父级的id返回它的所有子菜单
  // 如果不传递id过来,那么加载一级菜单
  findMenus(parentId?: number): Observable<any> {
    if (parentId) {
      return from(this.items)
        .pipe(
          filter(item => item.parentId === parentId)
        );
    } else {
      return from(this.items)
        .pipe(
          // 不传id返回一级目录
          filter(item => !item.parentId)
        );
    }
  }
}
