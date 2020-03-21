import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateStructComponent } from './update-struct.component';

describe('UpdateStructComponent', () => {
  let component: UpdateStructComponent;
  let fixture: ComponentFixture<UpdateStructComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateStructComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateStructComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
