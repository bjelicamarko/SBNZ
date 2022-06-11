import { ProjectDTO } from "./ProjectDTO";

export interface IntershipDTO {
    dateFrom: number;
    dateTo: number;
    mentorMarks: number[];
    intershipProjects: ProjectDTO[];
}