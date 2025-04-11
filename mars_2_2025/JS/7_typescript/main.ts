import { Trainer } from "./models/trainer.model";
import { Person } from "./models/person.model";
import { Student } from "./models/student.model";
import { Course } from "./models/course.enum";

const persons: Person[] = [
    new Person("Alice", "Dupont", 30, 1.70, 60),
    new Person("Bob", "Martin", 25, 1.75, 70),
    new Person("Charlie", "Lemoine", 40, 1.80, 80),
    new Trainer("David", "Legrand", 35, 1.85, 85, [Course.JAVA, Course.JAVASCRIPT]),
    new Trainer("Eva", "Boucher", 29, 1.65, 55, [Course.TYPESCRIPT]),
    new Student("Léo", "Renaud", 22, 1.70, 68, "2025-06"),
    new Student("Sophie", "Petit", 21, 1.60, 55, "2025-06")
];

console.log("Persons:");
persons.forEach(person => {
    if (person instanceof Trainer) {
        console.log(`Trainer: ${person.firstname} ${person.lastname}, Age: ${person.age}, Courses: ${person.courses.join(', ')}`);
    } else if (person instanceof Student) {
        console.log(`Student: ${person.firstname} ${person.lastname}, Age: ${person.age}, Promotion: ${person.promotion}`);
    } else {
        console.log(`Person: ${person.firstname} ${person.lastname}, Age: ${person.age}`);
    }
});


