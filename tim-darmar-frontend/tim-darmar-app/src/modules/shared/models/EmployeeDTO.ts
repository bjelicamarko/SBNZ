import { AreaOfExpertiseGlobally } from "./AreaOfExpertiseGlobally";

export interface EmployeeDTO {
    email: string;
    firstName: string;
    lastName: string;
    role: string;
    languages: string[];
    preferredWorkingHours: string;
    preferredSalary: number;
    points: number;
    approval: number;
    areaOfExpertises:  AreaOfExpertiseGlobally[];
    statusOfEmployee: string;
}
  