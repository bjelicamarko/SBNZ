import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { BasicValidator } from 'src/modules/shared/validators/BasicValidator';
import { EmailValidator } from 'src/modules/shared/validators/EmailValidator';
import { MatchValidator } from 'src/modules/shared/validators/MatchValidator';
import { MaxLengthValidator } from 'src/modules/shared/validators/MaxLengthValidator';
import { MinLengthValidator } from 'src/modules/shared/validators/MinLengthValidator';
import { RegistrationDTO } from '../../models/RegistrationDTO';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  form: FormGroup;
  
  constructor(private fb: FormBuilder, private adminService: AdminService,
    private router: Router, private snackBarService: SnackBarService) {
      this.form = this.fb.group({
        email: [null, [Validators.required, EmailValidator]],          
        password: new FormControl('', [Validators.required]),
        repeatPassword: new FormControl('', Validators.required),
        firstname: [null, [Validators.required]],
        lastname: [null, [Validators.required]],
        role: ['Employer', [Validators.required]]
      },
      { validator: MatchValidator('password', 'repeatPassword')});
  }

  ngOnInit(): void {
  }

  get f() {
    return this.form.controls;
  }

  submit() {
    const regDTO: RegistrationDTO = {
      email: this.form.value.email,
      password: this.form.value.password,
      firstname: this.form.value.firstname,
      lastname: this.form.value.lastname,
      role: this.form.value.role
    };

    console.log(regDTO);
    
    this.adminService.register(regDTO).subscribe((result: any) => {
      this.snackBarService.openSnackBar(result.body);
      this.router.navigate(["darmar-app/admin/expertises-and-specializations"]);
    },
      (err: any) => {
        this.snackBarService.openSnackBar(err.error);
      }
    );
  }
}
