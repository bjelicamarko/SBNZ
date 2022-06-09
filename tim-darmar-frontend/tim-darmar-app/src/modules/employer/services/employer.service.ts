import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from "rxjs";
import { RequestForEmployee } from "../models/RequestForEmployee";
import { EmployeeDTO } from "src/modules/shared/models/EmployeeDTO";
import { StudentDTO } from "src/modules/shared/models/StudentDTO";
import { RequestForStudent } from "../models/RequestForStudent";

@Injectable({
  providedIn: 'root'
})
export class EmployerService {

  private headers = new HttpHeaders({ "Content-Type": "application/json" });

  constructor(private http: HttpClient) { }

  createRequestForEmployee(objx: RequestForEmployee): Observable<HttpResponse<EmployeeDTO[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.post<HttpResponse<EmployeeDTO[]>>("sbnz/api/employee/getEmployeesFromRecommendation", objx, queryParams);
  }

  createRequestForStudents(objx: RequestForStudent): Observable<HttpResponse<StudentDTO[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.post<HttpResponse<StudentDTO[]>>("sbnz/api/student/getStudentsFromRecommendation", objx, queryParams);
  }

}