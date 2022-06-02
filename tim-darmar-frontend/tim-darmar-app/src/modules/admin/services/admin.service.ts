import { HttpHeaders, HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegistrationDTO } from "../models/RegistrationDTO";

@Injectable({
    providedIn: 'root'
  })
export class AdminService {

    private headers = new HttpHeaders({ "Content-Type": "application/json" });

    constructor(private http: HttpClient) {}

    register(registrationDTO: RegistrationDTO): Observable<HttpResponse<string>> {
        let queryParams = {};
    
        queryParams = {
          headers: this.headers,
          observe: "response",
          responseType: "text"
        };
        
    
        return this.http.post<HttpResponse<string>>("sbnz/api/users/register", registrationDTO, queryParams);
    }
    
}