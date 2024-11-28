```
CREATE SCHEMA `koddb` ;
```
```
CREATE TABLE `koddb`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
```
```
CREATE TABLE `koddb`.`courses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
```
```
CREATE TABLE `koddb`.`course_student` (
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
FOREIGN KEY (student_id) REFERENCES student(id),
FOREIGN KEY (course_id) REFERENCES courses(id),
  PRIMARY KEY (`student_id`, `course_id`));
```
