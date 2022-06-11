import { AreaOfExpertiseGlobally } from "./AreaOfExpertiseGlobally";
import { IntershipDTO } from "./IntershipDTO";
import { ProjectDTO } from "./ProjectDTO";

export interface StudentProfileViewDTO {
    email: string;
    firstName: string;
    lastName: string;
    financialStatus: string;
    statusOfStudent: string;
    monthlyIncomeByFamilyMember: number;
    points: number;
    interships: IntershipDTO[];
    passedSubjects: { id: number, name: string, subjectAreaOfExpertises: AreaOfExpertiseGlobally[] }[];
    uniProjects: ProjectDTO[];
}