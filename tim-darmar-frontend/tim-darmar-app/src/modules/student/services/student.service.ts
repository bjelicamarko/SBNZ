import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StudentProfileViewDTO } from 'src/modules/shared/models/StudentProfileViewDTO';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private headers = new HttpHeaders({ "Content-Type": "application/json" });

  constructor(private http: HttpClient) { }

  getStudentForProfile(): Observable<HttpResponse<StudentProfileViewDTO>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.get<HttpResponse<StudentProfileViewDTO>>("sbnz/api/student/profileView", queryParams);
  }

  setMonthlyIncome(income: number): Observable<HttpResponse<string>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",
      responseType: "text"
    };

    return this.http.post<HttpResponse<string>>("sbnz/api/student/setMonthlyIncome", income, queryParams);
  }
}
