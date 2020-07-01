import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentDashboardRemovedComponent } from './agent-dashboard-removed.component';

describe('AgentDashboardRemovedComponent', () => {
  let component: AgentDashboardRemovedComponent;
  let fixture: ComponentFixture<AgentDashboardRemovedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentDashboardRemovedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentDashboardRemovedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
