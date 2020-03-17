import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VoirAnciensExamensComponent } from './voir-anciens-examens.component';

describe('VoirAnciensExamensComponent', () => {
  let component: VoirAnciensExamensComponent;
  let fixture: ComponentFixture<VoirAnciensExamensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VoirAnciensExamensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VoirAnciensExamensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
