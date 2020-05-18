import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AgentDashboardReviewComponent} from './agent-dashboard/review/agent-dashboard-review.component';
import {AgentDashboardComponent} from './agent-dashboard/agent-dashboard.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AgentDashboardAcceptedComponent } from './agent-dashboard/accepted/agent-dashboard-accepted.component';
import { AgentDashboardRejectedComponent } from './agent-dashboard/rejected/agent-dashboard-rejected.component';
import { AgentDashboardRemovedComponent } from './agent-dashboard/removed/agent-dashboard-removed.component';


@NgModule({
  declarations: [AgentDashboardReviewComponent, AgentDashboardComponent, AgentDashboardAcceptedComponent, AgentDashboardRejectedComponent, AgentDashboardRemovedComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AgentDashboardModule {
}
