-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Customer` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `user_name` VARCHAR(10) NOT NULL,
  `title` VARCHAR(10) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` TINYINT(1) NULL,
  `credit` DECIMAL(7,2) NOT NULL,
  `email` VARCHAR(100) NULL,
  `contact_no` VARCHAR(11) NULL,
  `status` VARCHAR(20) NOT NULL,
  `secret_question` VARCHAR(225) NOT NULL,
  `secret_answer` VARCHAR(50) NOT NULL,
  `Address_line_1` VARCHAR(45) NOT NULL,
  `Address_postcode` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`user_name`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order` (
  `sales_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(10) NOT NULL,
  `Address_line_1` VARCHAR(45) NULL,
  `Address_postcode` VARCHAR(8) NULL,
  PRIMARY KEY (`sales_id`),
  INDEX `fk_Sales_Order_Customer1_idx` (`user_name` ASC),
  CONSTRAINT `fk_Sales_Order_Customer1`
    FOREIGN KEY (`user_name`)
    REFERENCES `mydb`.`Customer` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Event` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Event` (
  `sales_event_id` INT NOT NULL,
  `sales_id` INT NOT NULL,
  `time_stamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` VARCHAR(225) NULL,
  `type` VARCHAR(20) NOT NULL,
  `Employee_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sales_event_id`),
  INDEX `fk_Sales_Event_Sales_Order1_idx` (`sales_id` ASC),
  CONSTRAINT `fk_Sales_Event_Sales_Order1`
    FOREIGN KEY (`sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Supplier` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Supplier` (
  `supplier_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `contact_no` VARCHAR(13) NOT NULL,
  `email` VARCHAR(100) NULL,
  `Address_line_1` VARCHAR(45) NOT NULL,
  `Address_postcode` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`supplier_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Stock` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Stock` (
  `catalogue_id` INT NOT NULL AUTO_INCREMENT,
  `sale_price` DECIMAL(7,2) NOT NULL,
  `current_quantity` INT NOT NULL,
  `reorder_level` INT NOT NULL,
  `reorder_quantity` INT NOT NULL,
  `stock_status` VARCHAR(30) NOT NULL,
  `warehouse_location` VARCHAR(10) NOT NULL,
  `supplier_id` INT NOT NULL,
  PRIMARY KEY (`catalogue_id`),
  INDEX `fk_Stock_Supplier1_idx` (`supplier_id` ASC),
  CONSTRAINT `fk_Stock_Supplier1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `mydb`.`Supplier` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Line` (
  `sales_id` INT NOT NULL,
  `catalogue_id` INT NOT NULL,
  `sales_quantity` INT NOT NULL,
  `unit_price` DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (`sales_id`, `catalogue_id`),
  INDEX `fk_Sales_Order_Line_Sales_Order1_idx` (`sales_id` ASC),
  INDEX `fk_Sales_Order_Line_Stock1_idx` (`catalogue_id` ASC),
  CONSTRAINT `fk_Sales_Order_Line_Sales_Order1`
    FOREIGN KEY (`sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Order_Line_Stock1`
    FOREIGN KEY (`catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Payment_Details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Payment_Details` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Payment_Details` (
  `user_name` VARCHAR(10) NOT NULL,
  `card_number` VARCHAR(16) NOT NULL,
  `name_on_card` VARCHAR(45) NULL,
  `card_type` VARCHAR(45) NULL,
  `exp_date` DATE NULL,
  `start_date` DATE NULL,
  `Address_line_1` VARCHAR(45) NULL,
  `Address_postcode` VARCHAR(8) NULL,
  PRIMARY KEY (`user_name`, `card_number`),
  INDEX `fk_Payment_Details_Customer2_idx` (`user_name` ASC),
  CONSTRAINT `fk_Payment_Details_Customer2`
    FOREIGN KEY (`user_name`)
    REFERENCES `mydb`.`Customer` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Transaction` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Transaction` (
  `transaction_id` INT NOT NULL AUTO_INCREMENT,
  `sales_id` INT NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` FLOAT NOT NULL,
  `user_name` VARCHAR(10) NOT NULL,
  `card_number` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  INDEX `fk_Transaction_Sales_Order1_idx` (`sales_id` ASC),
  INDEX `fk_Transaction_Payment_Details1_idx` (`user_name` ASC, `card_number` ASC),
  CONSTRAINT `fk_Transaction_Sales_Order1`
    FOREIGN KEY (`sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_Payment_Details1`
    FOREIGN KEY (`user_name` , `card_number`)
    REFERENCES `mydb`.`Payment_Details` (`user_name` , `card_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order` (
  `purchase_id` INT NOT NULL AUTO_INCREMENT,
  `supplier_id` INT NOT NULL,
  PRIMARY KEY (`purchase_id`),
  INDEX `fk_Purchase_Order_Supplier1_idx` (`supplier_id` ASC),
  CONSTRAINT `fk_Purchase_Order_Supplier1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `mydb`.`Supplier` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Line` (
  `purchase_id` INT NOT NULL,
  `catalogue_id` INT NOT NULL,
  `purchase_quantity` INT NOT NULL,
  `purchase_unit_price` DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (`purchase_id`, `catalogue_id`),
  INDEX `fk_Purchase_Order_Line_Purchase_Order1_idx` (`purchase_id` ASC),
  INDEX `fk_Purchase_Order_Line_Stock1_idx` (`catalogue_id` ASC),
  CONSTRAINT `fk_Purchase_Order_Line_Purchase_Order1`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `mydb`.`Purchase_Order` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Purchase_Order_Line_Stock1`
    FOREIGN KEY (`catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Event` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Event` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `purchase_id` INT NOT NULL,
  `time_stamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` VARCHAR(225) NULL,
  `type` VARCHAR(20) NOT NULL,
  `Employee_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`event_id`),
  CONSTRAINT `fk_Purchase_Order_Event_Purchase_Order1`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `mydb`.`Purchase_Order` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Return`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Return` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Return` (
  `sales_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `reason` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`sales_id`),
  CONSTRAINT `fk_Sales_Order_Return_Sales_Order1`
    FOREIGN KEY (`sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Return_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Return_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Return_Line` (
  `catalogue_id` INT NOT NULL,
  `sales_id` INT NOT NULL,
  `return_quantity` INT NOT NULL,
  `shelved_quantity` INT NOT NULL,
  PRIMARY KEY (`catalogue_id`, `sales_id`),
  INDEX `fk_Sales_Order_Return_Line_Stock1_idx` (`catalogue_id` ASC),
  CONSTRAINT `fk_Sales_Order_Return_Line_Sales_Order_Return1`
    FOREIGN KEY (`sales_id`)
    REFERENCES `mydb`.`Sales_Order_Return` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Order_Return_Line_Stock1`
    FOREIGN KEY (`catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Return`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Return` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Return` (
  `purchase_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `reason` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`purchase_id`),
  CONSTRAINT `fk_Purchase_Order_Return_Purchase_Order1`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `mydb`.`Purchase_Order` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Return_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Return_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Return_Line` (
  `purchase_id` INT NOT NULL,
  `catalogue_id` INT NOT NULL,
  `return_quantity` INT NOT NULL,
  PRIMARY KEY (`purchase_id`, `catalogue_id`),
  INDEX `fk_Purchase_Order_Return_Line_Stock1_idx` (`catalogue_id` ASC),
  CONSTRAINT `fk_Purchase_Order_Return_Line_Purchase_Order_Return1`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `mydb`.`Purchase_Order_Return` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Purchase_Order_Return_Line_Stock1`
    FOREIGN KEY (`catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Wishlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Wishlist` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Wishlist` (
  `user_name` VARCHAR(10) NOT NULL,
  `catalogue_id` INT NOT NULL,
  `wish_quantity` INT NULL,
  PRIMARY KEY (`user_name`, `catalogue_id`),
  INDEX `fk_Wishlist_Customer2_idx` (`user_name` ASC),
  INDEX `fk_Wishlist_Stock2_idx` (`catalogue_id` ASC),
  CONSTRAINT `fk_Wishlist_Customer2`
    FOREIGN KEY (`user_name`)
    REFERENCES `mydb`.`Customer` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Wishlist_Stock2`
    FOREIGN KEY (`catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
