import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { EmployerRoutes } from './employer.routes';

import { MaterialExampleModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';
import { RequestForEmployeePageComponent } from './pages/request-for-employee-page/request-for-employee-page.component';
import { EmployeeRecommendationComponent } from './pages/employee-recommendation/employee-recommendation.component';
import { EmployeeProfileComponent } from './components/employee-profile/employee-profile.component';
import { WorkExperiencesPageComponent } from './pages/work-experiences-page/work-experiences-page.component';


@NgModule({
  declarations: [
    RequestForEmployeePageComponent,
    EmployeeRecommendationComponent,
    EmployeeProfileComponent,
    WorkExperiencesPageComponent
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
