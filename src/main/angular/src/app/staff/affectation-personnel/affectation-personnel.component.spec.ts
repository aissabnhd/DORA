import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffectationPersonnelComponent } from './affectation-personnel.component';

describe('AffectationPersonnelComponent', () => {
  let component: AffectationPersonnelComponent;
  let fixture: ComponentFixture<AffectationPersonnelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffectationPersonnelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffectationPersonnelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
