import { AfterViewInit, Component } from '@angular/core';
import { Router } from '@angular/router';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { EmployeeDTO } from 'src/modules/shared/models/EmployeeDTO';
import { LanguageGlobally } from 'src/modules/shared/models/LanguageGlobally';
import { Temp } from 'src/modules/shared/models/Temp';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { UtilService } from 'src/modules/shared/services/util.service';
import { RequestForEmployee } from '../../models/RequestForEmployee';
import { EmployerService } from '../../services/employer.service';
import { SharedEmployeeService } from '../../services/shared-employee.service';

@Component({
  selector: 'app-request-for-employee-page',
  templateUrl: './request-for-employee-page.component.html',
  styleUrls: ['./request-for-employee-page.component.scss']
})
export class RequestForEmployeePageComponent implements AfterViewInit {

  expertises: AreaOfExpertiseGlobally[] = [];

  tempExpertises: Temp[] = [];
  
  languages: LanguageGlobally[] = [];

  typeOfEmployment: string = 'FULL_TIME';
  requiredWorkingHours: string = '09:00-19:00';
  requiredSalary: number = 10000;

  public employees: EmployeeDTO[] = [];

  constructor(private employerService: EmployerService, private utilService: UtilService,
     private snackBarService: SnackBarService, private router: Router, 
     private sharedEmployeeService: SharedEmployeeService) {
       this.sharedEmployeeService.getData().subscribe(res => this.employees = res);
      }
  
  ngAfterViewInit(): void {
    this.utilService.findAllExpertisesGlobally()
    .subscribe((response) => {
      this.expertises = response.body as AreaOfExpertiseGlobally[];
      for (var i = 0; i < this.expertises.length; i++)
      {
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

    this.utilService.findAllLanguages()
    .subscribe((response) => {
      this.languages = response.body as LanguageGlobally[];
      for (var i = 0; i < this.languages.length; i++)
      {
        this.languages[i].checked = false;
      }
    })

  }

  submit() {
    let languages: string[] =  this.utilService.returnCheckedLangages(this.languages);
    let expertises: AreaOfExpertiseGlobally[] = this.utilService.returnCheckedAreas(this.tempExpertises);
    if (this.requiredWorkingHours && this.requiredSalary > 0 && this.typeOfEmployment
      && languages.length > 0 && expertises.length > 0) {
        let obj: RequestForEmployee = {
          requiredLanguages: languages,
          typeOfEmployment: this.typeOfEmployment,
          requiredWorkingHours: this.requiredWorkingHours,
          requiredSalary: this.requiredSalary,
          areaOfExpertises: expertises
        };
        this.employerService.createRequestForEmployee(obj)
        .subscribe((response) => {
          this.employees = response.body as EmployeeDTO[];
          if (this.employees.length > 0) {
            this.sharedEmployeeService.addDate(this.employees);
            this.router.navigate(['/darmar-app/employer/employee-recommendation']);
          } else {
            this.snackBarService.openSnackBar("Empty list!");
          }
        })
    } else {
      this.snackBarService.openSnackBar("Invalid inputs");
    }
  }
}
