import { AreaOfExpertiseGlobally } from "./AreaOfExpertiseGlobally";

export interface EmployeeSearchDTO {
    email: string;
    firstName: string;
    lastName: string;
    areasOfExperienceFromWorkExperiences: AreaOfExpertiseGlobally[];
}
