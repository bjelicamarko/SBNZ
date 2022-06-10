import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCollegeInfoComponent } from './add-college-info.component';

describe('AddCollegeInfoComponent', () => {
  let component: AddCollegeInfoComponent;
  let fixture: ComponentFixture<AddCollegeInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCollegeInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCollegeInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
