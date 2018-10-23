import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PageIndicatorComponent} from './page-indicator/page-indicator.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [PageIndicatorComponent],
  // 导出分页指示器,使其他module可以使用
  exports: [PageIndicatorComponent]
})
export class CommonsModule {
}
