import { AfterViewInit, Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EmployerDTO } from '../../models/EmployerDTO';
import { UtilService } from '../../services/util.service';

@Component({
  selector: 'app-employer-profile-info',
  templateUrl: './employer-profile-info.component.html',
  styleUrls: ['./employer-profile-info.component.scss']
})
export class EmployerProfileInfoComponent implements AfterViewInit {

  role: string = '';

  constructor(public dialogRef: MatDialogRef<EmployerProfileInfoComponent>,
    @Inject(MAT_DIALOG_DATA) public employer: EmployerDTO, 
    private utilService: UtilService) { }

  ngAfterViewInit(): void {
    this.role = this.utilService.getLoggedUserRole();
  }

  unbanEmployee() {
    this.utilService.unbanEmployer(this.employer.email)
    .subscribe((response) => {
      this.employer = response.body as EmployerDTO;
    })
  }
}
