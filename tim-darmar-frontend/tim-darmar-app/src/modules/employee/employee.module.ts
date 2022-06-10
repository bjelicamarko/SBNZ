import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { EmployeeRoutes } from './employee.routes';

import { MaterialExampleModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';
import { AreasLanguagesDialogComponent } from './components/areas-languages-dialog/areas-languages-dialog.component';
import { WorkExperiencesPageComponent } from './pages/work-experiences-page/work-experiences-page.component';

@NgModule({
  declarations: [
    ProfilePageComponent,
    AreasLanguagesDialogComponent,
    WorkExperiencesPageComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(EmployeeRoutes),
    MaterialExampleModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule { }
