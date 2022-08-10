-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cloud_project_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cloud_project_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cloud_project_db` DEFAULT CHARACTER SET utf8 ;
USE `cloud_project_db` ;

-- -----------------------------------------------------
-- Table `cloud_project_db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`roles` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `active_status` VARCHAR(5) NOT NULL,
  `roles_id` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  INDEX `avtive_status_index` (`active_status` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `cloud_project_db`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`furnishing_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`furnishing_status` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`accommodations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`accommodations` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `bedroom_count` TINYINT(1) UNSIGNED NOT NULL,
  `bathroom_count` TINYINT(1) UNSIGNED NOT NULL,
  `vacancy_count` TINYINT(1) UNSIGNED NOT NULL,
  `rent_per_occupant` DOUBLE NOT NULL,
  `lease_start_date` DATE NOT NULL,
  `lease_end_date` DATE NOT NULL,
  `move_in_date` DATE NOT NULL,
  `distance_from_campus` DOUBLE NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `users_id` INT UNSIGNED NOT NULL,
  `furnishing_status_id` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accomodations_users1_idx` (`users_id` ASC),
  INDEX `fk_accomodations_furnishing_status1_idx` (`furnishing_status_id` ASC),
  INDEX `bedroom_index` (`bedroom_count` ASC),
  INDEX `bathroom_index` (`bathroom_count` ASC),
  INDEX `rent_index` (`rent_per_occupant` ASC),
  INDEX `lease_start_index` (`lease_start_date` ASC),
  INDEX `lease_end_index` (`lease_end_date` ASC),
  INDEX `distance_from_campus_index` (`distance_from_campus` ASC),
  INDEX `name_index` (`name` ASC),
  INDEX `vacancy_index` (`vacancy_count` ASC),
  CONSTRAINT `fk_accomodations_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `cloud_project_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_accomodations_furnishing_status1`
    FOREIGN KEY (`furnishing_status_id`)
    REFERENCES `cloud_project_db`.`furnishing_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`chats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`chats` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `sender_id` INT UNSIGNED NOT NULL,
  `receiver_id` INT UNSIGNED NOT NULL,
  `message` VARCHAR(255) NOT NULL,
  `message_timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_users_has_users_users2_idx` (`receiver_id` ASC),
  INDEX `fk_users_has_users_users1_idx` (`sender_id` ASC),
  CONSTRAINT `fk_users_has_users_users1`
    FOREIGN KEY (`sender_id`)
    REFERENCES `cloud_project_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_users_users2`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `cloud_project_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`accommodation_names`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`accommodation_names` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`genders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`genders` (
  `id` TINYINT(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`food_preferences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`food_preferences` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`degree_level`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`degree_level` (
  `id` TINYINT(1) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cloud_project_db`.`occupants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cloud_project_db`.`occupants` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `rent_minimum` DOUBLE NOT NULL,
  `rent_maximum` DOUBLE NOT NULL,
  `lease_start_date` DATE NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `gender_id` TINYINT(2) UNSIGNED NOT NULL,
  `food_preference_id` INT UNSIGNED NOT NULL,
  `degree_level_id` TINYINT(1) UNSIGNED NOT NULL,
  `users_id` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_occupants_genders1_idx` (`gender_id` ASC),
  INDEX `fk_occupants_food_preferences1_idx` (`food_preference_id` ASC),
  INDEX `fk_occupants_degree_level1_idx` (`degree_level_id` ASC),
  INDEX `fk_occupants_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_occupants_genders1`
    FOREIGN KEY (`gender_id`)
    REFERENCES `cloud_project_db`.`genders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_occupants_food_preferences1`
    FOREIGN KEY (`food_preference_id`)
    REFERENCES `cloud_project_db`.`food_preferences` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_occupants_degree_level1`
    FOREIGN KEY (`degree_level_id`)
    REFERENCES `cloud_project_db`.`degree_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_occupants_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `cloud_project_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
