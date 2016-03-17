-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema high_school
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema high_school
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `high_school` DEFAULT CHARACTER SET utf8 ;
USE `high_school` ;

-- -----------------------------------------------------
-- Table `high_school`.`Schedule_time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `high_school`.`Schedule_time` (
  `schedule_time_id` INT(11) NOT NULL AUTO_INCREMENT,
  `beginning_hours` TIME NOT NULL,
  `ending_hours` TIME NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`schedule_time_id`),
  UNIQUE INDEX `schedule_time_id_UNIQUE` (`schedule_time_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `high_school`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `high_school`.`Course` (
  `course_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `assigned_teacher` INT(11) NOT NULL,
  `hours_by_week` INT(11) NOT NULL,
  `schedule_time_id` INT(11) NOT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE INDEX `idCourse_UNIQUE` (`course_id` ASC),
  INDEX `schedule_time_id_idx` (`schedule_time_id` ASC),
  CONSTRAINT `schedule_time_id`
    FOREIGN KEY (`schedule_time_id`)
    REFERENCES `high_school`.`Schedule_time` (`schedule_time_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `high_school`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `high_school`.`Student` (
  `student_id` INT(11) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `registration_number` INT(11) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE INDEX `idStudent_UNIQUE` (`student_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `high_school`.`Student_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `high_school`.`Student_course` (
  `student_course_id` INT(11) NOT NULL AUTO_INCREMENT,
  `course_id` INT(11) NOT NULL,
  `student_id` INT(11) NOT NULL,
  `parcial_note_1` FLOAT NOT NULL,
  `parcial_note_2` FLOAT NOT NULL,
  `parcial_note_3` FLOAT NOT NULL,
  `final_note` FLOAT NOT NULL,
  PRIMARY KEY (`student_course_id`),
  UNIQUE INDEX `idStudent_course_UNIQUE` (`student_course_id` ASC),
  INDEX `course_id_idx` (`course_id` ASC),
  INDEX `student_id_idx` (`student_id` ASC),
  CONSTRAINT `course_id`
    FOREIGN KEY (`course_id`)
    REFERENCES `high_school`.`Course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `high_school`.`Student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `high_school`.`Teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `high_school`.`Teacher` (
  `teacher_id` INT(11) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  PRIMARY KEY (`teacher_id`),
  UNIQUE INDEX `idTeacher_UNIQUE` (`teacher_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `high_school`.`Teacher_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `high_school`.`Teacher_course` (
  `teacher_course_id` INT(11) NOT NULL AUTO_INCREMENT,
  `course_id` INT(11) NOT NULL,
  `teacher_id` INT(11) NOT NULL,
  PRIMARY KEY (`teacher_course_id`),
  UNIQUE INDEX `teacher_course_id_UNIQUE` (`teacher_course_id` ASC),
  INDEX `fk_Teacher_course_1_idx` (`course_id` ASC),
  INDEX `fk_Teacher_course_2_idx` (`teacher_id` ASC),
  CONSTRAINT `fk_Teacher_course_1`
    FOREIGN KEY (`course_id`)
    REFERENCES `high_school`.`Course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teacher_course_2`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `high_school`.`Teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
