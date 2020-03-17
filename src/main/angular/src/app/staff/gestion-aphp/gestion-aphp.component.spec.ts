import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionAphpComponent } from './gestion-aphp.component';

describe('GestionAphpComponent', () => {
  let component: GestionAphpComponent;
  let fixture: ComponentFixture<GestionAphpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionAphpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionAphpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
