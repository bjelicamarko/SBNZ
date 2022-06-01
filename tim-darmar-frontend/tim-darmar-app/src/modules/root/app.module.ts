import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RootLayoutPageComponent } from './pages/root-layout-page/root-layout-page.component';
import { NotFoundPageComponent } from './pages/not-found-page/not-found-page.component';

import { HeaderCommonComponent } from './components/header-common/header-common.component';
import { HeaderAdminComponent } from './components/header-admin/header-admin.component';
import { AuthModule } from '../auth/auth.module';
import { SharedModule } from '../shared/shared.module';
import { AdminModule } from '../admin/admin.module';
import { EmployerModule } from '../employer/employer.module';
import { HeaderEmployerComponent } from './components/header-employer/header-employer.component';
import { EmployeeModule } from '../employee/employee.module';
import { HeaderEmployeeComponent } from './components/header-employee/header-employee.component';
import { StudentModule } from '../student/student.module';
import { HeaderStudentComponent } from './components/header-student/header-student.component';

@NgModule({
    declarations: [
      AppComponent,
      RootLayoutPageComponent,
      NotFoundPageComponent,
      HeaderCommonComponent,
      HeaderAdminComponent,
      HeaderEmployerComponent,
      HeaderEmployeeComponent,
      HeaderStudentComponent
    ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      BrowserAnimationsModule,
      HttpClientModule,
      AuthModule,
      SharedModule,
      AdminModule,
      EmployerModule,
      EmployeeModule,
      StudentModule
    ],
    providers: [],
    bootstrap: [AppComponent]
  })
  export class AppModule { }
  