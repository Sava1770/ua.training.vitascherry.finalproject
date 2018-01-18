SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema student_inspector
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS student_inspector ;

-- -----------------------------------------------------
-- Schema student_inspector
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS student_inspector DEFAULT CHARACTER SET utf8 ;
USE student_inspector ;

-- -----------------------------------------------------
-- Table student_inspector.topic
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.topic ;

CREATE TABLE IF NOT EXISTS student_inspector.topic (
  id_topic INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(65) NOT NULL,
  PRIMARY KEY (id_topic),
  UNIQUE INDEX id_topic_UNIQUE (id_topic ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table student_inspector.quiz
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.quiz ;

CREATE TABLE IF NOT EXISTS student_inspector.quiz (
  id_quiz INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(65) NOT NULL,
  id_topic INT NOT NULL,
  PRIMARY KEY (id_quiz),
  UNIQUE INDEX id_quiz_UNIQUE (id_quiz ASC),
  INDEX fk_quiz_topic1_idx (id_topic ASC),
  CONSTRAINT fk_quiz_topic1
    FOREIGN KEY (id_topic)
    REFERENCES student_inspector.topic (id_topic)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table student_inspector.question
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.question ;

CREATE TABLE IF NOT EXISTS student_inspector.question (
  id_question INT NOT NULL AUTO_INCREMENT,
  text VARCHAR(500) NOT NULL,
  PRIMARY KEY (id_question),
  UNIQUE INDEX id_question_UNIQUE (id_question ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table student_inspector.answer
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.answer ;

CREATE TABLE IF NOT EXISTS student_inspector.answer (
  id_answer INT NOT NULL AUTO_INCREMENT,
  text VARCHAR(250) NOT NULL,
  PRIMARY KEY (id_answer),
  UNIQUE INDEX id_answer_UNIQUE (id_answer ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table student_inspector.user
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.user ;

CREATE TABLE IF NOT EXISTS student_inspector.user (
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
-- Table student_inspector.problem
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.problem ;

CREATE TABLE IF NOT EXISTS student_inspector.problem (
  id_quiz INT NOT NULL,
  id_question INT NOT NULL,
  PRIMARY KEY (id_quiz, id_question),
  INDEX fk_problem_question1_idx (id_question ASC),
  CONSTRAINT fk_problem_quiz1
    FOREIGN KEY (id_quiz)
    REFERENCES student_inspector.quiz (id_quiz)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_problem_question1
    FOREIGN KEY (id_question)
    REFERENCES student_inspector.question (id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table student_inspector.question_answer
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.question_answer ;

CREATE TABLE IF NOT EXISTS student_inspector.question_answer (
  id_question INT NOT NULL,
  id_answer INT NOT NULL,
  is_correct TINYINT NOT NULL,
  PRIMARY KEY (id_question, id_answer),
  INDEX fk_question_answer_answer1_idx (id_answer ASC),
  CONSTRAINT fk_question_answer_question1
    FOREIGN KEY (id_question)
    REFERENCES student_inspector.question (id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_question_answer_answer1
    FOREIGN KEY (id_answer)
    REFERENCES student_inspector.answer (id_answer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table student_inspector.solution
-- -----------------------------------------------------
DROP TABLE IF EXISTS student_inspector.solution ;

CREATE TABLE IF NOT EXISTS student_inspector.solution (
  id_user INT NOT NULL,
  id_quiz INT NOT NULL,
  id_question INT NOT NULL,
  id_answer INT NOT NULL,
  PRIMARY KEY (id_user, id_quiz, id_question, id_answer),
  INDEX fk_solution_problem1_idx (id_quiz ASC, id_question ASC),
  INDEX fk_solution_question_answer_idx (id_question ASC, id_answer ASC),
  CONSTRAINT fk_solution_user
    FOREIGN KEY (id_user)
    REFERENCES student_inspector.user (id_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_solution_problem
    FOREIGN KEY (id_quiz , id_question)
    REFERENCES student_inspector.problem (id_quiz , id_question)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_solution_question_answer
    FOREIGN KEY (id_question , id_answer)
    REFERENCES student_inspector.question_answer (id_question , id_answer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table student_inspector.user
-- -----------------------------------------------------
INSERT INTO student_inspector.user
(first_name, last_name, patronymic, email, role, password_hash) VALUES
('Шницель', 'Австрийский', 'Жаренный', 'root.root@gmail.com', 'ADMIN', '6cb75f652a9b52798eb6cf2201057c73'),
('Андрей', 'Полоз', 'Иванович', 'andrew.poloz@gmail.com', 'STUDENT', '0f82abddebfe5e8050f8e53cafa46cec'),
('Василий', 'Пупкин', 'Владимирович', 'vasya.poop@gmail.com', 'STUDENT', '4f124ce684353fdb71a1b32c01e373df'),
('Дмитрий', 'Петровский', 'Александрович', 'petrovskiy.dima@gmail.com', 'STUDENT', '362a6336c0829467db740571fa1600f3'),
('Олег', 'Бандушкин', 'Алексеевич', 'oleg.band@gmail.com', 'STUDENT', 'eff394ffdfb271eff1326f3f9074c2d8'),
('Алексей', 'Варанов', 'Владимирович', 'alex.var@gmail.com', 'STUDENT', '651cdc58fa7c8ab376dcacf95fb7e565'),
('Роман', 'Савостин', 'Алексеевич', 'roma.sava@gmail.com', 'STUDENT', 'e5e641e1b6e3325b2e2ab8dd23e41752');

-- -----------------------------------------------------
-- Table student_inspector.topic
-- -----------------------------------------------------
INSERT INTO student_inspector.topic (name) VALUES ('English for beginners');

-- -----------------------------------------------------
-- Table student_inspector.quiz
-- -----------------------------------------------------
INSERT INTO student_inspector.quiz (name, id_topic) VALUES ('Level Test', 1);

-- -----------------------------------------------------
-- Table student_inspector.question
-- -----------------------------------------------------
INSERT INTO student_inspector.question (text) VALUES
('I haven\'t got ……'),
('We haven\'t got ..... Champagne'),
(''),
('George..... fly to Stockholm tomorrow.'),
('I have Flamenco classes ……'),
('We have to go to the supermarket ..... some bread and milk.'),
('The party was a disaster. There ..... there!'),
(''),
(''),
('Michael.........Paris in the morning'),
('That file belongs to Patricia, give it to'),
(''),
(''),
('Mark ..... fly to London tomorrow.');

-- -----------------------------------------------------
-- Table student_inspector.answer
-- -----------------------------------------------------
INSERT INTO student_inspector.answer (text) VALUES
('no brothers or sisters'),
('brothers or sisters'),
('any brothers or sisters'),
('some brothers and sisters'),
('a lot'),
('little'),
('too'),
('much'),
('Where playing Real Madrid?'),
('Where is playing Real Madrid?'),
('Where is Real Madrid playing?'),
('Where playing is Real Madrid?'),
('to going'),
('goes to'),
('is going to'),
('go to'),
('on Saturday afternoons'),
('in Saturday afternoons'),
('at Saturday afternoons'),
('by Saturday afternoons'),
('for getting'),
('to get'),
('to getting '),
('for to get'),
('wasn\'t nobody'),
('was anybody'),
('was nobody'),
('was somebody'),
('He never comes after 2:30'),
('He never after 2:30 comes'),
('He comes never after 2:30'),
('After 2:30 he never comes'),
('Taking train what you are?'),
('What train taking are you?'),
('Are you what train taking?'),
('What train are you taking?'),
('to leaving'),
('leaves for'),
('is leaving for'),
('leave to'),
('it'),
('him'),
('her'),
('them'),
('Arrives Philip late never.'),
('Late,Philip never arrives'),
('Philip arrives late never.'),
('Philip never arrives late.'),
('Always he wakes up at 9:00.'),
('He wakes up at always 9:00.'),
('He always wakes up at 9:00.'),
('He wakes always up at 9:00.'),
('to going'),
('goes to'),
('is going to'),
('go to');

-- -----------------------------------------------------
-- Table student_inspector.question_answer
-- -----------------------------------------------------
INSERT INTO student_inspector.question_answer (id_question, id_answer, is_correct) VALUES
(1, 1, 0),
(1, 2, 0),
(1, 3, 1),
(1, 4, 0),
(2, 5, 0),
(2, 6, 0),
(2, 7, 0),
(2, 8, 1),
(3, 9, 0),
(3, 10, 0),
(3, 11, 1),
(3, 12, 0),
(4, 13, 0),
(4, 14, 0),
(4, 15, 1),
(4, 16, 0),
(5, 17, 1),
(5, 18, 0),
(5, 19, 0),
(5, 20, 0),
(6, 21, 0),
(6, 22, 1),
(6, 23, 0),
(6, 24, 0),
(7, 25, 0),
(7, 26, 0),
(7, 27, 1),
(7, 28, 0),
(8, 29, 1),
(8, 30, 0),
(8, 31, 0),
(8, 32, 0),
(9, 33, 0),
(9, 34, 0),
(9, 35, 0),
(9, 36, 1),
(10, 37, 0),
(10, 38, 0),
(10, 39, 1),
(10, 40, 0),
(11, 41, 0),
(11, 42, 0),
(11, 43, 1),
(11, 44, 0),
(12, 45, 0),
(12, 46, 0),
(12, 47, 0),
(12, 48, 1),
(13, 49, 0),
(13, 50, 0),
(13, 51, 1),
(13, 52, 0),
(14, 53, 0),
(14, 54, 0),
(14, 55, 1),
(14, 56, 0);

-- -----------------------------------------------------
-- Table student_inspector.problem
-- -----------------------------------------------------
INSERT INTO student_inspector.problem (id_quiz, id_question) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14);

-- -----------------------------------------------------
-- Table student_inspector.solution
-- -----------------------------------------------------
INSERT INTO student_inspector.solution (id_user, id_quiz, id_question, id_answer) VALUES
(2, 1, 1, 3),
(2, 1, 2, 5),
(2, 1, 3, 11),
(2, 1, 4, 15),
(2, 1, 5, 17),
(2, 1, 6, 21),
(2, 1, 7, 26),
(2, 1, 8, 29),
(2, 1, 9, 33),
(2, 1, 10, 37),
(2, 1, 11, 41),
(2, 1, 12, 48),
(2, 1, 13, 51),
(2, 1, 14, 56);