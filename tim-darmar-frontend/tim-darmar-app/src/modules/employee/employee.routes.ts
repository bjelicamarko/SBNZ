import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { HomepageComponent } from "./pages/homepage/homepage.component";
import { ProfilePageComponent } from "./pages/profile-page/profile-page.component";
import { WorkExperiencesPageComponent } from "./pages/work-experiences-page/work-experiences-page.component";

export const EmployeeRoutes: Routes = [
    {
      path: "home-page",
      pathMatch: "full",
      component: HomepageComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "ROLE_EMPLOYEE" },
    },
    {
      path: "profile",
      pathMatch: "full",
      component: ProfilePageComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "ROLE_EMPLOYEE" },
    },
    {
      path: "work-experiences",
      pathMatch: "full",
      component: WorkExperiencesPageComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "ROLE_EMPLOYEE" },
    },
  ];