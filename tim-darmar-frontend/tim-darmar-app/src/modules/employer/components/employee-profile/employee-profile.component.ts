import { AfterViewInit, Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { EmployeeDTO } from 'src/modules/shared/models/EmployeeDTO';
import { LanguageGlobally } from 'src/modules/shared/models/LanguageGlobally';
import { Temp } from 'src/modules/shared/models/Temp';
import { UtilService } from 'src/modules/shared/services/util.service';
import { RequestForEmployee } from '../../models/RequestForEmployee';
import { EmployerService } from '../../services/employer.service';

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.scss']
})
export class EmployeeProfileComponent implements AfterViewInit {

  expertises: AreaOfExpertiseGlobally[] = [];
  tempExpertises: Temp[] = [];
  typeOfEmployment: string = '';

  constructor(private utilService: UtilService, private employerService: EmployerService,
    public dialogRef: MatDialogRef<EmployeeProfileComponent>,
    @Inject(MAT_DIALOG_DATA) public employee: EmployeeDTO
  ) { }

  ngAfterViewInit(): void {
    this.employerService.getRequest()
    .subscribe((response) => {
      let temp = response.body as RequestForEmployee;
      this.typeOfEmployment = temp.typeOfEmployment;
      for (var i = 0; i < temp.areaOfExpertises.length; i++)
      {
        var obj: Temp = {
          nameOfArea: '',
          specializations: []
        };
        obj.nameOfArea = temp.areaOfExpertises[i].nameOfArea;
        for (var j = 0; j < temp.areaOfExpertises[i].specializations.length; j++) {
          obj.specializations.push({ name: temp.areaOfExpertises[i].specializations[j], checked: false });
        }
        this.tempExpertises.push(obj);
      }
    })
  }

}
