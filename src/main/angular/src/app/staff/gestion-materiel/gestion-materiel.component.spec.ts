import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionMaterielComponent } from './gestion-materiel.component';

describe('GestionMaterielComponent', () => {
  let component: GestionMaterielComponent;
  let fixture: ComponentFixture<GestionMaterielComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionMaterielComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
