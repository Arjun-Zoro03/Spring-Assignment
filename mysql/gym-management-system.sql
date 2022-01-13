-- MySQL Workbench Forward Engineering--

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gym_management_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gym_management_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gym_management_system` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema pet_clinic_db
-- -----------------------------------------------------
USE `gym_management_system` ;

-- -----------------------------------------------------
-- Table `gym_management_system`.`trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym_management_system`.`trainer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `age` INT NOT NULL,
  `gender` VARCHAR(1) NOT NULL,
  `phone_number` CHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gym_management_system`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym_management_system`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `age` INT(3) NOT NULL,
  `gender` VARCHAR(1) NOT NULL,
  `phone_number` CHAR(10) NOT NULL,
  `start_date` CHAR(10) NOT NULL,
  `end_date` CHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gym_management_system`.`workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym_management_system`.`workout` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `muscle_worked` VARCHAR(45) NOT NULL,
  `trainer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_workout_trainer1_idx` (`trainer_id` ASC) VISIBLE,
  CONSTRAINT `fk_workout_trainer1`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `gym_management_system`.`trainer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gym_management_system`.`biceep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym_management_system`.`biceep` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exercise` VARCHAR(45) NOT NULL,
  `sets` INT(2) NOT NULL,
  `reps` INT(3) NOT NULL,
  `workout_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_biceep_workout1_idx` (`workout_id` ASC) VISIBLE,
  CONSTRAINT `fk_biceep_workout1`
    FOREIGN KEY (`workout_id`)
    REFERENCES `gym_management_system`.`workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gym_management_system`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym_management_system`.`users` (
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `enabled` TINYINT(1) NOT NULL,
  `customer_id` INT NULL,
  `trainer_id` INT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_users_customer1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_users_trainer1_idx` (`trainer_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `gym_management_system`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_trainer1`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `gym_management_system`.`trainer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gym_management_system`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym_management_system`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(45) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_authorities_users1_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_authorities_users1`
    FOREIGN KEY (`username`)
    REFERENCES `gym_management_system`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gym_management_system`.`trainer_has_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym_management_system`.`trainer_has_customer` (
  `trainer_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`trainer_id`, `customer_id`),
  INDEX `fk_trainer_has_customer_customer1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_trainer_has_customer_trainer1_idx` (`trainer_id` ASC) VISIBLE,
  CONSTRAINT `fk_trainer_has_customer_trainer1`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `gym_management_system`.`trainer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trainer_has_customer_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `gym_management_system`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
