import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentHoldComponent } from './agent-hold.component';

describe('AgentHoldComponent', () => {
  let component: AgentHoldComponent;
  let fixture: ComponentFixture<AgentHoldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentHoldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentHoldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
