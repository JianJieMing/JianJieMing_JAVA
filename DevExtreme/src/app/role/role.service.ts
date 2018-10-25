import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  roles: any[] = [
    {
      roleId: 1,
      roleName: '超级管理员'
    },
    {
      roleId: 2,
      roleName: '管理员'
    }
  ];

  constructor(private http: HttpClient) {
  }

  getRoles(skip, take): Observable<any> {
    return this.http.get('http://localhost:8080/role/list', {
      params: {
        skip: skip,
        take: take
      }
    });
  }
}
