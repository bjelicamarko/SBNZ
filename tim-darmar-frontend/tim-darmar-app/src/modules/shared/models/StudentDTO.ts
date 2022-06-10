import { IntershipDTO } from "./IntershipDTO";
import { ProjectDTO } from "./ProjectDTO";

export interface StudentDTO {
    email: string;
    firstName: string;
    lastName: string;
    financialStatus: string;
    statusOfStudent: string;
    monthlyIncomeByFamilyMember: number;
    points: number;
    interships: IntershipDTO[];
    passedSubjects: string[];
    uniProjects: ProjectDTO[];
}