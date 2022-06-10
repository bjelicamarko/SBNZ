import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUniProjectsComponent } from './add-uni-projects.component';

describe('AddUniProjectsComponent', () => {
  let component: AddUniProjectsComponent;
  let fixture: ComponentFixture<AddUniProjectsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUniProjectsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddUniProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
