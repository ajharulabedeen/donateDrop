import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentAcceptedComponent } from './agent-accepted.component';

describe('AgentAcceptedComponent', () => {
  let component: AgentAcceptedComponent;
  let fixture: ComponentFixture<AgentAcceptedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentAcceptedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentAcceptedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
