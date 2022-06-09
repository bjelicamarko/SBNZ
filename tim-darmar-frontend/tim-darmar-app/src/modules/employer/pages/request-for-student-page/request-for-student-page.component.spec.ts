import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestForStudentPageComponent } from './request-for-student-page.component';

describe('RequestForStudentPageComponent', () => {
  let component: RequestForStudentPageComponent;
  let fixture: ComponentFixture<RequestForStudentPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RequestForStudentPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestForStudentPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
