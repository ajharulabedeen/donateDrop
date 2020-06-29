import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentFreezeComponent } from './agent-freeze.component';

describe('AgentFreezeComponent', () => {
  let component: AgentFreezeComponent;
  let fixture: ComponentFixture<AgentFreezeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentFreezeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentFreezeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
