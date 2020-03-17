import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerDemandeComponent } from './creer-demande.component';

describe('CreerDemandeComponent', () => {
  let component: CreerDemandeComponent;
  let fixture: ComponentFixture<CreerDemandeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerDemandeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerDemandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
