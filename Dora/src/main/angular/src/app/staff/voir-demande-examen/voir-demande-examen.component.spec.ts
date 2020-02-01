import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VoirDemandeExamenComponent } from './voir-demande-examen.component';

describe('VoirDemandeExamenComponent', () => {
  let component: VoirDemandeExamenComponent;
  let fixture: ComponentFixture<VoirDemandeExamenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VoirDemandeExamenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VoirDemandeExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
