-- MySQL Script generated by MySQL Workbench
-- Sat Jan 13 19:47:01 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema final_project_3
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS final_project_3 ;

-- -----------------------------------------------------
-- Schema final_project_3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS final_project_3 DEFAULT CHARACTER SET utf8 ;
USE final_project_3 ;

-- -----------------------------------------------------
-- Table final_project_3.topic
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.topic ;

CREATE TABLE IF NOT EXISTS final_project_3.topic (
  id_topic INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(65) NOT NULL,
  PRIMARY KEY (id_topic),
  UNIQUE INDEX id_topic_UNIQUE (id_topic ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project_3.quiz
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.quiz ;

CREATE TABLE IF NOT EXISTS final_project_3.quiz (
  id_quiz INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(65) NOT NULL,
  id_topic INT NOT NULL,
  PRIMARY KEY (id_quiz),
  UNIQUE INDEX id_quiz_UNIQUE (id_quiz ASC),
  INDEX fk_quiz_topic1_idx (id_topic ASC),
  CONSTRAINT fk_quiz_topic1
    FOREIGN KEY (id_topic)
    REFERENCES final_project_3.topic (id_topic)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project_3.question
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.question ;

CREATE TABLE IF NOT EXISTS final_project_3.question (
  id_question INT NOT NULL AUTO_INCREMENT,
  text VARCHAR(500) NOT NULL,
  PRIMARY KEY (id_question),
  UNIQUE INDEX id_question_UNIQUE (id_question ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project_3.answer
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.answer ;

CREATE TABLE IF NOT EXISTS final_project_3.answer (
  id_answer INT NOT NULL AUTO_INCREMENT,
  text VARCHAR(250) NOT NULL,
  PRIMARY KEY (id_answer),
  UNIQUE INDEX id_answer_UNIQUE (id_answer ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project_3.user
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.user ;

CREATE TABLE IF NOT EXISTS final_project_3.user (
  id_user INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(65) NOT NULL,
  last_name VARCHAR(65) NOT NULL,
  patronymic VARCHAR(65) NOT NULL,
  email VARCHAR(65) NOT NULL,
  password_hash VARCHAR(100) NOT NULL,
  role VARCHAR(45) NOT NULL DEFAULT 'STUDENT',
  PRIMARY KEY (id_user),
  UNIQUE INDEX id_student_UNIQUE (id_user ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project_3.problem
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.problem ;

CREATE TABLE IF NOT EXISTS final_project_3.problem (
  id_quiz INT NOT NULL,
  id_question INT NOT NULL,
  PRIMARY KEY (id_quiz, id_question),
  INDEX fk_problem_question1_idx (id_question ASC),
  CONSTRAINT fk_problem_quiz1
    FOREIGN KEY (id_quiz)
    REFERENCES final_project_3.quiz (id_quiz)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_problem_question1
    FOREIGN KEY (id_question)
    REFERENCES final_project_3.question (id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project_3.question_answer
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.question_answer ;

CREATE TABLE IF NOT EXISTS final_project_3.question_answer (
  id_question INT NOT NULL,
  id_answer INT NOT NULL,
  is_correct TINYINT NOT NULL,
  PRIMARY KEY (id_question, id_answer),
  INDEX fk_question_answer_answer1_idx (id_answer ASC),
  CONSTRAINT fk_question_answer_question1
    FOREIGN KEY (id_question)
    REFERENCES final_project_3.question (id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_question_answer_answer1
    FOREIGN KEY (id_answer)
    REFERENCES final_project_3.answer (id_answer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table final_project_3.solution
-- -----------------------------------------------------
DROP TABLE IF EXISTS final_project_3.solution ;

CREATE TABLE IF NOT EXISTS final_project_3.solution (
  id_user INT NOT NULL,
  id_quiz INT NOT NULL,
  id_question INT NOT NULL,
  id_answer INT NOT NULL,
  PRIMARY KEY (id_user, id_quiz, id_question, id_answer),
  INDEX fk_solution_problem1_idx (id_quiz ASC, id_question ASC),
  INDEX fk_solution_question_answer_idx (id_question ASC, id_answer ASC),
  CONSTRAINT fk_solution_user
    FOREIGN KEY (id_user)
    REFERENCES final_project_3.user (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_solution_problem
    FOREIGN KEY (id_quiz , id_question)
    REFERENCES final_project_3.problem (id_quiz , id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_solution_question_answer
    FOREIGN KEY (id_question , id_answer)
    REFERENCES final_project_3.question_answer (id_question , id_answer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;