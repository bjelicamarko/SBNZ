import { Component, OnInit } from '@angular/core';
import { EmployeeSearchDTO } from 'src/modules/shared/models/EmployeeSearchDTO';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-friend-list',
  templateUrl: './friend-list.component.html',
  styleUrls: ['./friend-list.component.scss']
})
export class FriendListComponent implements OnInit {

  public selectedID: string = '';
  public nonFriendUsers: { id: number, firstName: string, lastName: string }[] = [];
  public friends: { id: number, firstName: string, lastName: string }[] = [];
  public specs: string[] = [];
  public selectedSpec: string = '';

  public resultEmployee: EmployeeSearchDTO | undefined;

  constructor(private employeeService: EmployeeService, private snackBarService: SnackBarService) { }

  ngOnInit(): void {
    this.employeeService.getNonFriends()
      .subscribe((response) => {
        if (!response.body)
          return;
        this.nonFriendUsers = response.body;
      }
      );

    this.employeeService.getFriends()
      .subscribe((response) => {
        if (!response.body)
          return;
        this.friends = response.body;
      }
      );

    this.employeeService.getSpecs()
      .subscribe((response) => {
        if (!response.body)
          return;
        this.specs = response.body;
      }
      );
  }

  public search() {
    if (!this.selectedSpec)
      return;

    this.employeeService.getEmployeeWithExpertise(this.selectedSpec)
      .subscribe((response) => {
        if (!response.body) {
          this.snackBarService.openSnackBar("You already have that working experience!");
          return;
        }

        this.resultEmployee = response.body;
      }, (err) => {
        this.snackBarService.openSnackBar("No results!");
      }
      );
  }

}
