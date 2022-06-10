import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { ExpertisesGloballyPageComponent } from "./pages/expertises-globally-page/expertises-globally-page.component";
import { LanguagesPageComponent } from "./pages/languages-page/languages-page.component";
import { RegistrationComponent } from "./pages/registration/registration.component";

export const AdminRoutes: Routes = [
  {
    path: "registration",
    pathMatch: "full",
    component: RegistrationComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_ADMIN" },
  },
  {
    path: "expertises-and-specializations",
    pathMatch: "full",
    component: ExpertisesGloballyPageComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_ADMIN" },
  },
  {
    path: "languages",
    pathMatch: "full",
    component: LanguagesPageComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_ADMIN" },
  }
];