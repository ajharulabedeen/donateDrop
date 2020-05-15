import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentDashboardRejectedComponent } from './agent-dashboard-rejected.component';

describe('AgentDashboardRejectedComponent', () => {
  let component: AgentDashboardRejectedComponent;
  let fixture: ComponentFixture<AgentDashboardRejectedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentDashboardRejectedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentDashboardRejectedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
