import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MailOublieComponent } from './mail-oublie.component';

describe('MailOublieComponent', () => {
  let component: MailOublieComponent;
  let fixture: ComponentFixture<MailOublieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MailOublieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MailOublieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
