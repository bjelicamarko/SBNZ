import { Injectable } from "@angular/core";
import { Router, CanActivate } from "@angular/router";
import { UtilService } from "src/modules/shared/services/util.service";
import { AuthService } from "../../services/auth.service";

@Injectable({
  providedIn: "root",
})
export class LoginGuard implements CanActivate {
  constructor(public auth: AuthService, public router: Router, public utilsService: UtilService) { }

  canActivate(): boolean {
    if (this.auth.isLoggedIn()) {
      let role = this.utilsService.getLoggedUserRole();

      if (role === "ROLE_ADMIN") {
        this.router.navigate(["darmar-app/admin/home-page"]);
      }
      else if (role === "ROLE_EMPLOYER") {
        this.router.navigate(["darmar-app/employer/home-page"]);
      }
      else if (role === "ROLE_EMPLOYEE") {
        this.router.navigate(["darmar-app/employee/home-page"]);
      }
      else if (role === "ROLE_STUDENT") {
        this.router.navigate(["darmar-app/student/home-page"]);
      }
      return false;
    }
    return true;
  }
}
