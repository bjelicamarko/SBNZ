import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { EmployerRoutes } from './employer.routes';
import { HomepageComponent } from './pages/homepage/homepage.component';

import { MaterialExampleModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';
import { RequestForEmployeePageComponent } from './pages/request-for-employee-page/request-for-employee-page.component';
import { EmployeeRecommendationComponent } from './pages/employee-recommendation/employee-recommendation.component';
import { RequestForStudentPageComponent } from './pages/request-for-student-page/request-for-student-page.component';
import { StudentRecommendationComponent } from './pages/student-recommendation/student-recommendation.component';


@NgModule({
  declarations: [
    HomepageComponent,
    RequestForEmployeePageComponent,
    EmployeeRecommendationComponent,
    RequestForStudentPageComponent,
    StudentRecommendationComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(EmployerRoutes),
    MaterialExampleModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class EmployerModule { }
