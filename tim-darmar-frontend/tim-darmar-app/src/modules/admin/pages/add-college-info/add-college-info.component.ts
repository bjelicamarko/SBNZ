import { Component, OnInit } from '@angular/core';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { Temp } from 'src/modules/shared/models/Temp';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { UtilService } from 'src/modules/shared/services/util.service';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-add-college-info',
  templateUrl: './add-college-info.component.html',
  styleUrls: ['./add-college-info.component.scss']
})
export class AddCollegeInfoComponent implements OnInit {

  expertises: AreaOfExpertiseGlobally[] = [];

  tempExpertises: Temp[] = [];

  public subjectName: string = '';
  public selectedID: string = '';
  public students: { id: number, name: string, email: string }[] = [];

  constructor(private utilService: UtilService, private adminService: AdminService, private snackBarService: SnackBarService) { }

  ngOnInit(): void {
    this.adminService.getStudentsNamesWithIDS()
      .subscribe((response) => {
        if (!response.body)
          return;
        this.students = response.body as { id: number, name: string, email: string }[];
      }
      );

    this.utilService.findAllExpertisesGlobally()
      .subscribe((response) => {
        this.expertises = response.body as AreaOfExpertiseGlobally[];
        for (var i = 0; i < this.expertises.length; i++) {
          var obj: Temp = {
            nameOfArea: '',
            specializations: []
          };
          obj.nameOfArea = this.expertises[i].nameOfArea;
          for (var j = 0; j < this.expertises[i].specializations.length; j++) {
            obj.specializations.push({ name: this.expertises[i].specializations[j], checked: false });
          }
          this.tempExpertises.push(obj);
        }
      })
  }

  public submitSubject() {
    let expertises: AreaOfExpertiseGlobally[] = this.utilService.returnCheckedAreas(this.tempExpertises);
    let studentID = this.selectedID;
    if (!studentID || !expertises || !this.subjectName || expertises.length == 0)
      return;

    this.adminService.addCollegeSubject({ studentID: this.selectedID, uniSubject: { name: this.subjectName, subjectAreaOfExpertises: expertises } })
      .subscribe((response) => {
        if (!response.body)
          return;
        this.snackBarService.openSnackBar(response.body);
      }
      );
  }

}
