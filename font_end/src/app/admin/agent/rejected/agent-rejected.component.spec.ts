import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentRejectedComponent } from './agent-rejected.component';

describe('AgentRejectedComponent', () => {
  let component: AgentRejectedComponent;
  let fixture: ComponentFixture<AgentRejectedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentRejectedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentRejectedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
