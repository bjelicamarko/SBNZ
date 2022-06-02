import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { HomePageComponent } from "./pages/home-page/home-page.component";
import { RegistrationComponent } from "./pages/registration/registration.component";

export const AdminRoutes: Routes = [
  {
    path: "home-page",
    pathMatch: "full",
    component: HomePageComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_ADMIN" },
  },
  {
    path: "registration",
    pathMatch: "full",
    component: RegistrationComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_ADMIN" },
  }
];