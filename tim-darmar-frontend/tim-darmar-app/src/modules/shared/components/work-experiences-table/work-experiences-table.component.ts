import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { EmployeeService } from 'src/modules/employee/services/employee.service';
import { EmployerService } from 'src/modules/employer/services/employer.service';
import { WorkExperienceDTO } from '../../models/WorkExperienceDTO';
import { SnackBarService } from '../../services/snack-bar.service';
import { UtilService } from '../../services/util.service';
import { WorkExperienceInfoComponent } from '../work-experience-info/work-experience-info.component';

@Component({
  selector: 'app-work-experiences-table',
  templateUrl: './work-experiences-table.component.html',
  styleUrls: ['./work-experiences-table.component.scss']
})
export class WorkExperiencesTableComponent  implements AfterViewInit {

  @Input() workExperiences: WorkExperienceDTO[] = [];

  role: string = '';

  displayedColumns: string[] = ['id', 'typeOfEmployment', 'dateFrom', 'dateTo', 
  'employerRating', 'employeeRating', 'paid', 
  'employerEmail', 'employeeEmail', 'accepted'];
  dataSource = new MatTableDataSource(this.workExperiences);
  _liveAnnouncer: any;
  
  constructor(private employerService: EmployerService, private employeeService: EmployeeService,
    private utilService: UtilService, public dialog: MatDialog,
    private snackBarService: SnackBarService) { 
  }
  
  ngAfterViewInit(): void {
    this.role = this.utilService.getLoggedUserRole();
    if (this.role === 'ROLE_EMPLOYER') {
      this.employerService.getWorkExperiencesFromEmployer()
      .subscribe((response) => {
        this.workExperiences = response.body as WorkExperienceDTO[];
        this.dataSource = new MatTableDataSource(this.workExperiences);
        this.dataSource.sort = this.sort;
      })
    } else if (this.role === 'ROLE_EMPLOYEE') {
      this.employeeService.getWorkExperiencesFromEmployee()
      .subscribe((response) => {
        this.workExperiences = response.body as WorkExperienceDTO[];
        this.dataSource = new MatTableDataSource(this.workExperiences);
        this.dataSource.sort = this.sort;
      },
      (err) => {
        this.snackBarService.openSnackBar("Banned user!");
      })
    }
  }

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;


  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }

  show(row: any){
    const dialogRef = this.dialog.open(WorkExperienceInfoComponent, {
      width: '1200px',
      data: row,
      autoFocus: false,
      maxHeight: '90vh'
    });

    dialogRef.afterClosed().subscribe(() => {
      if (this.role === 'ROLE_EMPLOYER') {
        this.employerService.getWorkExperiencesFromEmployer()
        .subscribe((response) => {
          this.workExperiences = response.body as WorkExperienceDTO[];
          this.dataSource = new MatTableDataSource(this.workExperiences);
          this.dataSource.sort = this.sort;
        })
      } else if (this.role === 'ROLE_EMPLOYEE') {
        this.employeeService.getWorkExperiencesFromEmployee()
        .subscribe((response) => {
          this.workExperiences = response.body as WorkExperienceDTO[];
          this.dataSource = new MatTableDataSource(this.workExperiences);
          this.dataSource.sort = this.sort;
        })
      }
    });
  }

}
