
-- DROP DATABASE highschool;
CREATE DATABASE highschool;
USE highschool;

-- DROP TABLE IF EXISTS schedule;
-- DROP TABLE IF EXISTS course_inscription;
-- DROP TABLE IF EXISTS course;
-- DROP TABLE IF EXISTS student;
-- DROP TABLE IF EXISTS teacher;

-- `teacher` table
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT, 
  `firstname` char(50), 
  `lastname` char(50),
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY(teacher_id)
);

-- `student` table
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` char(50) DEFAULT NULL,
  `lastname` char(50) DEFAULT NULL,
  `regnum` int(11) NOT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`student_id`)
);

-- `course` table
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(100) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `hoursbyweek` int(3) DEFAULT 0,
  PRIMARY KEY(`course_id`),
  FOREIGN KEY (teacher_id) 
        REFERENCES teacher(teacher_id)
        ON DELETE SET NULL,
  INDEX (`name`)
);

-- `course_inscription` table
CREATE TABLE IF NOT EXISTS `course_inscription` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `partialnote1` int(2) DEFAULT NULL,
  `partialnote2` int(2) DEFAULT NULL,
  `partialnote3` int(2) DEFAULT NULL,
  `finalnote` int(2) DEFAULT NULL,
  PRIMARY KEY (`student_id`, `course_id`),
  FOREIGN KEY (student_id)
    REFERENCES student(student_id)
    ON DELETE CASCADE,
  FOREIGN KEY (course_id)
    REFERENCES course(course_id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11), 
  `dayofweek` char(15),
  `starttime` TIME,
  `endtime` TIME,
  PRIMARY KEY (schedule_id),
  FOREIGN KEY (course_id)
    REFERENCES course(course_id)
    ON DELETE CASCADE
);

-- Insert information for
--    3 teachers,
--    3 courses and
--    10 students per course.

INSERT INTO teacher VALUES
    (default, 'Cosme', 'Fulanito', '1980-09-14'),
    (default, 'Armando', 'Barreda', '1977-06-01'),
    (default, 'Juan', 'Topo', '1986-05-15');

INSERT INTO course VALUES
    (default, 'Math', 1, 2),
    (default, 'Music', 2, 2),
    (default, 'Chemistry', 3, 1);

INSERT INTO schedule VALUES
    (default, 1,'Wednesday', '10:30', '11:30'),
    (default, 1,'Monday', '08:00', '09:00'),
    (default, 3,'Tuesday', '08:00', '09:00'),
    (default, 2,'Thursday', '09:30', '10:30'),
    (default, 2,'Friday', '08:30', '10:30');
    

INSERT INTO student VALUES
    (default, 'First Name 1', 'Last Name 1', 104, '1999-02-20'),
    (default, 'First Name 2', 'Last Name 2', 105, '1999-03-29'),
    (default, 'First Name 3', 'Last Name 3', 106, '1999-04-28'),
    (default, 'First Name 4', 'Last Name 4', 107, '1999-05-27'),
    (default, 'First Name 5', 'Last Name 5', 108, '1999-06-26'),
    (default, 'First Name 6', 'Last Name 6', 109, '1999-07-25'),
    (default, 'First Name 7', 'Last Name 7', 110, '1999-08-24'),
    (default, 'First Name 8', 'Last Name 8', 111, '1999-09-23'),
    (default, 'First Name 9', 'Last Name 9', 112, '1999-10-22'),
    (default, 'First Name 10', 'Last Name 10', 120, '1999-11-21'),
    (default, 'First Name 11', 'Last Name 11', 121, '1999-12-20'),
    (default, 'First Name 12', 'Last Name 12', 122, '1999-01-19'),
    (default, 'First Name 13', 'Last Name 13', 123, '1999-02-18'),
    (default, 'First Name 14', 'Last Name 14', 124, '1999-03-17'),
    (default, 'First Name 15', 'Last Name 15', 125, '1999-04-16'),
    (default, 'First Name 16', 'Last Name 16', 126, '1999-05-15'),
    (default, 'First Name 17', 'Last Name 17', 127, '1999-06-14'),
    (default, 'First Name 18', 'Last Name 18', 128, '1999-07-13'),
    (default, 'First Name 19', 'Last Name 19', 140, '1999-08-12'),
    (default, 'First Name 20', 'Last Name 20', 103, '1999-01-31');

INSERT INTO course_inscription VALUES
    (1, 1, default, default, default, 7),
    (1, 2, default, default, default, 5),
    (1, 3, default, default, default, 4),
    (1, 4, default, default, default, 2),
    (1, 5, default, default, default, 2),
    (1, 6, default, default, default, 6),
    (1, 7, default, default, default, 10),
    (1, 8, default, default, default, 4),
    (1, 9, default, default, default, 8),
    (1, 10, default, default, default, 5),
    (2, 10, default, default, default, 4),
    (2, 11, default, default, default, 2),
    (2, 12, default, default, default, 7),
    (2, 13, default, default, default, 7),
    (2, 14, default, default, default, 7),
    (2, 15, default, default, default, 9),
    (2, 16, default, default, default, 1),
    (2, 17, default, default, default, 7),
    (2, 18, default, default, default, 2),
    (2, 19, default, default, default, 2),
    (3, 2, default, default, default, 2),
    (3, 4, default, default, default, 2),
    (3, 6, default, default, default, 4),
    (3, 8, default, default, default, 7),
    (3, 10, default, default, default, 7),
    (3, 12, default, default, default, 9),
    (3, 14, default, default, default, 2),
    (3, 16, default, default, default, 1),
    (3, 18, default, default, default, 2),
    (3, 20, default, default, default, 6);

