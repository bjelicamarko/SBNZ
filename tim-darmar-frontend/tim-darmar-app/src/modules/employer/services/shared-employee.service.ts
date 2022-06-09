import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, Subject } from "rxjs";
import { EmployeeDTO } from "src/modules/shared/models/EmployeeDTO";
import { StudentDTO } from "src/modules/shared/models/StudentDTO";

@Injectable({
    providedIn: 'root'
})
export class SharedEmployeeService {

    private employees = new BehaviorSubject<EmployeeDTO[]>([]);

    private students = new BehaviorSubject<StudentDTO[]>([]);

    addDate(data: EmployeeDTO[]): void {
        this.employees.next(data);
    }

    getData(): Observable<EmployeeDTO[]> {
        return this.employees.asObservable();
    }

    addStudents(data: StudentDTO[]): void {
        this.students.next(data);
    }

    getStudents(): Observable<StudentDTO[]> {
        return this.students.asObservable();
    }
}