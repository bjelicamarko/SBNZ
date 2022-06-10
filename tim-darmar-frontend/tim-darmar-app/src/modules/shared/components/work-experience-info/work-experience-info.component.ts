import { AfterViewInit, Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { WorkExperienceDTO } from '../../models/WorkExperienceDTO';
import { UtilService } from '../../services/util.service';
import { WorkExperienceUtilService } from '../../services/work-experience-util.service';

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
    WorkExperienceUtilService) { }


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
    this.workExperienceUtilService.markEmployee(this.workExperience)
    .subscribe((response) => {
      this.workExperience = response.body as WorkExperienceDTO;
    })
  }

  markEmployer(): void {
    this.workExperienceUtilService.markEmployer(this.workExperience)
    .subscribe((response) => {
      this.workExperience = response.body as WorkExperienceDTO;
    })
  }
}
