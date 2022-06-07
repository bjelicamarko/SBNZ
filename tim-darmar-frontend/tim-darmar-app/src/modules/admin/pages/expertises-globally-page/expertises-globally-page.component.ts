import { AfterViewInit, Component } from '@angular/core';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { UtilService } from 'src/modules/shared/services/util.service';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-expertises-globally-page',
  templateUrl: './expertises-globally-page.component.html',
  styleUrls: ['./expertises-globally-page.component.scss']
})
export class ExpertisesGloballyPageComponent implements AfterViewInit {


  expertises: AreaOfExpertiseGlobally[] = [];
  
  inputValue: string = '';

  constructor(private adminService: AdminService, private utilService: UtilService, private snackBarService: SnackBarService) { }

  ngAfterViewInit(): void {
    this.utilService.findAllExpertisesGlobally()
    .subscribe((response) => {
      this.expertises = response.body as AreaOfExpertiseGlobally[];
    })
  }

  createArea() {
    if (this.inputValue) {
      this.adminService.createExpertisesGlobally(this.inputValue)
      .subscribe((response) => {
        this.expertises = response.body as AreaOfExpertiseGlobally[];
        this.inputValue = '';
      })
    }
  }

  updateArea() {
    if (this.inputValue) {
      this.adminService.updateExpertisesGlobally(this.inputValue)
      .subscribe((response) => {
        this.expertises = response.body as AreaOfExpertiseGlobally[];
        this.inputValue = '';
      })
    }
  }

  deleteArea() {
    if (this.inputValue) {
      this.adminService.deleteExpertisesGlobally(this.inputValue)
      .subscribe((response) => {
        this.expertises = response.body as AreaOfExpertiseGlobally[];
        this.inputValue = '';
      })
    }
  }

}