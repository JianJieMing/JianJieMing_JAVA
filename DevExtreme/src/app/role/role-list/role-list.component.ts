import {Component, OnInit} from '@angular/core';
import CustomStore from 'devextreme/data/custom_store';
import {RoleService} from '../role.service';

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent implements OnInit {

  datasource: any = {};

  constructor(private roleService: RoleService) {
    this.datasource.store = new CustomStore({
      load: function (options) {
        return roleService.getRoles(options.skip, options.take).toPromise();
      }
    });
  }

  ngOnInit() {
  }

}
