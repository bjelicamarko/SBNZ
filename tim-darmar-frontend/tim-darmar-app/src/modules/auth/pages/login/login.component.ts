import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtHelperService } from "@auth0/angular-jwt";
import { Router } from '@angular/router';
import { Login } from 'src/modules/shared/models/login';
import { AuthService } from '../../services/auth.service';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private snackBarService: SnackBarService
  ) {
    this.form = this.fb.group({
      email: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  ngOnInit(): void {
  }

  submit() {
    const auth: Login = {
      email: this.form.value.email,
      password: this.form.value.password,
    };

    this.authService.login(auth).subscribe((result: any) => {
      this.snackBarService.openSnackBar("Successful login!");

      const token = JSON.stringify(result);
      localStorage.setItem("user", token);

      const jwt: JwtHelperService = new JwtHelperService();
      const info = jwt.decodeToken(token);
      const role = info.role;

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
    },
      (err: any) => {
        if (err.status === 401)
          this.snackBarService.openSnackBar("Bad credentials.");
      }
    );
  }

}
