create database highschool;
use highschool;


create table Student (RegNumber int not null, 
   FirstName text not null,
   LastName text not null,     
   DateOfBirth date not null, 
   PRIMARY KEY (RegNumber));
   
create table Teacher (idTeacher int not null, 
    FirstName text not null,
    LastName text not null, 
    DateOfBirth date not null, 
    PRIMARY KEY (idTeacher));
    
create table Course (idCourse int not null auto_increment, 
    CourseName text not null,
    AssignedTeacher int not null, 
    HoursByWeek int not null, 
    PRIMARY KEY (idCourse),
    foreign key (AssignedTeacher)
    REFERENCES Teacher(idTeacher));
    
create table CourseList (idCourseList int not null auto_increment, 
    Course int not null,
    Student int not null,
    PartialNote1 int,
    PartialNote2 int,
    PartialNote3 int,
    FinalNote int,
    PRIMARY KEY (idCourseList),
    foreign key (Course)
    REFERENCES Course(idCourse),
    foreign key (Student)
    REFERENCES Student(RegNumber));
    
create table DaysInWeek (idDay int not null auto_increment, 
    Day TEXT NOT NULL,
    PRIMARY KEY (idDay));
    
create table ClassPerWeek (idWeek int not null auto_increment, 
    Day int not null,
    Hour text not null,
    CoursesInWeek int not null,
    PRIMARY KEY (idWeek),
    foreign key (CoursesInWeek)
    REFERENCES CourseList(idCourseList),
    foreign key (Day)
    REFERENCES DaysInWeek(idDay));