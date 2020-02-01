import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionAgendaMedecinComponent } from './gestion-agenda-medecin.component';

describe('GestionAgendaMedecinComponent', () => {
  let component: GestionAgendaMedecinComponent;
  let fixture: ComponentFixture<GestionAgendaMedecinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionAgendaMedecinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionAgendaMedecinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
