import { variable } from '@angular/compiler/src/output/output_ast';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { LanguageGlobally } from 'src/modules/shared/models/LanguageGlobally';
import { Temp } from 'src/modules/shared/models/Temp';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { UtilService } from 'src/modules/shared/services/util.service';
import { EmployerService } from '../../services/employer.service';

@Component({
  selector: 'app-request-for-employee-page',
  templateUrl: './request-for-employee-page.component.html',
  styleUrls: ['./request-for-employee-page.component.scss']
})
export class RequestForEmployeePageComponent implements AfterViewInit {

  expertises: AreaOfExpertiseGlobally[] = [];
  
  tempExpertises: Temp[] = [];
  
  languages: LanguageGlobally[] = [];

  constructor(private employerService: EmployerService, private utilService: UtilService, private snackBarService: SnackBarService) { }
  
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
    console.log(this.utilService.returnCheckedLangages(this.languages));
    console.log(this.utilService.returnCheckedAreas(this.tempExpertises));
  }
}
