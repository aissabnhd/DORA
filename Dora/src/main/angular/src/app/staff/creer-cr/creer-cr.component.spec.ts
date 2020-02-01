import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerCrComponent } from './creer-cr.component';

describe('CreerCrComponent', () => {
  let component: CreerCrComponent;
  let fixture: ComponentFixture<CreerCrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerCrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerCrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
