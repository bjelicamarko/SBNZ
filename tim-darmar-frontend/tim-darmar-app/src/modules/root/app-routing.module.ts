import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundPageComponent } from './pages/not-found-page/not-found-page.component';
import { RootLayoutPageComponent } from './pages/root-layout-page/root-layout-page.component';

const routes: Routes = [
  {
    path: "darmar-app",
    component: RootLayoutPageComponent,
    children: [
      {
        path: "auth",
        loadChildren: () =>
          import("./../auth/auth.module").then((m) => m.AuthModule),
      },
      {
        path: "admin",
        loadChildren: () =>
          import("./../admin/admin.module").then((m) => m.AdminModule),
      },
      {
        path: "employer",
        loadChildren: () =>
          import("./../employer/employer.module").then((m) => m.EmployerModule) 
      },
      {
        path: "employee",
        loadChildren: () =>
          import("./../employee/employee.module").then((m) => m.EmployeeModule)
      },
      {
        path: "student",
        loadChildren: () =>
          import("./../student/student.module").then((m) => m.StudentModule)
      }
    ]
  },
  {
    path: "",
    redirectTo: "darmar-app/auth/login",
    pathMatch: "full",
  },
  {
    path: "**",
    component: NotFoundPageComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }