import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerDmpComponent } from './creer-dmp.component';

describe('CreerDmpComponent', () => {
  let component: CreerDmpComponent;
  let fixture: ComponentFixture<CreerDmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerDmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerDmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
