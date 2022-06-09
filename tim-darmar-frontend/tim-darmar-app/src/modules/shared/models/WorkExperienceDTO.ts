import { AreaOfExpertiseGlobally } from "./AreaOfExpertiseGlobally";

export interface WorkExperienceDTO {
    typeOfEmployment: string;
    dateFrom: string;
    dateFromVal: number;
    dateTo: string;
    dateToVal: number;
    employerRating: number;
    employeeRating: number;
    paid: boolean;
    employerEmail: string;
    employeeEmail: string;
    areaOfExpertise:  AreaOfExpertiseGlobally;
    accepted: boolean;
}
  