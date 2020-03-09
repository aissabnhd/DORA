import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateHospitalizationComponent } from './create-hospitalization.component';

describe('CreateHospitalizationComponent', () => {
  let component: CreateHospitalizationComponent;
  let fixture: ComponentFixture<CreateHospitalizationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateHospitalizationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateHospitalizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
