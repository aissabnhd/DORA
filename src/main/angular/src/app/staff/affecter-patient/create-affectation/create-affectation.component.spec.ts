import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAffectationComponent } from './create-affectation.component';

describe('CreateAffectationComponent', () => {
  let component: CreateAffectationComponent;
  let fixture: ComponentFixture<CreateAffectationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAffectationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAffectationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
