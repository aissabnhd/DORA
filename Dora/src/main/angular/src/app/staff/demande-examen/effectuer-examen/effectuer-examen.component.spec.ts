import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EffectuerExamenComponent } from './effectuer-examen.component';

describe('EffectuerExamenComponent', () => {
  let component: EffectuerExamenComponent;
  let fixture: ComponentFixture<EffectuerExamenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EffectuerExamenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EffectuerExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
