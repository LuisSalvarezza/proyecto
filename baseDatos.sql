-- MySQL Script generated by MySQL Workbench
-- Fri Mar  1 09:49:23 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdatos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdatos` ;

-- -----------------------------------------------------
-- Schema bdatos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdatos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bdatos` ;

-- -----------------------------------------------------
-- Table `bdatos`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdatos`.`categoria` ;

CREATE TABLE IF NOT EXISTS `bdatos`.`categoria` (
  `idCategoria` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdatos`.`escuela`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdatos`.`escuela` ;

CREATE TABLE IF NOT EXISTS `bdatos`.`escuela` (
  `idEscuela` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idEscuela`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdatos`.`aspirante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdatos`.`aspirante` ;

CREATE TABLE IF NOT EXISTS `bdatos`.`aspirante` (
  `idAspirante` INT(11) NOT NULL AUTO_INCREMENT,
  `idEscuela` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(70) NOT NULL,
  `edad` VARCHAR(10) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `direccion` VARCHAR(120) NULL DEFAULT NULL,
  `dni` INT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`idAspirante`),
  INDEX `id_idx` (`idEscuela` ASC) VISIBLE,
  INDEX `fk_categoria_idx` (`idCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_categoria`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `bdatos`.`categoria` (`idCategoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_escuela`
    FOREIGN KEY (`idEscuela`)
    REFERENCES `bdatos`.`escuela` (`idEscuela`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdatos`.`competencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdatos`.`competencia` ;

CREATE TABLE IF NOT EXISTS `bdatos`.`competencia` (
  `idcompetencia` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idcompetencia`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bdatos`.`inscripcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdatos`.`inscripcion` ;

CREATE TABLE IF NOT EXISTS `bdatos`.`inscripcion` (
  `idaspirante` INT(11) NOT NULL,
  `idcompetencia` INT(11) NOT NULL,
  `fechaInscripcion` DATE NOT NULL,
  `estado` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idaspirante`, `idcompetencia`),
  INDEX `fk_competencia_idx` (`idcompetencia` ASC) VISIBLE,
  CONSTRAINT `fk_aspirante`
    FOREIGN KEY (`idaspirante`)
    REFERENCES `bdatos`.`aspirante` (`idAspirante`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_competencia`
    FOREIGN KEY (`idcompetencia`)
    REFERENCES `bdatos`.`competencia` (`idcompetencia`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;