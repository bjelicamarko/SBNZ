import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { EmployeeDTO } from 'src/modules/shared/models/EmployeeDTO';
import { SharedEmployeeService } from '../../services/shared-employee.service';

@Component({
  selector: 'app-employee-recommendation',
  templateUrl: './employee-recommendation.component.html',
  styleUrls: ['./employee-recommendation.component.scss']
})
export class EmployeeRecommendationComponent implements AfterViewInit {

  public employees: EmployeeDTO[] = [];
  
  displayedColumns: string[] = ['firstName', 'lastName', 'email', 'preferredSalary', 'preferredWorkingHours', 'approval', 'points'];
  dataSource = new MatTableDataSource(this.employees);
  _liveAnnouncer: any;
  
  constructor(private sharedEmployeeService: SharedEmployeeService) { 
    this.sharedEmployeeService.getData().subscribe(res => this.employees = res);
  }
  
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  ngAfterViewInit(): void {
    this.dataSource = new MatTableDataSource(this.employees);
    this.dataSource.sort = this.sort;
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
}