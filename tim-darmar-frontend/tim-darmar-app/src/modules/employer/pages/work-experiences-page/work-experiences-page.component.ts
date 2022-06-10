import { AfterViewInit, Component, OnInit } from '@angular/core';
import { WorkExperienceDTO } from 'src/modules/shared/models/WorkExperienceDTO';
import { EmployerService } from '../../services/employer.service';

@Component({
  selector: 'app-work-experiences-page',
  templateUrl: './work-experiences-page.component.html',
  styleUrls: ['./work-experiences-page.component.scss']
})
export class WorkExperiencesPageComponent implements AfterViewInit {


  constructor(private employerService: EmployerService) { 
  }

  ngAfterViewInit(): void {

  }


}
