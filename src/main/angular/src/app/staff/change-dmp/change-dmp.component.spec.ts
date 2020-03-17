import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeDmpComponent } from './change-dmp.component';

describe('ChangeDmpComponent', () => {
  let component: ChangeDmpComponent;
  let fixture: ComponentFixture<ChangeDmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangeDmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeDmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
