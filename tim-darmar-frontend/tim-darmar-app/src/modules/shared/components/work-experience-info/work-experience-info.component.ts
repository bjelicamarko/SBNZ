import { AfterViewInit, Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EmployerDTO } from '../../models/EmployerDTO';
import { WorkExperienceDTO } from '../../models/WorkExperienceDTO';
import { SnackBarService } from '../../services/snack-bar.service';
import { UtilService } from '../../services/util.service';
import { WorkExperienceUtilService } from '../../services/work-experience-util.service';
import { EmployerProfileInfoComponent } from '../employer-profile-info/employer-profile-info.component';

@Component({
  selector: 'app-work-experience-info',
  templateUrl: './work-experience-info.component.html',
  styleUrls: ['./work-experience-info.component.scss']
})
export class WorkExperienceInfoComponent implements AfterViewInit {


  role: string = '';

  constructor( public dialogRef: MatDialogRef<WorkExperienceInfoComponent>,
    @Inject(MAT_DIALOG_DATA) public workExperience: WorkExperienceDTO,
    private utilService: UtilService, private workExperienceUtilService:
    WorkExperienceUtilService, private snackBarService: SnackBarService, 
    public dialog: MatDialog) { }


  ngAfterViewInit(): void {
    this.role = this.utilService.getLoggedUserRole();
  }

  acceptWorkExperience(): void {
    this.workExperienceUtilService.acceptWorkExperience(this.workExperience)
    .subscribe((response) => {
      this.workExperience = response.body as WorkExperienceDTO;
    })
  }

  finishWorkExperience(): void {
    this.workExperienceUtilService.finishWorkExperience(this.workExperience)
    .subscribe((response) => {
      this.workExperience = response.body as WorkExperienceDTO;
    })
  }

  payWorkExperience(): void {
    this.workExperienceUtilService.payWorkExperience(this.workExperience)
    .subscribe((response) => {
      this.workExperience = response.body as WorkExperienceDTO;
    })
  }

  markEmployee(): void {
    if (this.workExperience.employeeRating >= 0 && this.workExperience.employeeRating <= 10){
      this.workExperienceUtilService.markEmployee(this.workExperience)
      .subscribe((response) => {
        this.workExperience = response.body as WorkExperienceDTO;
      })
    } else {
      this.snackBarService.openSnackBar("Invalid inputs");
    }
  }

  markEmployer(): void {
    if (this.workExperience.employerRating >= 0 && this.workExperience.employerRating <= 10) {
      this.workExperienceUtilService.markEmployer(this.workExperience)
      .subscribe((response) => {
        this.workExperience = response.body as WorkExperienceDTO;
      })
    } else {
      this.snackBarService.openSnackBar("Invalid inputs");
    }
  }

  infoEmployer(): void {
    this.utilService.findEmployerByEmail(this.workExperience.employerEmail)
    .subscribe((response) => {
      let objs = response.body as EmployerDTO;
      this.dialog.open(EmployerProfileInfoComponent, {
        width: '1000px',
        data: objs,
        autoFocus: false,
        maxHeight: '90vh'
      });
  
    })
  }
}
