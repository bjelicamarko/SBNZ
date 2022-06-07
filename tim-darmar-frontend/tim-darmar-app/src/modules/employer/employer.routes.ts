import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { HomepageComponent } from './pages/homepage/homepage.component';
import { RequestForEmployeePageComponent } from "./pages/request-for-employee-page/request-for-employee-page.component";

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
  ];