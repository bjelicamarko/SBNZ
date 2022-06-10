import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { EmployerProfileInfoComponent } from 'src/modules/shared/components/employer-profile-info/employer-profile-info.component';
import { EmployerDTO } from 'src/modules/shared/models/EmployerDTO';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-employers-view',
  templateUrl: './employers-view.component.html',
  styleUrls: ['./employers-view.component.scss']
})
export class EmployersViewComponent implements AfterViewInit {

  employers: EmployerDTO[] = [];

  displayedColumns: string[] = ['email', 'firstName', 'lastName', 
  'employerRecklessnessType', 'employerCarelessnessType'];

  dataSource = new MatTableDataSource(this.employers);
  _liveAnnouncer: any;

  constructor(private adminService: AdminService, 
    public dialog: MatDialog) { }

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  ngAfterViewInit(): void {
    this.adminService.findAllEmployers()
    .subscribe((response) => {
      this.employers = response.body as EmployerDTO[];
      this.dataSource = new MatTableDataSource(this.employers);
        this.dataSource.sort = this.sort;
    })
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }
  
  show(row: any) {
    const dialogRef = this.dialog.open(EmployerProfileInfoComponent, {
      width: '1000px',
      data: row,
      autoFocus: false,
      maxHeight: '90vh'
    });

    dialogRef.afterClosed().subscribe(() => {
      this.adminService.findAllEmployers()
      .subscribe((response) => {
        this.employers = response.body as EmployerDTO[];
        this.dataSource = new MatTableDataSource(this.employers);
          this.dataSource.sort = this.sort;
      })
    });
  }

}
