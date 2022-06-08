import { AfterViewInit, Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { LanguageGlobally } from 'src/modules/shared/models/LanguageGlobally';
import { Temp } from 'src/modules/shared/models/Temp';
import { UtilService } from 'src/modules/shared/services/util.service';


export interface DialogData {
  languagesEmployee: string[];
  expertisesEmployee:  AreaOfExpertiseGlobally[];
}

@Component({
  selector: 'app-areas-languages-dialog',
  templateUrl: './areas-languages-dialog.component.html',
  styleUrls: ['./areas-languages-dialog.component.scss']
})
export class AreasLanguagesDialogComponent implements AfterViewInit {

  expertises: AreaOfExpertiseGlobally[] = [];
  tempExpertises: Temp[] = [];
  languages: LanguageGlobally[] = [];

  constructor(private utilService: UtilService, 
    public dialogRef: MatDialogRef<AreasLanguagesDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { 
      dialogRef.beforeClosed().subscribe(() => dialogRef.close(this.data));
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

  submit(): void {
    this.data.languagesEmployee = this.utilService.returnCheckedLangages(this.languages);
    this.data.expertisesEmployee = this.utilService.returnCheckedAreas(this.tempExpertises);   
  }

}
