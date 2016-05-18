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
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Customer` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `user_name` VARCHAR(10) NOT NULL COMMENT '',
  `title` VARCHAR(10) NOT NULL COMMENT '',
  `first_name` VARCHAR(50) NOT NULL COMMENT '',
  `last_name` VARCHAR(50) NOT NULL COMMENT '',
  `password` VARCHAR(45) NOT NULL COMMENT '',
  `date_of_birth` DATE NOT NULL COMMENT '',
  `gender` TINYINT(1) NULL COMMENT '',
  `credit` DECIMAL(7,2) NOT NULL COMMENT '',
  `email` VARCHAR(100) NULL COMMENT '',
  `contact_no` VARCHAR(11) NULL COMMENT '',
  `status` VARCHAR(20) NOT NULL COMMENT '',
  `secret_question` VARCHAR(225) NOT NULL COMMENT '',
  `secret_answer` VARCHAR(50) NOT NULL COMMENT '',
  `Address_line_1` VARCHAR(45) NOT NULL COMMENT '',
  `Address_postcode` VARCHAR(8) NOT NULL COMMENT '',
  PRIMARY KEY (`user_name`)  COMMENT '',
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT '')
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order` (
  `sales_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Customer_user_name` VARCHAR(10) NOT NULL COMMENT '',
  `Address_line_1` VARCHAR(45) NULL COMMENT '',
  `Address_postcode` VARCHAR(7) NULL COMMENT '',
  PRIMARY KEY (`sales_id`)  COMMENT '',
  INDEX `fk_Sales_Order_Customer1_idx` (`Customer_user_name` ASC)  COMMENT '',
  CONSTRAINT `fk_Sales_Order_Customer1`
    FOREIGN KEY (`Customer_user_name`)
    REFERENCES `mydb`.`Customer` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Event` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Event` (
  `sales_event_id` INT NOT NULL COMMENT '',
  `Sales_Order_sales_id` INT NOT NULL COMMENT '',
  `time_stamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `description` VARCHAR(225) NULL COMMENT '',
  `type` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`sales_event_id`)  COMMENT '',
  INDEX `fk_Sales_Event_Sales_Order1_idx` (`Sales_Order_sales_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Sales_Event_Sales_Order1`
    FOREIGN KEY (`Sales_Order_sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Stock` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Stock` (
  `catalogue_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `sale_price` DECIMAL(7,2) NOT NULL COMMENT '',
  `current_quantity` INT NOT NULL COMMENT '',
  `low_level_quantity` INT NOT NULL COMMENT '',
  `stock_status` VARCHAR(30) NOT NULL COMMENT '',
  `warehouse_location` VARCHAR(10) NOT NULL COMMENT '',
  PRIMARY KEY (`catalogue_id`)  COMMENT '')
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Line` (
  `Sales_Order_sales_id1` INT NOT NULL COMMENT '',
  `Stock_catalogue_id` INT NOT NULL COMMENT '',
  `sales_quantity` INT NOT NULL COMMENT '',
  `unit_price` DECIMAL(7,2) NOT NULL COMMENT '',
  PRIMARY KEY (`Sales_Order_sales_id1`, `Stock_catalogue_id`)  COMMENT '',
  INDEX `fk_Sales_Order_Line_Sales_Order1_idx` (`Sales_Order_sales_id1` ASC)  COMMENT '',
  INDEX `fk_Sales_Order_Line_Stock1_idx` (`Stock_catalogue_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Sales_Order_Line_Sales_Order1`
    FOREIGN KEY (`Sales_Order_sales_id1`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Order_Line_Stock1`
    FOREIGN KEY (`Stock_catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Payment_Details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Payment_Details` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Payment_Details` (
  `Customer_user_name` VARCHAR(10) NOT NULL COMMENT '',
  `card_number` VARCHAR(16) NOT NULL COMMENT '',
  `name_on_card` VARCHAR(45) NULL COMMENT '',
  `card_type` VARCHAR(45) NULL COMMENT '',
  `exp_date` DATE NULL COMMENT '',
  `start_date` DATE NULL COMMENT '',
  `Address_line_1` VARCHAR(45) NULL COMMENT '',
  `Address_post_code` VARCHAR(7) NULL COMMENT '',
  PRIMARY KEY (`Customer_user_name`, `card_number`)  COMMENT '',
  INDEX `fk_Payment_Details_Customer2_idx` (`Customer_user_name` ASC)  COMMENT '',
  CONSTRAINT `fk_Payment_Details_Customer2`
    FOREIGN KEY (`Customer_user_name`)
    REFERENCES `mydb`.`Customer` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Transaction` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Transaction` (
  `transaction_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Sales_Order_sales_id` INT NOT NULL COMMENT '',
  `Payment_Details_name_on_card` VARCHAR(45) NOT NULL COMMENT '',
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `amount` FLOAT NOT NULL COMMENT '',
  `Payment_Details_Customer_user_name` VARCHAR(10) NOT NULL COMMENT '',
  `Payment_Details_card_number` VARCHAR(16) NOT NULL COMMENT '',
  PRIMARY KEY (`transaction_id`)  COMMENT '',
  INDEX `fk_Transaction_Sales_Order1_idx` (`Sales_Order_sales_id` ASC)  COMMENT '',
  INDEX `fk_Transaction_Payment_Details1_idx` (`Payment_Details_Customer_user_name` ASC, `Payment_Details_card_number` ASC)  COMMENT '',
  CONSTRAINT `fk_Transaction_Sales_Order1`
    FOREIGN KEY (`Sales_Order_sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_Payment_Details1`
    FOREIGN KEY (`Payment_Details_Customer_user_name` , `Payment_Details_card_number`)
    REFERENCES `mydb`.`Payment_Details` (`Customer_user_name` , `card_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Supplier` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Supplier` (
  `supplier_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `contact_no` VARCHAR(13) NOT NULL COMMENT '',
  `email` VARCHAR(100) NULL COMMENT '',
  `Address_line_1` VARCHAR(45) NOT NULL COMMENT '',
  `Address_postcode` VARCHAR(7) NOT NULL COMMENT '',
  PRIMARY KEY (`supplier_id`)  COMMENT '',
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order` (
  `purchase_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Supplier_supplier_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`purchase_id`)  COMMENT '',
  INDEX `fk_Purchase_Order_Supplier1_idx` (`Supplier_supplier_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Purchase_Order_Supplier1`
    FOREIGN KEY (`Supplier_supplier_id`)
    REFERENCES `mydb`.`Supplier` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Line` (
  `Purchase_Order_purchase_id` INT NOT NULL COMMENT '',
  `Stock_catalogue_id` INT NOT NULL COMMENT '',
  `purchase_quantity` INT NOT NULL COMMENT '',
  `purchase_unit_price` DECIMAL(7,2) NOT NULL COMMENT '',
  PRIMARY KEY (`Purchase_Order_purchase_id`, `Stock_catalogue_id`)  COMMENT '',
  INDEX `fk_Purchase_Order_Line_Purchase_Order1_idx` (`Purchase_Order_purchase_id` ASC)  COMMENT '',
  INDEX `fk_Purchase_Order_Line_Stock1_idx` (`Stock_catalogue_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Purchase_Order_Line_Purchase_Order1`
    FOREIGN KEY (`Purchase_Order_purchase_id`)
    REFERENCES `mydb`.`Purchase_Order` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Purchase_Order_Line_Stock1`
    FOREIGN KEY (`Stock_catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Event` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Event` (
  `purchase_event_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Purchase_Order_purchase_id` INT NOT NULL COMMENT '',
  `time_stamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `description` VARCHAR(225) NULL COMMENT '',
  `type` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`purchase_event_id`)  COMMENT '',
  CONSTRAINT `fk_Purchase_Order_Event_Purchase_Order1`
    FOREIGN KEY (`Purchase_Order_purchase_id`)
    REFERENCES `mydb`.`Purchase_Order` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Return`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Return` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Return` (
  `Sales_Order_sales_id` INT NOT NULL COMMENT '',
  `date` DATE NOT NULL COMMENT '',
  `reason` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`Sales_Order_sales_id`)  COMMENT '',
  CONSTRAINT `fk_Sales_Order_Return_Sales_Order1`
    FOREIGN KEY (`Sales_Order_sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sales_Order_Return_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sales_Order_Return_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sales_Order_Return_Line` (
  `Stock_catalogue_id` INT NOT NULL COMMENT '',
  `Sales_Order_Return_Sales_Order_sales_id` INT NOT NULL COMMENT '',
  `return_quantity` INT NOT NULL COMMENT '',
  `shelved_quantity` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Stock_catalogue_id`, `Sales_Order_Return_Sales_Order_sales_id`)  COMMENT '',
  INDEX `fk_Sales_Order_Return_Line_Stock1_idx` (`Stock_catalogue_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Sales_Order_Return_Line_Sales_Order_Return1`
    FOREIGN KEY (`Sales_Order_Return_Sales_Order_sales_id`)
    REFERENCES `mydb`.`Sales_Order_Return` (`Sales_Order_sales_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Order_Return_Line_Stock1`
    FOREIGN KEY (`Stock_catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Return`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Return` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Return` (
  `Purchase_Order_purchase_id` INT NOT NULL COMMENT '',
  `date` DATE NOT NULL COMMENT '',
  `reason` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`Purchase_Order_purchase_id`)  COMMENT '',
  CONSTRAINT `fk_Purchase_Order_Return_Purchase_Order1`
    FOREIGN KEY (`Purchase_Order_purchase_id`)
    REFERENCES `mydb`.`Purchase_Order` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_Order_Return_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_Order_Return_Line` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_Order_Return_Line` (
  `Purchase_Order_Return_Purchase_Order_purchase_id` INT NOT NULL COMMENT '',
  `Stock_catalogue_id` INT NOT NULL COMMENT '',
  `return_quantity` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Purchase_Order_Return_Purchase_Order_purchase_id`, `Stock_catalogue_id`)  COMMENT '',
  INDEX `fk_Purchase_Order_Return_Line_Stock1_idx` (`Stock_catalogue_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Purchase_Order_Return_Line_Purchase_Order_Return1`
    FOREIGN KEY (`Purchase_Order_Return_Purchase_Order_purchase_id`)
    REFERENCES `mydb`.`Purchase_Order_Return` (`Purchase_Order_purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Purchase_Order_Return_Line_Stock1`
    FOREIGN KEY (`Stock_catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Wishlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Wishlist` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Wishlist` (
  `Customer_user_name` VARCHAR(10) NOT NULL COMMENT '',
  `Stock_catalogue_id` INT NOT NULL COMMENT '',
  `wish_quantity` INT NULL COMMENT '',
  PRIMARY KEY (`Customer_user_name`, `Stock_catalogue_id`)  COMMENT '',
  INDEX `fk_Wishlist_Customer2_idx` (`Customer_user_name` ASC)  COMMENT '',
  INDEX `fk_Wishlist_Stock2_idx` (`Stock_catalogue_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Wishlist_Customer2`
    FOREIGN KEY (`Customer_user_name`)
    REFERENCES `mydb`.`Customer` (`user_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Wishlist_Stock2`
    FOREIGN KEY (`Stock_catalogue_id`)
    REFERENCES `mydb`.`Stock` (`catalogue_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
