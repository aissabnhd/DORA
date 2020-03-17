import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificationSpecialiteComponent } from './modification-specialite.component';

describe('ModificationSpecialiteComponent', () => {
  let component: ModificationSpecialiteComponent;
  let fixture: ComponentFixture<ModificationSpecialiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModificationSpecialiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModificationSpecialiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
