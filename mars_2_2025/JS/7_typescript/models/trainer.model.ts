import {Person} from "./person.model";
import {Course} from "./course.enum";

export class Trainer extends Person {

    courses: Course[];

    constructor(firstname: string, lastname: string, age: number, height: number, weight: number, courses: Course[]) {
        super(firstname, lastname, age, height, weight);
        this.courses = courses;
    }
}