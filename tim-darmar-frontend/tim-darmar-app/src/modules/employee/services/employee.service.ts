import { HttpHeaders, HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { EmployeeDTO } from "src/modules/shared/models/EmployeeDTO";
import { EmployeeSearchDTO } from "src/modules/shared/models/EmployeeSearchDTO";
import { WorkExperienceDTO } from "src/modules/shared/models/WorkExperienceDTO";

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {

    private headers = new HttpHeaders({ "Content-Type": "application/json" });

    constructor(private http: HttpClient) { }

    profileOfEmployee(): Observable<HttpResponse<EmployeeDTO>> {
        let queryParams = {};

        queryParams = {
            headers: this.headers,
            observe: "response",

        };

        return this.http.get<HttpResponse<EmployeeDTO>>(
            "sbnz/api/employee/profileOfEmployee", queryParams);
    }

    updateEmployee(e: EmployeeDTO): Observable<HttpResponse<EmployeeDTO>> {
        let queryParams = {};

        queryParams = {
            headers: this.headers,
            observe: "response",

        };

        return this.http.post<HttpResponse<EmployeeDTO>>(
            "sbnz/api/employee/updateEmployee", e, queryParams);
    }

    getWorkExperiencesFromEmployee(): Observable<HttpResponse<WorkExperienceDTO[]>> {
        let queryParams = {};

        queryParams = {
            headers: this.headers,
            observe: "response",
        };

        return this.http.get<HttpResponse<WorkExperienceDTO[]>>("sbnz/api/work-experience/getWorkExperiencesFromEmployee", queryParams);
    }

    getNonFriends(): Observable<HttpResponse<{ id: number, firstName: string, lastName: string }[]>> {
        let queryParams = {};

        queryParams = {
            headers: this.headers,
            observe: "response",

        };

        return this.http.get<HttpResponse<{ id: number, firstName: string, lastName: string }[]>>("sbnz/api/employee/getNonFriendsOfEmployee", queryParams);
    }

    getFriends(): Observable<HttpResponse<{ id: number, firstName: string, lastName: string }[]>> {
        let queryParams = {};

        queryParams = {
            headers: this.headers,
            observe: "response",

        };

        return this.http.get<HttpResponse<{ id: number, firstName: string, lastName: string }[]>>("sbnz/api/employee/getFriendsOfEmployee", queryParams);
    }

    getSpecs(): Observable<HttpResponse<string[]>> {
        let queryParams = {};

        queryParams = {
            headers: this.headers,
            observe: "response",

        };

        return this.http.get<HttpResponse<string[]>>("sbnz/api/work-experience/getSpecializationsFromWorkExperiences", queryParams);
    }

    getEmployeeWithExpertise(expertise: string): Observable<HttpResponse<EmployeeSearchDTO>> {
        let queryParams = {};

        queryParams = {
            headers: this.headers,
            observe: "response",

        };

        return this.http.get<HttpResponse<EmployeeSearchDTO>>("sbnz/api/employee/getEmployeeSearchResults/" + expertise, queryParams);
    }
}