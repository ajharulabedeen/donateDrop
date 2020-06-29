import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AgentDashboardReviewComponent} from './agent-dashboard/review/agent-dashboard-review.component';
import {AgentDashboardComponent} from './agent-dashboard/agent-dashboard.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [AgentDashboardReviewComponent, AgentDashboardComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AgentDashboardModule {
}
