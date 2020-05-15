import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentDashboardAcceptedComponent } from './agent-dashboard-accepted.component';

describe('AgentDashboardAcceptedComponent', () => {
  let component: AgentDashboardAcceptedComponent;
  let fixture: ComponentFixture<AgentDashboardAcceptedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentDashboardAcceptedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentDashboardAcceptedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
