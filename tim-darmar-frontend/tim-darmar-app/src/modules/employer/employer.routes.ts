import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { EmployeeRecommendationComponent } from "./pages/employee-recommendation/employee-recommendation.component";
import { HomepageComponent } from './pages/homepage/homepage.component';
import { RequestForEmployeePageComponent } from "./pages/request-for-employee-page/request-for-employee-page.component";
import { WorkExperiencesPageComponent } from "./pages/work-experiences-page/work-experiences-page.component";

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
      path: "employee-recommendation",
      pathMatch: "full",
      component: EmployeeRecommendationComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "ROLE_EMPLOYER" },
    },
    {
      path: "work-experiences",
      pathMatch: "full",
      component: WorkExperiencesPageComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "ROLE_EMPLOYER" },
    },
  ];