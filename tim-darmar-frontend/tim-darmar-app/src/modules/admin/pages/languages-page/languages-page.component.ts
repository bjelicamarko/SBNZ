import { AfterViewInit, Component, OnInit } from '@angular/core';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { LanguageGlobally } from '../../models/LanguageGlobally';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-languages-page',
  templateUrl: './languages-page.component.html',
  styleUrls: ['./languages-page.component.scss']
})
export class LanguagesPageComponent implements AfterViewInit {

  languages: LanguageGlobally[] = [];
  
  inputValue: string = '';

  constructor(private adminService: AdminService, private snackBarService: SnackBarService) { }

  ngAfterViewInit(): void {
    this.adminService.findAllLanguages()
    .subscribe((response) => {
      this.languages = response.body as LanguageGlobally[];
    })
  }

  createLanguage() {
    if (this.inputValue) {
      this.adminService.saveLanguage(this.inputValue)
      .subscribe((response) => {
        this.languages = response.body as LanguageGlobally[];
        this.inputValue = '';
      })
    }
  }

  deleteLanguage() {
    if (this.inputValue) {
      this.adminService.deleteLanguage(this.inputValue)
      .subscribe((response) => {
        this.languages = response.body as LanguageGlobally[];
        this.inputValue = '';
      })
    }
  }
}
