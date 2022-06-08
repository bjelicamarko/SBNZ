import { AreaOfExpertiseGlobally } from "src/modules/shared/models/AreaOfExpertiseGlobally";

export interface RequestForEmployee {
    requiredLanguages: string[];
    typeOfEmployment: string;
    requiredWorkingHours: string;
    requiredSalary: number;
    areaOfExpertises: AreaOfExpertiseGlobally[];
}
  