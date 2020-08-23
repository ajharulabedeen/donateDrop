import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AgentDashboardReviewComponent} from './agent-dashboard/review/agent-dashboard-review.component';
import {AgentDashboardComponent} from './agent-dashboard/agent-dashboard.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { DonnerAssigningComponent } from './agent-dashboard/donner-assigning/donner-assigning.component';

@NgModule({
  declarations: [AgentDashboardReviewComponent, AgentDashboardComponent, DonnerAssigningComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AgentDashboardModule {
}
