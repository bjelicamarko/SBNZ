import { Component, OnInit } from '@angular/core';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-add-uni-projects',
  templateUrl: './add-uni-projects.component.html',
  styleUrls: ['./add-uni-projects.component.scss']
})
export class AddUniProjectsComponent implements OnInit {

  public selectedID: string = '';

  public projType: string = '';
  public projMark: number = 0;
  public projDifficulty: number = 0;

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

  public submitProjects() {
    let studId = this.selectedID;

    if (!studId || this.selectedProjs.length == 0) {
      this.snackBarService.openSnackBar("No field can be empty!");
      return;
    }

    this.adminService.addUniProjects({ studentID: this.selectedID, projects: this.selectedProjs })
      .subscribe((response) => {
        if (!response.body)
          return;
        this.snackBarService.openSnackBar(response.body);
      }
      );
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
