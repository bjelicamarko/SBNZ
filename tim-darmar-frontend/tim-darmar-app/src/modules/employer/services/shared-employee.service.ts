import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, Subject } from "rxjs";
import { EmployeeDTO } from "src/modules/shared/models/EmployeeDTO";

@Injectable({
    providedIn: 'root'
})
export class SharedEmployeeService {

    private employees = new BehaviorSubject<EmployeeDTO[]>([]);

    addDate(data: EmployeeDTO[]): void {
        this.employees.next(data);
    }

    getData(): Observable<EmployeeDTO[]> {
        return this.employees.asObservable();
    }
}