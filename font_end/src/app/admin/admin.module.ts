import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminRoutingModule} from './admin-routing.module';
import {AgentComponent} from './agent/agent.component';
import {FormsModule, NgForm, ReactiveFormsModule} from '@angular/forms';
import { ReviewComponent } from './agent/review/review.component';
import { AgentAcceptedComponent } from './agent/accepted/agent-accepted.component';
import { AgentRejectedComponent } from './agent/rejected/agent-rejected.component';
import { AgentHoldComponent } from './agent/hold/agent-hold.component';
import { AgentFreezeComponent } from './agent/freeze/agent-freeze.component';


@NgModule({
  declarations: [AgentComponent, ReviewComponent, AgentAcceptedComponent, AgentRejectedComponent, AgentHoldComponent, AgentFreezeComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AdminRoutingModule
  ]
})
export class AdminModule {
}
