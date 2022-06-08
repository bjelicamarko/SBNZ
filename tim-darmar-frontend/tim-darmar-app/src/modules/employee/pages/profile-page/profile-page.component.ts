import { AfterViewInit, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { EmployeeDTO } from 'src/modules/shared/models/EmployeeDTO';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { UtilService } from 'src/modules/shared/services/util.service';
import { AreasLanguagesDialogComponent } from '../../components/areas-languages-dialog/areas-languages-dialog.component';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.scss']
})
export class ProfilePageComponent implements AfterViewInit {

  employee: EmployeeDTO = {
    email: '',
    firstName: '',
    lastName: '',
    role: '',
    languages: [],
    preferredWorkingHours: '',
    preferredSalary: 0,
    points: 0,
    approval: 0,
    areaOfExpertises: [],
    statusOfEmployee: ''
  };

  
  languagesEmployee: string[] = [];
  expertisesEmployee: AreaOfExpertiseGlobally[] = [];

  constructor(private employeeService: EmployeeService, private snackBarService: SnackBarService,
    private utilService: UtilService, public dialog: MatDialog) { }
  
  ngAfterViewInit(): void {
    this.employeeService.profileOfEmployee()
    .subscribe((response) => {
      this.employee = response.body as EmployeeDTO;
      console.log(this.employee);
    })

  }

  openDialog() {
    const dialogRef = this.dialog.open(AreasLanguagesDialogComponent, {
      width: '450px',
      data: {languagesEmployee: this.languagesEmployee, expertisesEmployee: this.expertisesEmployee},
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.languagesEmployee = result.languagesEmployee;
      this.expertisesEmployee = result.expertisesEmployee;
    });
  }

  updateEmployee() {
    this.employee.languages = this.languagesEmployee;
    this.employee.areaOfExpertises = this.expertisesEmployee;
    this.employeeService.updateEmployee(this.employee)
    .subscribe((response) => {
      this.employee = response.body as EmployeeDTO;
    })
  }
}
