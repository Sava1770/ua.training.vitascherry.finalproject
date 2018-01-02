-- MySQL Script generated by MySQL Workbench
-- Tue Jan  2 23:44:24 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema final_project
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS final_project ;

-- -----------------------------------------------------
-- Schema final_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS final_project DEFAULT CHARACTER SET utf8 ;
USE final_project ;

-- -----------------------------------------------------
-- Table final_project.user
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.user ;

CREATE TABLE IF NOT EXISTS final_project.user (
  id_user INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(65) NOT NULL,
  role VARCHAR(45) NOT NULL,
  password_hash VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_user),
  UNIQUE INDEX id_user_UNIQUE (id_user ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project.student
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.student ;

CREATE TABLE IF NOT EXISTS final_project.student (
  id_student INT(11) NOT NULL,
  email VARCHAR(65) NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  patronymic VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_student),
  INDEX fk_student_user1_idx (id_student ASC),
  CONSTRAINT fk_student_user1
    FOREIGN KEY (id_student)
    REFERENCES final_project.user (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project.quiz
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.quiz ;

CREATE TABLE IF NOT EXISTS final_project.quiz (
  id_quiz INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(250) NOT NULL,
  PRIMARY KEY (id_quiz),
  UNIQUE INDEX id_quiz_UNIQUE (id_quiz ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project.question
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.question ;

CREATE TABLE IF NOT EXISTS final_project.question (
  id_question INT(11) NOT NULL AUTO_INCREMENT,
  text VARCHAR(500) NOT NULL,
  id_quiz INT(11) NOT NULL,
  PRIMARY KEY (id_question),
  UNIQUE INDEX id_question_UNIQUE (id_question ASC),
  INDEX question_id_quiz_fk_idx (id_quiz ASC),
  CONSTRAINT question_id_quiz_fk
    FOREIGN KEY (id_quiz)
    REFERENCES final_project.quiz (id_quiz)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project.answer
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.answer ;

CREATE TABLE IF NOT EXISTS final_project.answer (
  id_answer INT(11) NOT NULL AUTO_INCREMENT,
  text VARCHAR(250) NOT NULL,
  is_correct TINYINT NOT NULL,
  id_question INT(11) NOT NULL,
  PRIMARY KEY (id_answer),
  UNIQUE INDEX id_answer_UNIQUE (id_answer ASC),
  INDEX answer_id_question_fk_idx (id_question ASC),
  CONSTRAINT answer_id_question_fk
    FOREIGN KEY (id_question)
    REFERENCES final_project.question (id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project.student_answer
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.student_answer ;

CREATE TABLE IF NOT EXISTS final_project.student_answer (
  id_answer INT(11) NOT NULL,
  id_student INT(11) NOT NULL,
  PRIMARY KEY (id_answer, id_student),
  INDEX student_answer_id_answer_idx (id_answer ASC),
  INDEX fk_student_answer_student1_idx (id_student ASC),
  CONSTRAINT student_answer_id_answer
    FOREIGN KEY (id_answer)
    REFERENCES final_project.answer (id_answer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_student_answer_student1
    FOREIGN KEY (id_student)
    REFERENCES final_project.student (id_student)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project.topic
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.topic ;

CREATE TABLE IF NOT EXISTS final_project.topic (
  id_topic INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_topic),
  UNIQUE INDEX id_topic_UNIQUE (id_topic ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project.quiz_topic
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project.quiz_topic ;

CREATE TABLE IF NOT EXISTS final_project.quiz_topic (
  id_quiz INT(11) NOT NULL,
  id_topic INT(11) NOT NULL,
  PRIMARY KEY (id_quiz, id_topic),
  INDEX quiz_topic_id_topic_idx (id_topic ASC),
  CONSTRAINT quiz_topic_id_quiz
    FOREIGN KEY (id_quiz)
    REFERENCES final_project.quiz (id_quiz)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT quiz_topic_id_topic
    FOREIGN KEY (id_topic)
    REFERENCES final_project.topic (id_topic)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
