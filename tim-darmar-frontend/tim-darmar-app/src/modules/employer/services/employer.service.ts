import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from "rxjs";
import { RequestForEmployee } from "../models/RequestForEmployee";
import { EmployeeDTO } from "src/modules/shared/models/EmployeeDTO";
import { WorkExperienceDTO } from "src/modules/shared/models/WorkExperienceDTO";

@Injectable({
    providedIn: 'root'
})
export class EmployerService {

    private headers = new HttpHeaders({ "Content-Type": "application/json" });
  
    constructor(private http: HttpClient) { }

    createRequestForEmployee(objx: RequestForEmployee): Observable<HttpResponse<EmployeeDTO[]>>{
        let queryParams = {};
      
          queryParams = {
            headers: this.headers,
            observe: "response",
          
          };
  
        return this.http.post<HttpResponse<EmployeeDTO[]>>("sbnz/api/employee/getEmployeesFromRecommendation", objx, queryParams);
    }

    getRequest(): Observable<HttpResponse<RequestForEmployee>>{
      let queryParams = {};
    
        queryParams = {
          headers: this.headers,
          observe: "response",
        
        };

      return this.http.get<HttpResponse<RequestForEmployee>>("sbnz/api/request-for-employee/getRequest", queryParams);
    }

    saveWorkExperience(obj: WorkExperienceDTO): Observable<HttpResponse<string>> {
      let queryParams = {};
    
        queryParams = {
          headers: this.headers,
          observe: "response",
          responseType: "text"
        };

      return this.http.post<HttpResponse<string>>("sbnz/api/work-experience/saveWorkExperience", obj, queryParams);
    }
}