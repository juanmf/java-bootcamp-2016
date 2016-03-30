-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bootcampshoppingcart
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bootcampshoppingcart
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bootcampshoppingcart` DEFAULT CHARACTER SET latin1 ;
USE `bootcampshoppingcart` ;

-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `idproduct` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_category_1_idx` (`idproduct` ASC),
  CONSTRAINT `fk_category_1`
    FOREIGN KEY (`idproduct`)
    REFERENCES `bootcampshoppingcart`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `productname` VARCHAR(45) NULL DEFAULT NULL,
  `idcategory` INT(11) NULL DEFAULT NULL,
  `productdescription` VARCHAR(45) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_product_1_idx` (`idcategory` ASC),
  CONSTRAINT `fk_product_1`
    FOREIGN KEY (`idcategory`)
    REFERENCES `bootcampshoppingcart`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`purchase_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`purchase_product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idproduct` INT(11) NULL DEFAULT NULL,
  `idpurchase` INT(11) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_purchase_product_1_idx` (`idproduct` ASC),
  INDEX `fk_purchase_product_2_idx` (`idpurchase` ASC),
  CONSTRAINT `fk_purchase_product_1`
    FOREIGN KEY (`idproduct`)
    REFERENCES `bootcampshoppingcart`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_product_2`
    FOREIGN KEY (`idpurchase`)
    REFERENCES `bootcampshoppingcart`.`purchase` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`purchase` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `iduser` INT(11) NULL DEFAULT NULL,
  `idpurchasedproducts` INT(11) NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_purchase_1_idx` (`iduser` ASC),
  INDEX `fk_purchase_2_idx` (`idpurchasedproducts` ASC),
  CONSTRAINT `fk_purchase_1`
    FOREIGN KEY (`iduser`)
    REFERENCES `bootcampshoppingcart`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_2`
    FOREIGN KEY (`idpurchasedproducts`)
    REFERENCES `bootcampshoppingcart`.`purchase_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `mail` VARCHAR(45) NULL DEFAULT NULL,
  `idpurchase` INT(11) NULL DEFAULT NULL,
  `idcart` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_user_1_idx` (`idcart` ASC),
  INDEX `fk_user_2_idx` (`idpurchase` ASC),
  CONSTRAINT `fk_user_1`
    FOREIGN KEY (`idcart`)
    REFERENCES `bootcampshoppingcart`.`cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_2`
    FOREIGN KEY (`idpurchase`)
    REFERENCES `bootcampshoppingcart`.`purchase` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idproduct` INT(11) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `idcart` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_order_1_idx` (`idproduct` ASC),
  INDEX `fk_order_2_idx` (`idcart` ASC),
  CONSTRAINT `fk_order_1`
    FOREIGN KEY (`idproduct`)
    REFERENCES `bootcampshoppingcart`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_2`
    FOREIGN KEY (`idcart`)
    REFERENCES `bootcampshoppingcart`.`cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`cart_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`cart_product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idproduct` INT(11) NULL DEFAULT NULL,
  `idcart` INT(11) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `idorder` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_cart_product_1_idx` (`idproduct` ASC),
  INDEX `fk_product_idx` (`idproduct` ASC),
  INDEX `fk_order_idx` (`idorder` ASC),
  CONSTRAINT `fk_order`
    FOREIGN KEY (`idorder`)
    REFERENCES `bootcampshoppingcart`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product`
    FOREIGN KEY (`idproduct`)
    REFERENCES `bootcampshoppingcart`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bootcampshoppingcart`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bootcampshoppingcart`.`cart` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `iduser` INT(11) NULL DEFAULT NULL,
  `idcartproduct` INT(11) NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_cart_1_idx` (`iduser` ASC),
  INDEX `fk_cart_2_idx` (`idcartproduct` ASC),
  CONSTRAINT `fk_cart_1`
    FOREIGN KEY (`iduser`)
    REFERENCES `bootcampshoppingcart`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_2`
    FOREIGN KEY (`idcartproduct`)
    REFERENCES `bootcampshoppingcart`.`cart_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
