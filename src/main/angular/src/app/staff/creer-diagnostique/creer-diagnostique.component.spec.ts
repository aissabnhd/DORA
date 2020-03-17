import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerDiagnostiqueComponent } from './creer-diagnostique.component';

describe('CreerDiagnostiqueComponent', () => {
  let component: CreerDiagnostiqueComponent;
  let fixture: ComponentFixture<CreerDiagnostiqueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerDiagnostiqueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerDiagnostiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
