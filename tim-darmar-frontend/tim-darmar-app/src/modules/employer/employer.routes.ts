import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { EmployeeRecommendationComponent } from "./pages/employee-recommendation/employee-recommendation.component";
import { HomepageComponent } from './pages/homepage/homepage.component';
import { RequestForEmployeePageComponent } from "./pages/request-for-employee-page/request-for-employee-page.component";
import { RequestForStudentPageComponent } from "./pages/request-for-student-page/request-for-student-page.component";
import { StudentRecommendationComponent } from "./pages/student-recommendation/student-recommendation.component";

export const EmployerRoutes: Routes = [
  {
    path: "home-page",
    pathMatch: "full",
    component: HomepageComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_EMPLOYER" },
  },
  {
    path: "request-for-employee",
    pathMatch: "full",
    component: RequestForEmployeePageComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_EMPLOYER" },
  },
  {
    path: "request-for-student",
    pathMatch: "full",
    component: RequestForStudentPageComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_EMPLOYER" },
  },
  {
    path: "employee-recommendation",
    pathMatch: "full",
    component: EmployeeRecommendationComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_EMPLOYER" },
  },
  {
    path: "student-recommendation",
    pathMatch: "full",
    component: StudentRecommendationComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_EMPLOYER" },
  },
];