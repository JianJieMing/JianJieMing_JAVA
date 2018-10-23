import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-page-indicator',
  templateUrl: './page-indicator.component.html',
  styleUrls: ['./page-indicator.component.css']
})
export class PageIndicatorComponent implements OnInit, OnChanges {

  @Input()
  pageSize: number;

  @Output()
  pageSelected = new EventEmitter();

  array: number[] = [];

  currentIndex = 1;

  constructor() {
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    // 从第几个位置删除几个元素,0是删除所有
    this.array.splice(0);
    for (let i = 0; i < this.pageSize; i++) {
      this.array.push(i + 1);
    }
  }

  onPreClick() {
    if (this.currentIndex >= 2) {
      this.currentIndex--;
      this.pageSelected.emit(this.currentIndex);
    }
  }

  onPageSelected(index) {
    // 把点击的值赋值给成员变量
    this.currentIndex = index;
    // 当前点击的第几页的值传递出去
    this.pageSelected.emit(index);
  }

  onNextClick() {
    if (this.currentIndex < this.pageSize) {
      this.currentIndex++;
      this.pageSelected.emit(this.currentIndex);
    }
  }

}
