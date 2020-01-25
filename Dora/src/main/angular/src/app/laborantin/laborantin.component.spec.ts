import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaborantinComponent } from './laborantin.component';

describe('LaborantinComponent', () => {
  let component: LaborantinComponent;
  let fixture: ComponentFixture<LaborantinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaborantinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaborantinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
