import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  dataSource: any[] = [
    {
      roleId: 1,
      roleName: '超级管理员'
    },
    {
      roleId: 2,
      roleName: '管理员'
    },
    {
      roleId: 3,
      roleName: '王八蛋'
    }
  ];

  host = 'http://localhost:8080/';

  constructor(private client: HttpClient) {
  }

  headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'name': 'zhangsan'
    }
  );

  getRoleList(): Observable<any> {
    // of操作符,把数据当做一个整体进行发送.
    // return of(this.dataSource);
    // 向 http://localhost:8080/role/list 发送一个GET请求.
    return this.client.get(`${this.host}role/list`, {
      headers: this.headers,
      params: {
        page: '1',
        size: '20'
      }
    });
  }

  addRole(role: any): Observable<any> {
    return this.client.post(`${this.host}role/add`, role);
  }

}
