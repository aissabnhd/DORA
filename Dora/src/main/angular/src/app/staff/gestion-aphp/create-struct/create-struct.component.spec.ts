import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateStructComponent } from './create-struct.component';

describe('CreateStructComponent', () => {
  let component: CreateStructComponent;
  let fixture: ComponentFixture<CreateStructComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateStructComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateStructComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
