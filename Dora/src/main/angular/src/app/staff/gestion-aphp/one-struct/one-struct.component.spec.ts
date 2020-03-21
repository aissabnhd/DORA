import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneStructComponent } from './one-struct.component';

describe('OneStructComponent', () => {
  let component: OneStructComponent;
  let fixture: ComponentFixture<OneStructComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneStructComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneStructComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
