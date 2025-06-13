-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pixup
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pixup` ;

-- -----------------------------------------------------
-- Schema pixup
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pixup` DEFAULT CHARACTER SET utf8mb3 ;
SHOW WARNINGS;
USE `pixup` ;

-- -----------------------------------------------------
-- Table `pixup`.`tab_artista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixup`.`tab_artista` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tab_disquera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixup`.`tab_disquera` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tab_genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixup`.`tab_genero` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tab_disco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixup`.`tab_disco` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TITULO` VARCHAR(45) NOT NULL,
  `PRECIO` DOUBLE NOT NULL,
  `EXISTENCIA` INT NOT NULL,
  `DESCUENTO` FLOAT NOT NULL,
  `FECHA` VARCHAR(45) NOT NULL,
  `IMAGEN` VARCHAR(45) NOT NULL,
  `TAB_GENERO_ID` INT NOT NULL,
  `TAB_DISQUERA_ID` INT NOT NULL,
  `TAB_ARTISTA_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TAB_DISCO_TAB_GENERO_idx` (`TAB_GENERO_ID` ASC) VISIBLE,
  INDEX `fk_TAB_DISCO_TAB_DISQUERA1_idx` (`TAB_DISQUERA_ID` ASC) VISIBLE,
  INDEX `fk_TAB_DISCO_TAB_ARTISTA1_idx` (`TAB_ARTISTA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_TAB_DISCO_TAB_ARTISTA1`
    FOREIGN KEY (`TAB_ARTISTA_ID`)
    REFERENCES `pixup`.`tab_artista` (`ID`),
  CONSTRAINT `fk_TAB_DISCO_TAB_DISQUERA1`
    FOREIGN KEY (`TAB_DISQUERA_ID`)
    REFERENCES `pixup`.`tab_disquera` (`ID`),
  CONSTRAINT `fk_TAB_DISCO_TAB_GENERO`
    FOREIGN KEY (`TAB_GENERO_ID`)
    REFERENCES `pixup`.`tab_genero` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tab_cancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pixup`.`tab_cancion` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TITULO` VARCHAR(100) NOT NULL,
  `DURACION` VARCHAR(45) NOT NULL,
  `TAB_DISCO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TAB_CANCION_TAB_DISCO1_idx` (`TAB_DISCO_ID` ASC) VISIBLE,
  CONSTRAINT `fk_TAB_CANCION_TAB_DISCO1`
    FOREIGN KEY (`TAB_DISCO_ID`)
    REFERENCES `pixup`.`tab_disco` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
