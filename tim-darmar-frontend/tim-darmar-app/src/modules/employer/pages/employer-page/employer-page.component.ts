import { AfterViewInit, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EmployerProfileInfoComponent } from 'src/modules/shared/components/employer-profile-info/employer-profile-info.component';
import { EmployerDTO } from 'src/modules/shared/models/EmployerDTO';
import { EmployerService } from '../../services/employer.service';

@Component({
  selector: 'app-employer-page',
  templateUrl: './employer-page.component.html',
  styleUrls: ['./employer-page.component.scss']
})
export class EmployerPageComponent implements AfterViewInit {

  employer: EmployerDTO = {
    email: '',
    firstName: '',
    lastName: '',
    role: '',
    companyAverageRating: 0,
    penaltyPoints: 0,
    penalty: false,
    employerRecklessnessType: '',
    employerCarelessnessType: ''
  };

  constructor(private employerService: EmployerService, public dialog: MatDialog) { }

  ngAfterViewInit(): void {
    this.employerService.profileOfEmployer()
    .subscribe((response) => {
      this.employer = response.body as EmployerDTO;
      this.dialog.open(EmployerProfileInfoComponent, {
        width: '1000px',
        data: this.employer,
        autoFocus: false,
        maxHeight: '90vh'
      });
    })
    
  }

}
