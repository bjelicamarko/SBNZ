import { AreaOfExpertiseGlobally } from "src/modules/shared/models/AreaOfExpertiseGlobally";

export interface RequestForStudent {
    workMethods: string;
    areaOfExpertises: AreaOfExpertiseGlobally[];
}