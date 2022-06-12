import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { AreaOfExpertiseGlobally } from '../models/AreaOfExpertiseGlobally';
import { EmployerDTO } from '../models/EmployerDTO';
import { LanguageGlobally } from '../models/LanguageGlobally';
import { Temp } from '../models/Temp';

@Injectable({
  providedIn: 'root'
})
export class UtilService {

  private headers = new HttpHeaders({ "Content-Type": "application/json" });
  
  constructor(private http: HttpClient) { }

  public getNoPages(totalItems: number, pageSize: number): number {
    return Math.ceil(totalItems / pageSize);
  }

  public getLoggedUserRole(): string {
    const item = localStorage.getItem("user");

    if (item) {
      const jwt: JwtHelperService = new JwtHelperService();
      return jwt.decodeToken(item).role;
    }
    return "";
  }

  public getLoggedUsername(): string {
    const item = localStorage.getItem("user");
    if (item) {
      const jwt: JwtHelperService = new JwtHelperService();
      return jwt.decodeToken(item).sub;
    }
    return "";
  }

  findAllExpertisesGlobally(): Observable<HttpResponse<AreaOfExpertiseGlobally[]>>{
    let queryParams = {};
  
      queryParams = {
        headers: this.headers,
        observe: "response",
      
      };

    return this.http.get<HttpResponse<AreaOfExpertiseGlobally[]>>("sbnz/api/areas/findAllExpertisesGlobally", queryParams);
  }

  findAllLanguages(): Observable<HttpResponse<LanguageGlobally[]>>{
    let queryParams = {};
  
      queryParams = {
        headers: this.headers,
        observe: "response",
      
      };

    return this.http.get<HttpResponse<LanguageGlobally[]>>("sbnz/api/languages/findAllLanguages", queryParams);
  }

  returnCheckedLangages(languages: LanguageGlobally[]): string[] {
    let l: string[] = [];
    for (var i = 0; i < languages.length; i++)
    {
      if (languages[i].checked)
        l.push(languages[i].name);
    }
    return l;
  }

  returnCheckedAreas(temps: Temp[]): AreaOfExpertiseGlobally[] {
    let l: AreaOfExpertiseGlobally[] = [];
    for (var i = 0; i < temps.length; i++)
    {
      var obj: AreaOfExpertiseGlobally = {
        nameOfArea: '',
        specializations: []
      };

      for (var j = 0; j < temps[i].specializations.length; j++) {
        if (temps[i].specializations[j].checked) {
          obj.specializations.push(temps[i].specializations[j].name);
        }
      }
      if (obj.specializations.length > 0) {
        obj.nameOfArea = temps[i].nameOfArea;
        l.push(obj);
      }
    }
    return l;
  }

  findEmployerByEmail(email: string): Observable<HttpResponse<EmployerDTO>>{
    let queryParams = {};
  
      queryParams = {
        headers: this.headers,
        observe: "response",
      
      };

    return this.http.get<HttpResponse<EmployerDTO>>("sbnz/api/employer/findEmployerByEmail/"+email, queryParams);
  }

  unbanEmployer(email: string): Observable<HttpResponse<EmployerDTO>>{
    let queryParams = {};
  
      queryParams = {
        headers: this.headers,
        observe: "response",
      
      };

    return this.http.get<HttpResponse<EmployerDTO>>("sbnz/api/employer/unbanEmployer/"+email, queryParams);
  }
}
