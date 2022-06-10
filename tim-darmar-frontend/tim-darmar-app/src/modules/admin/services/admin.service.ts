import { HttpHeaders, HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AreaOfExpertiseGlobally } from 'src/modules/shared/models/AreaOfExpertiseGlobally';
import { EmployerDTO } from 'src/modules/shared/models/EmployerDTO';
import { LanguageGlobally } from 'src/modules/shared/models/LanguageGlobally';

import { RegistrationDTO } from "../models/RegistrationDTO";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private headers = new HttpHeaders({ "Content-Type": "application/json" });

  constructor(private http: HttpClient) { }

  register(registrationDTO: RegistrationDTO): Observable<HttpResponse<string>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",
      responseType: "text"
    };


    return this.http.post<HttpResponse<string>>("sbnz/api/users/register", registrationDTO, queryParams);
  }

  createExpertisesGlobally(inputText: string): Observable<HttpResponse<AreaOfExpertiseGlobally[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.post<HttpResponse<AreaOfExpertiseGlobally[]>>("sbnz/api/areas/createExpertisesGlobally", inputText, queryParams);
  }

  getStudentsNamesWithIDS(): Observable<HttpResponse<{ id: number, name: string, email: string }[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.get<HttpResponse<{ id: number, name: string, email: string }[]>>("sbnz/api/student/getStudentsNamesWithIDs", queryParams);
  }

  addIntership(inter: {
    studentID: string, intership: {
      dateFrom: number, dateTo: number, mentorMarks: { mentor: string, mark: number }[],
      intershipProjects: { mark: number, projectType: string, difficulty: number }[]
    }
  }): Observable<HttpResponse<string>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",
      responseType: "text"

    };

    return this.http.post<HttpResponse<string>>("sbnz/api/student/createIntershipForStudent", inter, queryParams);
  }

  addUniProjects(projs: {
    studentID: string, projects: { mark: number, projectType: string, difficulty: number }[]
  }): Observable<HttpResponse<string>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",
      responseType: "text"

    };

    return this.http.post<HttpResponse<string>>("sbnz/api/student/createProjectsForStudent", projs, queryParams);
  }

  addCollegeSubject(uniSub: {
    studentID: string, uniSubject: {
      name: string, subjectAreaOfExpertises: AreaOfExpertiseGlobally[]
    }
  }): Observable<HttpResponse<string>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",
      responseType: "text"

    };

    return this.http.post<HttpResponse<string>>("sbnz/api/student/createUniSubjectForStudent", uniSub, queryParams);
  }

  updateExpertisesGlobally(inputText: string): Observable<HttpResponse<AreaOfExpertiseGlobally[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.post<HttpResponse<AreaOfExpertiseGlobally[]>>("sbnz/api/areas/updateExpertisesGlobally", inputText, queryParams);
  }

  deleteExpertisesGlobally(inputText: string): Observable<HttpResponse<AreaOfExpertiseGlobally[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.post<HttpResponse<AreaOfExpertiseGlobally[]>>("sbnz/api/areas/deleteExpertisesGlobally", inputText, queryParams);
  }

  saveLanguage(inputText: string): Observable<HttpResponse<LanguageGlobally[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.post<HttpResponse<LanguageGlobally[]>>("sbnz/api/languages/saveLanguage", inputText, queryParams);
  }

  deleteLanguage(inputText: string): Observable<HttpResponse<LanguageGlobally[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.post<HttpResponse<LanguageGlobally[]>>("sbnz/api/languages/deleteLanguage", inputText, queryParams);
  }

  findAllEmployers(): Observable<HttpResponse<EmployerDTO[]>> {
    let queryParams = {};

    queryParams = {
      headers: this.headers,
      observe: "response",

    };

    return this.http.get<HttpResponse<EmployerDTO[]>>("sbnz/api/employer/findAllEmployers", queryParams);
  }
}