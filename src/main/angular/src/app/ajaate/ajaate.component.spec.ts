import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjaateComponent } from './ajaate.component';

describe('AjaateComponent', () => {
  let component: AjaateComponent;
  let fixture: ComponentFixture<AjaateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjaateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjaateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
