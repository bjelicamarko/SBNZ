import { Component, OnInit } from '@angular/core';
import { StudentProfileViewDTO } from 'src/modules/shared/models/StudentProfileViewDTO';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { StudentService } from '../../services/student.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  public student: StudentProfileViewDTO | undefined;
  public montlhyIncome: number = 0;

  constructor(private studentService: StudentService, private snackBarService: SnackBarService) { }

  ngOnInit(): void {
    this.studentService.getStudentForProfile()
      .subscribe((response) => {
        if (!response.body)
          return;
        this.student = response.body;
        this.montlhyIncome = this.student.monthlyIncomeByFamilyMember;
      }
      );
  }

  public addMonthlyIncome() {
    if (this.montlhyIncome <= 0)
      return;

    this.studentService.setMonthlyIncome(this.montlhyIncome)
      .subscribe((response) => {
        if (!response.body)
          return;
        this.snackBarService.openSnackBar(response.body);
      }
      );

  }

}
