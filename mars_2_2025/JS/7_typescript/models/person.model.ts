export class Person {
    firstname: string;
    lastname: string;
    age: number;
    height: number;
    weight: number;

    constructor(firstname: string, lastname: string, age: number, height: number, weight: number) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}