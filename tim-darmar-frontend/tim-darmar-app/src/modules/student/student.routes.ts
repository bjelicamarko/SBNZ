import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { HomepageComponent } from './pages/homepage/homepage.component';

export const StudentRoutes: Routes = [
    {
      path: "home-page",
      pathMatch: "full",
      component: HomepageComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "ROLE_STUDENT" },
    },
  ];