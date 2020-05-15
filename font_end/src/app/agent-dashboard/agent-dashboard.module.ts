import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReviewComponent } from './review/review.component';
import { AgentDashboardReviewComponent } from './review/agent-dashboard-review.component';



@NgModule({
  declarations: [ReviewComponent, AgentDashboardReviewComponent],
  imports: [
    CommonModule
  ]
})
export class AgentDashboardModule { }
