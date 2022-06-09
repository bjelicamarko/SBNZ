import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { EmployeeDTO } from 'src/modules/shared/models/EmployeeDTO';
import { StudentDTO } from 'src/modules/shared/models/StudentDTO';
import { Temp } from 'src/modules/shared/models/Temp';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { UtilService } from 'src/modules/shared/services/util.service';
import { RequestForEmployee } from '../../models/RequestForEmployee';
import { RequestForStudent } from '../../models/RequestForStudent';
import { EmployerService } from '../../services/employer.service';
import { SharedEmployeeService } from '../../services/shared-employee.service';

@Component({
  selector: 'app-request-for-student-page',
  templateUrl: './request-for-student-page.component.html',
  styleUrls: ['./request-for-student-page.component.scss']
})
export class RequestForStudentPageComponent implements AfterViewInit {

  expertises: AreaOfExpertiseGlobally[] = [];

  tempExpertises: Temp[] = [];

  workMethods: string = '';

  public students: StudentDTO[] = [];

  constructor(private employerService: EmployerService, private utilService: UtilService,
    private snackBarService: SnackBarService, private router: Router,
    private sharedEmployeeService: SharedEmployeeService) {
    this.sharedEmployeeService.getStudents().subscribe(res => this.students = res);
  }

  ngAfterViewInit(): void {
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

  submit() {
    let expertises: AreaOfExpertiseGlobally[] = this.utilService.returnCheckedAreas(this.tempExpertises);
    if (this.workMethods && expertises.length > 0) {
      let obj: RequestForStudent = {
        workMethods: this.workMethods,
        areaOfExpertises: expertises
      };
      this.employerService.createRequestForStudents(obj)
        .subscribe((response) => {
          this.students = response.body as StudentDTO[];
          if (this.students.length > 0) {
            this.sharedEmployeeService.addStudents(this.students);
            this.router.navigate(['/darmar-app/employer/student-recommendation']);
          } else {
            this.snackBarService.openSnackBar("Empty list!");
          }
        })
    }

  }

}
