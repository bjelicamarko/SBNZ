import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AdminRoutes } from './admin.routes';

import { MaterialExampleModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';
import { RegistrationComponent } from './pages/registration/registration.component';
import { ExpertisesGloballyPageComponent } from './pages/expertises-globally-page/expertises-globally-page.component';
import { LanguagesPageComponent } from './pages/languages-page/languages-page.component';

@NgModule({
  declarations: [
    RegistrationComponent,
    ExpertisesGloballyPageComponent,
    LanguagesPageComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(AdminRoutes),
    MaterialExampleModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AdminModule { }
