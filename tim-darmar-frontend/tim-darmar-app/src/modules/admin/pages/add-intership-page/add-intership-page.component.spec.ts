import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIntershipPageComponent } from './add-intership-page.component';

describe('AddIntershipPageComponent', () => {
  let component: AddIntershipPageComponent;
  let fixture: ComponentFixture<AddIntershipPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddIntershipPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIntershipPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
