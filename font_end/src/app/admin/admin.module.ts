import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminRoutingModule} from './admin-routing.module';
import {AgentComponent} from './agent/agent.component';
import {FormsModule, NgForm, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [AgentComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AdminRoutingModule
  ]
})
export class AdminModule {
}
