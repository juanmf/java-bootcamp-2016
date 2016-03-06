--Inserts

use high-school

db.course.insert({
name: "English", 
teacher: {firstName: "Cosme", lastName: "Fulanito", birthday: new Date("1970-10-10")}, 
students: [
{firstName: "Videl", lastName: "satan", birthday: new Date("1567-09-05"), registrationNumber: 101, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Gohan", lastName: "Son", birthday: new Date("1615-06-03"), registrationNumber: 102, grades: [{type: "partial", score: 7}, {type: "partial", score: 7}, {type: "partial", score: 7}, {type: "final", score: 7}]},
{firstName: "Peter", lastName: "Parker", birthday: new Date("1582-07-02"), registrationNumber: 103, grades: [{type: "partial", score: 8}, {type: "partial", score: 8}, {type: "partial", score: 8}, {type: "final", score: 8}]},
{firstName: "Mary", lastName: "Jane", birthday: new Date("1534-06-23"), registrationNumber: 104, grades: [{type: "partial", score: 6}, {type: "partial", score: 6}, {type: "partial", score: 6}, {type: "final", score: 6}]},
{firstName: "Bruce", lastName: "Willis", birthday: new Date("1599-07-11"), registrationNumber: 105, grades: [{type: "partial", score: 5}, {type: "partial", score: 5}, {type: "partial", score: 5}, {type: "final", score: 5}]},
{firstName: "Ralph", lastName: "gorgory", birthday: new Date("1497-04-16"), registrationNumber: 106, grades: [{type: "partial", score: 2}, {type: "partial", score: 2}, {type: "partial", score: 2}, {type: "final", score: 2}]},
{firstName: "John", lastName: "Smith", birthday: new Date("1548-03-17"), registrationNumber: 107, grades: [{type: "partial", score: 0}, {type: "partial", score: 4}, {type: "partial", score: 2}, {type: "final", score: 1}]},
{firstName: "Anda", lastName: "Laosa", birthday: new Date("1543-01-31"), registrationNumber: 108, grades: [{type: "partial", score: 7}, {type: "partial", score: 5}, {type: "partial", score: 3}, {type: "final", score: 2}]},
{firstName: "Harry", lastName: "Poter", birthday: new Date("1560-11-06"), registrationNumber: 109, grades: [{type: "partial", score: 1}, {type: "partial", score: 1}, {type: "partial", score: 1}, {type: "final", score: 1}]},
{firstName: "Ema", lastName: "Watson", birthday: new Date("1540-06-09"), registrationNumber: 110, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 2}]}],
schedule: { day: "Monday", startHour: "10:00", endHour: "12:00"}});

db.course.insert({
name: "Japanese",
teacher: {firstName: "Armando", lastName: "Barreda", birthday: new Date("1975-12-10")},
students: [
{firstName: "Sherlock", lastName: "Holmes", birthday: null, registrationNumber: 111, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Gregory", lastName: "House", birthday: null, registrationNumber: 112, grades: [{type: "partial", score: 7}, {type: "partial", score: 7}, {type: "partial", score: 7}, {type: "final", score: 7}]},
{firstName: "Luck", lastName: "Gandor", birthday: null, registrationNumber: 113, grades: [{type: "partial", score: 7}, {type: "partial", score: 7}, {type: "partial", score: 7}, {type: "final", score: 7}]},
{firstName: "Ichigo", lastName: "Kurosaki", birthday: null, registrationNumber: 114, grades: [{type: "partial", score: 7}, {type: "partial", score: 7}, {type: "partial", score: 7}, {type: "final", score: 7}]},
{firstName: "Ace", lastName: "Roger", birthday: null, registrationNumber: 115, grades: [{type: "partial", score: 7}, {type: "partial", score: 7}, {type: "partial", score: 7}, {type: "final", score: 5}]},
{firstName: "Clark", lastName: "Kent", birthday: null, registrationNumber: 116, grades: [{type: "partial", score: 7}, {type: "partial", score: 5}, {type: "partial", score: 3}, {type: "final", score: 2}]},
{firstName: "Bruce", lastName: "Wayne", birthday: null, registrationNumber: 117, grades: [{type: "partial", score: 7}, {type: "partial", score: 5}, {type: "partial", score: 3}, {type: "final", score: 2}]},
{firstName: "Claire", lastName: "Stainfeld", birthday: null, registrationNumber: 118, grades: [{type: "partial", score: 7}, {type: "partial", score: 5}, {type: "partial", score: 3}, {type: "final", score: 2}]},
{firstName: "Tony", lastName: "Stark", birthday: null, registrationNumber: 119, grades: [{type: "partial", score: 7}, {type: "partial", score: 5}, {type: "partial", score: 3}, {type: "final", score: 2}]},
{firstName: "Scarlet", lastName: "Johansen", birthday: null, registrationNumber: 120, grades: [{type: "partial", score: 7}, {type: "partial", score: 5}, {type: "partial", score: 3}, {type: "final", score: 2}]}],
schedule: [{day: "Tuesday", startHour: "08:00", endHour: "10:00"}, {day: "Wednesday", startHour: "10:00", endHour: "13:00"}]});

db.course.insert({
name: "French",
teacher: {firstName: "Willie", lastName: "McDougal", birthday: new Date("1970-10-10")},
students: [
{firstName: "Scarlet", lastName: "Johansen", birthday: new Date("1567-09-05"), registrationNumber: 101, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]}, 
{firstName: "Ace", lastName: "Roger", birthday: new Date("1615-06-03"), registrationNumber: 102, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Anda", lastName: "Laosa", birthday: new Date("1582-07-02"), registrationNumber: 103, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Barry", lastName: "Alen", birthday: new Date("1534-06-23"), registrationNumber: 104, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Hall", lastName: "Jordan", birthday: new Date("1599-07-11"), registrationNumber: 105, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Martin", lastName: "Palermo", birthday: null, registrationNumber: 111, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Ema", lastName: "Watson", birthday: null, registrationNumber: 112, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Claire", lastName: "Stainfeld", birthday: null, registrationNumber: 113, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Ichigo", lastName: "Kurosaki", birthday: null, registrationNumber: 114, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]},
{firstName: "Natsu", lastName: "Dragoneel", birthday: null, registrationNumber: 115, grades: [{type: "partial", score: 10}, {type: "partial", score: 10}, {type: "partial", score: 10}, {type: "final", score: 10}]}],
schedule: {day: "Friday", startHour: "06:00", endHour: "18:00"}});


-- Practice 2

db.course.find({name: "English", "students.grades.score": {$gt: 4}}, {"students.firstName": 1, "students.lastName": 1})

-- Practice 3

db.course.find({"teacher.firstName": "Willie", "teacher.lastName": "McDougal"}, {name: 1, _id:0}).sort( {name: 1})

db.course.find({name: English, students: { $elemMatch: {grades.score: {$gt: 4}}}})