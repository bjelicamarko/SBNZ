import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { StudentDTO } from 'src/modules/shared/models/StudentDTO';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-add-intership-page',
  templateUrl: './add-intership-page.component.html',
  styleUrls: ['./add-intership-page.component.scss']
})
export class AddIntershipPageComponent implements OnInit {

  public range = new FormGroup({
    start: new FormControl(),
    end: new FormControl(),
  });

  public selectedID: string = '';

  public mentorName: string = '';
  public mentorMark: number = 0;

  public projType: string = '';
  public projMark: number = 0;
  public projDifficulty: number = 0;

  public selectedMentors: { mentor: string, mark: number }[] = [];
  public selectedProjs: { mark: number, projectType: string, difficulty: number }[] = [];

  public students: { id: number, name: string, email: string }[] = [];

  constructor(private adminService: AdminService, private snackBarService: SnackBarService) { }

  ngOnInit(): void {
    this.adminService.getStudentsNamesWithIDS()
      .subscribe((response) => {
        if (!response.body)
          return;
        this.students = response.body as { id: number, name: string, email: string }[];
      }
      );
  }

  public submitIntership() {
    let studId = this.selectedID;
    let startDate = this.range.controls['start'];
    let endDate = this.range.controls['end'];

    if (!studId || !startDate.value || !endDate.value || this.selectedMentors.length == 0 || this.selectedProjs.length == 0) {
      this.snackBarService.openSnackBar("No field can be empty!");
      return;
    }

    this.adminService.addIntership({ studentID: this.selectedID, intership: { dateFrom: startDate.value.getTime(), dateTo: endDate.value.getTime(), mentorMarks: this.selectedMentors, intershipProjects: this.selectedProjs } })
      .subscribe((response) => {
        if (!response.body)
          return;
        this.snackBarService.openSnackBar(response.body);
      }
      );
  }

  public addMentor() {
    if (!this.mentorName || !this.mentorMark)
      return;

    if (this.mentorMark > 10 || this.mentorMark < 1)
      return;

    this.selectedMentors.push({ mentor: this.mentorName, mark: this.mentorMark });
    this.mentorMark = 0;
    this.mentorName = '';
  }

  public addProject() {
    if (!this.projType || !this.projDifficulty || !this.projMark)
      return;

    if (this.projMark > 10 || this.projMark < 1 || this.projDifficulty < 1 || this.projDifficulty > 10)
      return;

    this.selectedProjs.push({ projectType: this.projType, difficulty: this.projDifficulty, mark: this.projMark });
    this.projMark = 0;
    this.projType = 'INDIVIDUAL';
    this.projDifficulty = 0;
  }


}
