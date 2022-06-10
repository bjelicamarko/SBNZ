import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from "rxjs";
import { WorkExperienceDTO } from "../models/WorkExperienceDTO";

@Injectable({
    providedIn: 'root'
})
export class WorkExperienceUtilService {

    private headers = new HttpHeaders({ "Content-Type": "application/json" });
  
    constructor(private http: HttpClient) { }

    acceptWorkExperience(objx: WorkExperienceDTO): Observable<HttpResponse<WorkExperienceDTO>>{
        let queryParams = {};
      
          queryParams = {
            headers: this.headers,
            observe: "response",
          };
    
        return this.http.post<HttpResponse<WorkExperienceDTO>>("sbnz/api/work-experience/acceptWorkExperience", objx, queryParams);
      }

    finishWorkExperience(objx: WorkExperienceDTO): Observable<HttpResponse<WorkExperienceDTO>>{
        let queryParams = {};
      
          queryParams = {
            headers: this.headers,
            observe: "response",
          };
    
        return this.http.post<HttpResponse<WorkExperienceDTO>>("sbnz/api/work-experience/finishWorkExperience", objx, queryParams);
    }

    payWorkExperience(objx: WorkExperienceDTO): Observable<HttpResponse<WorkExperienceDTO>>{
        let queryParams = {};
      
          queryParams = {
            headers: this.headers,
            observe: "response",
          };
    
        return this.http.post<HttpResponse<WorkExperienceDTO>>("sbnz/api/work-experience/payWorkExperience", objx, queryParams);
    }

    markEmployee(objx: WorkExperienceDTO): Observable<HttpResponse<WorkExperienceDTO>>{
      let queryParams = {};
    
        queryParams = {
          headers: this.headers,
          observe: "response",
        };
  
      return this.http.post<HttpResponse<WorkExperienceDTO>>("sbnz/api/work-experience/markEmployee", objx, queryParams);
    }

    markEmployer(objx: WorkExperienceDTO): Observable<HttpResponse<WorkExperienceDTO>>{
      let queryParams = {};
    
        queryParams = {
          headers: this.headers,
          observe: "response",
        };
  
      return this.http.post<HttpResponse<WorkExperienceDTO>>("sbnz/api/work-experience/markEmployer", objx, queryParams);
  }
}  