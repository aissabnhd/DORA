import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficheDmpComponent } from './affiche-dmp.component';

describe('AfficheDmpComponent', () => {
  let component: AfficheDmpComponent;
  let fixture: ComponentFixture<AfficheDmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficheDmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficheDmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
