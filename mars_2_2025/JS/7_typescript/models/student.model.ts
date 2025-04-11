import {Person} from "./person.model";

export class Student extends Person {
    promotion: string;

    constructor(firstname: string, lastname: string, age: number, height: number, weight: number, promotion: string) {
        super(firstname, lastname, age, height, weight);
        this.promotion = promotion;
    }
}