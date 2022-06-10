import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SnackBarService } from './services/snack-bar.service';
import { UtilService } from './services/util.service';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './interceptors/interceptor.interceptor';
import { LanguagesComponent } from './components/languages/languages.component';
import { AreasComponent } from './components/areas/areas.component';

import { MaterialExampleModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { WorkExperiencesTableComponent } from './components/work-experiences-table/work-experiences-table.component';
import { WorkExperienceInfoComponent } from './components/work-experience-info/work-experience-info.component';


@NgModule({
  declarations: [
  
    LanguagesComponent,
       AreasComponent,
       WorkExperiencesTableComponent,
       WorkExperienceInfoComponent
  ],
  imports: [
    CommonModule,
    MaterialExampleModule,
    MatSnackBarModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    AreasComponent,
    LanguagesComponent,
    WorkExperiencesTableComponent,
    WorkExperienceInfoComponent
  ],
  providers: [
    SnackBarService,
    UtilService,
    { provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true },
  ]
})
export class SharedModule { }
