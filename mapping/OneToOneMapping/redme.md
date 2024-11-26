```
CREATE TABLE `kodnestdb`.`address` (
  `addr_id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  PRIMARY KEY (`addr_id`));
```
```
CREATE TABLE `kodnestdb`.`students` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `addr_id` INT NULL,
	FOREIGN KEY (addr_id) REFERENCES address (addr_id), 
  PRIMARY KEY (`id`));
```
