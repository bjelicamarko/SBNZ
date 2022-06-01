import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { StudentRoutes } from './student.routes';
import { HomepageComponent } from './pages/homepage/homepage.component';

import { MaterialExampleModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    HomepageComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(StudentRoutes),
    MaterialExampleModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class StudentModule { }
