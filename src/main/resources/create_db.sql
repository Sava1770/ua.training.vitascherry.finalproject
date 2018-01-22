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
  role ENUM('STUDENT', 'ADMIN') NOT NULL,
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
  PRIMARY KEY (id_user, id_quiz, id_question),
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
('Шницель', 'Австрийский', 'Жаренный', 'root.root@gmail.com', 'ADMIN', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Андрей', 'Полоз', 'Иванович', 'andrew.poloz@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Василий', 'Пупкин', 'Владимирович', 'vasya.poop@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Дмитрий', 'Петровский', 'Александрович', 'petrovskiy.dima@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Олег', 'Бандушкин', 'Алексеевич', 'oleg.band@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Алексей', 'Варанов', 'Владимирович', 'alex.var@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Роман', 'Савостин', 'Алексеевич', 'roma.sava@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Юрий', 'Дудь', 'Александрович', 'dude.yura@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Артур', 'Севастьянов', 'Николаевич', 'artur.sevas@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Евгений', 'Семёнов', 'Фёдорович', 'eugen.semenov@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Андрей', 'Кравченко', 'Валерьевич', 'andrew.kraw@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99'),
('Алексей', 'Должанский', 'Васильевич', 'alex.dolg@gmail.com', 'STUDENT', '5f4dcc3b5aa765d61d8327deb882cf99');

-- -----------------------------------------------------
-- Table student_inspector.topic
-- -----------------------------------------------------
INSERT INTO student_inspector.topic (name) VALUES
('English for beginners'),
('English for college'),
('English for postgraduate');

-- -----------------------------------------------------
-- Table student_inspector.quiz
-- -----------------------------------------------------
INSERT INTO student_inspector.quiz (name, id_topic) VALUES
('Level Test', 2),
('Vocabulary Test 1', 1),
('Vocabulary Test 2', 1),
('Vocabulary Test 3', 1);

-- -----------------------------------------------------
-- Table student_inspector.question
-- -----------------------------------------------------
INSERT INTO student_inspector.question (text) VALUES
('I haven’t got ________'),
('We haven’t got ________ Champagne'),
(''),
('George ________ fly to Stockholm tomorrow.'),
('I have Flamenco classes ________'),
('We have to go to the supermarket ________ some bread and milk.'),
('The party was a disaster. There ________ there!'),
(''),
(''),
('Michael ________ Paris in the morning'),
('That file belongs to Patricia, give it to'),
(''),
(''),
('Mark ________ fly to London tomorrow.'),
('scared means:'),
('And he and his dad would go to the Byers ________ to get their hair trimmed.'),
('Where are you most likely to see hurdles?'),
('“Thunder and lightning rolled and flashed, and raindrops heavy as leaden balls fell in swift torrents.” - In this sentence, lightning means:'),
('baker means:'),
('What is an aquarium most likely to contain?'),
('“During NASCAR’s long February-to-November season, I also kept tabs on my favorite driver, the irascible Tony Stewart.” - In this sentence, favorite means:'),
('Where would someone be most likely to wear a bikini?'),
('Which technological advance depended upon the invention of the camera?'),
('“Entitled, angry, mean—people were frightened of me.” - In this sentence, frightened means:'),
('wonderful means:'),
('barber means:'),
('Ronald Reagan’s embrace of Mikhail Gorbachev’s perestroika “not only improved relations with the Soviet Union but empowered dissidents throughout Eastern Europe.” - In this sentence, improved means:'),
('What would you most likely do in a gymnasium?'),
('I smuggle frozen TV dinners into the ________ and con her into eating them by saying they’ll go to waste if she doesn’t.'),
('tiny means:'),
('scared means:'),
('lightning means:'),
('What would you most likely buy from a baker?'),
('shiny means:'),
('“The alleged plot was never carried out, but under certain circumstances planning a murder could be a crime under German law.” - In this sentence, murder means:'),
('employee means:'),
('Maya said to me, in a musical voice, “That was an excellent save.” - In this sentence, excellent means:'),
('“Instantly the throng of country people who had gathered to look at the automobile crash deserted that for a view of something more sensational—an airship.” - In this sentence, automobile means:'),
('But the “moon preserves the history of the solar system, how the solar system was formed, and how the earth was formed.” - In this sentence, earth means:'),
('Presently one showed in a patch of moonlight, startlingly big, a huge, black hairy ________ with a long white nose on a grotesque face, and he was stuffing armfuls of white blossom into his mouth with his curved fore claws.'),
('cancelled means:'),
('tobacco means:');

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
('wasn’t nobody'),
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
('Late, Philip never arrives'),
('Philip arrives late never.'),
('Philip never arrives late.'),
('Always he wakes up at 9:00.'),
('He wakes up at always 9:00.'),
('He always wakes up at 9:00.'),
('He wakes always up at 9:00.'),
('to going'),
('goes to'),
('is going to'),
('go to'),
('afraid'),
('private'),
('repeated'),
('foreign'),
('barber'),
('auditor'),
('counselor'),
('reporter'),
('at a costume party'),
('at a public library'),
('at a popular clothing store'),
('at a track and field event'),
('the motion made by flapping up and down'),
('the act of interposing one thing between or among others'),
('the union of deverse things into one body or form or group'),
('an electric discharge between clouds or from cloud to earth'),
('someone who prepares bread or cake'),
('someone who travels for pleasure'),
('a young person attending school'),
('an informal term for a youth or man'),
('tissues'),
('rabbits'),
('fish'),
('mercury'),
('brought to a state of destruction'),
('incapable of being gone across or throught'),
('preferred above all others and treated with partiality'),
('produced or marked by conscious design or premeditation'),
('at a school prom'),
('in a rocket'),
('at the beach'),
('in a wedding precession'),
('the invention of the walkie talkie'),
('the invention of the personal computer'),
('the development of sound effects'),
('the development of the motion picture'),
('careful'),
('afraid'),
('tired'),
('glad'),
('possible'),
('fantastic'),
('average'),
('direct'),
('a defensive football player close behind the linemen'),
('a hairdresser who cuts hair and shaves beards as a trade'),
('a writer who reports and analyzes events of the day'),
('an official who investigates death not due to natural causes'),
('to consider or examine in speech or writing'),
('to make better'),
('prevent from being seen or discovered'),
('be a quiding or motivating force or drive'),
('play basketball'),
('cook a meal'),
('paint a picture'),
('buy clothing'),
('backdrop'),
('incinerator'),
('crucible'),
('refrigerator'),
('hearty'),
('small'),
('prudent'),
('hostile'),
('contracted'),
('attendant'),
('frightened'),
('constant'),
('to travel for the purpose of discovery'),
('the legal dissolution of a marriage'),
('the act of assembling'),
('a pet dog'),
('a hammer'),
('a loaf of bread'),
('a stylish dress'),
('polished'),
('contributing'),
('graduated'),
('psychological'),
('a vaguely specified social event'),
('unlawful premeditated killing of a human being'),
('the formal act of giving agreement or permission'),
('a drastic and far-reaching change in ways of thinking'),
('thinker'),
('idealist'),
('hermit'),
('worker'),
('dreadful'),
('alarming'),
('valid'),
('splendid'),
('a motor vehicle with four wheels'),
('a plant with facilities for manufacturing'),
('a damper that absorbs energy of sudden impulses'),
('the merchandise that a shop has on hand'),
('the physical universe considered as an orderly system'),
('the climate or atmospheric conditions of a region'),
('the orbit of a celestial body'),
('the third planet from the sun'),
('pattern'),
('monster'),
('faculty'),
('target'),
('worldly'),
('implacable'),
('hearty'),
('off'),
('a mixture, as of flour, eggs, and milk, used in cooking'),
('a stock or supply of foods'),
('medicine or therapy that cures disease or relieves pain'),
('plant leaves dried and prepared for smoking or ingestion');

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
(14, 56, 0),
(15, 57, 1),
(15, 58, 0),
(15, 59, 0),
(15, 60, 0),
(16, 61, 1),
(16, 62, 0),
(16, 63, 0),
(16, 64, 0),
(17, 65, 0),
(17, 66, 0),
(17, 67, 0),
(17, 68, 1),
(18, 69, 0),
(18, 70, 0),
(18, 71, 0),
(18, 72, 1),
(19, 73, 1),
(19, 74, 0),
(19, 75, 0),
(19, 76, 0),
(20, 77, 0),
(20, 78, 0),
(20, 79, 1),
(20, 80, 0),
(21, 81, 0),
(21, 82, 0),
(21, 83, 1),
(21, 84, 0),
(22, 85, 0),
(22, 86, 0),
(22, 87, 1),
(22, 88, 0),
(23, 89, 0),
(23, 90, 0),
(23, 91, 0),
(23, 92, 1),
(24, 93, 0),
(24, 94, 1),
(24, 95, 0),
(24, 96, 0),
(25, 97, 0),
(25, 98, 1),
(25, 99, 0),
(25, 100, 0),
(26, 101, 0),
(26, 102, 1),
(26, 103, 0),
(26, 104, 0),
(27, 105, 0),
(27, 106, 1),
(27, 107, 0),
(27, 108, 0),
(28, 109, 1),
(28, 110, 0),
(28, 111, 0),
(28, 112, 0),
(29, 113, 0),
(29, 114, 0),
(29, 115, 0),
(29, 116, 1),
(30, 117, 0),
(30, 118, 1),
(30, 119, 0),
(30, 120, 0),
(31, 121, 0),
(31, 122, 0),
(31, 123, 1),
(31, 124, 0),
(32, 125, 0),
(32, 126, 0),
(32, 127, 0),
(32, 72, 1),
(33, 128, 0),
(33, 129, 0),
(33, 130, 1),
(33, 131, 0),
(34, 132, 1),
(34, 133, 0),
(34, 134, 0),
(34, 135, 0),
(35, 136, 0),
(35, 137, 1),
(35, 138, 0),
(35, 139, 0),
(36, 140, 0),
(36, 141, 0),
(36, 142, 0),
(36, 143, 1),
(37, 144, 0),
(37, 145, 0),
(37, 146, 0),
(37, 147, 1),
(38, 148, 1),
(38, 149, 0),
(38, 150, 0),
(38, 151, 0),
(39, 152, 0),
(39, 153, 0),
(39, 154, 0),
(39, 155, 1),
(40, 156, 0),
(40, 157, 1),
(40, 158, 0),
(40, 159, 0),
(41, 160, 0),
(41, 161, 0),
(41, 162, 0),
(41, 163, 1),
(42, 164, 0),
(42, 165, 0),
(42, 166, 0),
(42, 167, 1);

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
(1, 14),
(2, 15),
(2, 16),
(2, 17),
(2, 18),
(2, 19),
(2, 20),
(2, 21),
(2, 22),
(2, 23),
(2, 24),
(2, 25),
(3, 26),
(3, 27),
(3, 28),
(3, 29),
(3, 30),
(3, 31),
(3, 32),
(4, 33),
(4, 34),
(4, 35),
(4, 36),
(4, 37),
(4, 38),
(4, 39),
(4, 40),
(3, 41),
(3, 42);

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
