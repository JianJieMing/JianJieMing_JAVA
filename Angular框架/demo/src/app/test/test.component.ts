import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  index = 0;

  // input 注解表示该值是需要从该组件的外部传递进来
  // 也可以传递复杂对象进来,比如对象/数组等等.
  @Input()
  title: string;

  // 向该组件的外部传递事件
  @Output()
  childClick = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

  onChildClick() {
    this.index++;
    // 直接把值添加到emit里面进行传递
    this.childClick.emit(this.index);
  }

}
