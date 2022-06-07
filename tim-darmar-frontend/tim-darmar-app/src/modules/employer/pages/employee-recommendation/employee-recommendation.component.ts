import { AfterViewInit, Component, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/modules/shared/models/EmployeeDTO';
import { SharedEmployeeService } from '../../services/shared-employee.service';

@Component({
  selector: 'app-employee-recommendation',
  templateUrl: './employee-recommendation.component.html',
  styleUrls: ['./employee-recommendation.component.scss']
})
export class EmployeeRecommendationComponent implements AfterViewInit {

  public employees: EmployeeDTO[] = [];
  
  constructor(private sharedEmployeeService: SharedEmployeeService) { 
    this.sharedEmployeeService.getData().subscribe(res => this.employees = res);
  }
  ngAfterViewInit(): void {
    console.log(this.employees);
  }
}
