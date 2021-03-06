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

@NgModule({
    declarations: [
      AppComponent,
      RootLayoutPageComponent,
      NotFoundPageComponent,
      HeaderCommonComponent,
      HeaderAdminComponent
    ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      BrowserAnimationsModule,
      HttpClientModule,
      AuthModule,
      SharedModule,
      AdminModule
    ],
    providers: [],
    bootstrap: [AppComponent]
  })
  export class AppModule { }
  