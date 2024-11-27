```
CREATE SCHEMA `koddb` ;
```
```
CREATE TABLE `koddb`.`kodstudent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
```
```
CREATE TABLE `koddb`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `stu_id` INT NULL,
  PRIMARY KEY (`id`),
	FOREIGN KEY (stu_id) REFERENCES kodstudent(id),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
```
