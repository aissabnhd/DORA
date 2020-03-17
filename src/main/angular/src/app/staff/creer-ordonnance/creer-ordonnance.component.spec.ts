import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerOrdonnanceComponent } from './creer-ordonnance.component';

describe('CreerOrdonnanceComponent', () => {
  let component: CreerOrdonnanceComponent;
  let fixture: ComponentFixture<CreerOrdonnanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreerOrdonnanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreerOrdonnanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
