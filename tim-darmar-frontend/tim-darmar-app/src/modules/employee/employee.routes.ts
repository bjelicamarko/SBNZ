import { Routes } from "@angular/router";
import { RoleGuard } from "../auth/guards/role/role.guard";
import { FriendListComponent } from "./pages/friend-list/friend-list.component";
import { ProfilePageComponent } from "./pages/profile-page/profile-page.component";
import { WorkExperiencesPageComponent } from "./pages/work-experiences-page/work-experiences-page.component";

export const EmployeeRoutes: Routes = [
  {
    path: "profile",
    pathMatch: "full",
    component: ProfilePageComponent,
    canActivate: [RoleGuard],
    data: { expectedRoles: "ROLE_EMPLOYEE" },
  },
  {
    path: "friends",
    pathMatch: "full",
    component: FriendListComponent,
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