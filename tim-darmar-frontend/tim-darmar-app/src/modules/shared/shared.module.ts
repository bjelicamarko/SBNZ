import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SnackBarService } from './services/snack-bar.service';
import { UtilService } from './services/util.service';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './interceptors/interceptor.interceptor';
import { LanguagesComponent } from './components/languages/languages.component';
import { AreasComponent } from './components/areas/areas.component';

import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
  
    LanguagesComponent,
       AreasComponent
  ],
  imports: [
    CommonModule,
    MatSnackBarModule,
    FormsModule
  ],
  exports: [
    AreasComponent,
    LanguagesComponent
  ],
  providers: [
    SnackBarService,
    UtilService,
    { provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true },
  ]
})
export class SharedModule { }
