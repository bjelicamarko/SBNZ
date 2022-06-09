import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { StudentDTO } from 'src/modules/shared/models/StudentDTO';
import { SharedEmployeeService } from '../../services/shared-employee.service';

@Component({
  selector: 'app-student-recommendation',
  templateUrl: './student-recommendation.component.html',
  styleUrls: ['./student-recommendation.component.scss']
})
export class StudentRecommendationComponent implements AfterViewInit {

  public students: StudentDTO[] = [];

  displayedColumns: string[] = ['firstName', 'lastName', 'email', 'financialStatus', 'statusOfStudent', 'monthlyIncomeByFamilyMember', 'points'];
  dataSource = new MatTableDataSource(this.students);
  _liveAnnouncer: any;

  constructor(private sharedEmployeeService: SharedEmployeeService) {
    this.sharedEmployeeService.getStudents().subscribe(res => this.students = res);
  }

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  ngAfterViewInit(): void {
    this.dataSource = new MatTableDataSource(this.students);
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
