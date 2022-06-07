import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class EmployerService {

    private headers = new HttpHeaders({ "Content-Type": "application/json" });
  
    constructor(private http: HttpClient) { }

}