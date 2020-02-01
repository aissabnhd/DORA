import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeExamenComponent } from './demande-examen.component';

describe('DemandeExamenComponent', () => {
  let component: DemandeExamenComponent;
  let fixture: ComponentFixture<DemandeExamenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemandeExamenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
