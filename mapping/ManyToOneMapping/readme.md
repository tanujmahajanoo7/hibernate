```
CREATE SCHEMA `koddb` ;
```
```
CREATE TABLE `koddb`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
```
```
CREATE TABLE `koddb`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `salary` INT NULL,
  `dept_id` INT NULL,
	FOREIGN KEY (dept_id) REFERENCES department(id),
  PRIMARY KEY (`id`));
```
