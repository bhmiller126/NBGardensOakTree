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
  `Address_postcode` VARCHAR(8) NULL COMMENT '',
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
  `Employee_username` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`sales_event_id`)  COMMENT '',
  INDEX `fk_Sales_Event_Sales_Order1_idx` (`Sales_Order_sales_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Sales_Event_Sales_Order1`
    FOREIGN KEY (`Sales_Order_sales_id`)
    REFERENCES `mydb`.`Sales_Order` (`sales_id`)
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
  `Address_postcode` VARCHAR(8) NOT NULL COMMENT '',
  PRIMARY KEY (`supplier_id`)  COMMENT '',
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Stock` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Stock` (
  `catalogue_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `sale_price` DECIMAL(7,2) NOT NULL COMMENT '',
  `current_quantity` INT NOT NULL COMMENT '',
  `reorder_level` INT NOT NULL COMMENT '',
  `reorder_quantity` INT NOT NULL COMMENT '',
  `stock_status` VARCHAR(30) NOT NULL COMMENT '',
  `warehouse_location` VARCHAR(10) NOT NULL COMMENT '',
  `Supplier_supplier_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`catalogue_id`)  COMMENT '',
  INDEX `fk_Stock_Supplier1_idx` (`Supplier_supplier_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Stock_Supplier1`
    FOREIGN KEY (`Supplier_supplier_id`)
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
  `Address_postcode` VARCHAR(8) NULL COMMENT '',
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
  `Employee_username` VARCHAR(45) NOT NULL COMMENT '',
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



INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('aclarke', 'Miss', 'Amy', 'Clarke', 'amy', '1993-04-27', '0', '7654.32', 'a.c@email.com', '345678', 'Archived', 'Mothers Maiden Name', 'Clarke', '8 Cecil Road', 'M9 6RP');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('aharris', 'Mr', 'Angus', 'Harris', 'angus', '1992-04-22', '1', '10000.00', 'a.h@email.com', '471917', 'Active', 'First Pets Name', 'Cow', '99 Everyway', 'PR1 1LL');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('bbaggins', 'Mr', 'Bilbo', 'Baggins', 'bilbo', '1903-01-01', '1', '7920.22', 'bilbo@hotmail.com', '678', 'Active', 'Mothers Maiden Name', 'Baggins', '68 Finch Road', 'GG16 8HL');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('bmiller', 'Miss', 'Bryony', 'Miller', 'bryony', '1991-10-15', '0', '100.00', 'b.m@email.com', '381803', 'Black', 'Favourite Place', 'Mushu', 'Castle 1', 'HG01 3DE');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('bstinch', 'Mr', 'Ben', 'Stinch', 'ben', '1991-03-03', '1', '0.00', 'b.s@email.com', 'NULL', 'Active', 'First Pets Name', 'Bob', '2 Seconday Street', 'JJ12 8FV');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('darmstrong', 'Mr', 'Daniel', 'Armstrong', 'daniel', '1990-01-01', '1', '0.00', 'd.a@email.com', '47294', 'Hold', 'First Pets Name', 'Your Mum', '88 Fatlady Road', 'WA14 5GG');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('eharris', 'Miss', 'Emma', 'Harris', 'emma', '1994-10-16', '0', '5555.55', 'e.h@hotmail.com', '7731', 'Active', 'First Pets Name', 'Jessica', '36 Teeside Way', 'PR1 1QR');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('fchristmas', 'Mr', 'Father', 'Christmas', 'father', '1972-12-25', '1', '10000.00', 'father.christmas@christmas.com', '5678', 'Active', 'Mothers Maiden Name', 'Claus', '27 Salmon Street', 'M9 7QH');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('lparker', 'Mr', 'Laurence', 'Parker', 'laurence', '1987-04-05', '1', '345.00', 'laprker@spiderman.co.uk', '800999', 'Hold', 'Mothers Maiden Name', 'Wilson', '3 Cecil Road ', 'M9 6RP');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('mleech', 'Mr', 'Mark', 'Leech', 'mark', '1998-02-02', '1', '12345.00', 'm.l@email.com', 'NULL', 'Active', 'Favourite Place', 'McDonalds', '8 Cecil Road', 'M9 6RP');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('rgibson', 'Mr', 'Robbie', 'Gibson', 'robbie', '1985-05-24', '1', '9999.99', 'r.g@email.com', '678', 'Black', 'First Car', 'Sled', 'Grotto', 'P0L3 5TR');
INSERT INTO `mydb`.`customer` (`user_name`, `title`, `first_name`, `last_name`, `password`, `date_of_birth`, `gender`, `credit`, `email`, `contact_no`, `status`, `secret_question`, `secret_answer`, `Address_line_1`, `Address_postcode`) VALUES ('sbartlett', 'Mr', 'Sam', 'Bartlett', 'sam', '1993-12-14', '1', '1234.00', 's.b@email.com', '14258284', 'Active', 'Favourite Phrase', 'GG', 'Touche House', 'GG16 8HL');


INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('1', 'Gnomes \'R\' Us', '01156 785 201', 'supplies@gnomesrus.co.uk', 'Unit 4402, Trafford Park', 'M445EG');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('2', 'Cornish Furniture', '01459 258 746', 'purchasing@cftables.com', 'Container 1, Ledwell Road', 'G698UJ');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('3', 'Screw Fix', '01785 236 259', 'enquiries@screwfix.co.uk', 'Building 6, New Found Street', 'BA347YH');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('4', 'MowMow', '01258 459 657', 'sale@lawnmowers.com', '95 Lawn road', 'JJ446HH');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('5', 'Plants and Things', '01547 859 630', 'suppliesandthat@plantsandthings.org', 'Unit 43, Crewe Business Park', 'A43GT');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('6', 'Garden Living and Lawns', '01111 859 654', 'buying@gardenthings.com', '83 Willow Pace', 'FF567HG');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('7', 'Celeb Gnomes', '01238 549 555', 'gnomesandgnomes@foryou.com', '1 Farnby Road', 'LL097YD');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('8', 'Exclusive Decor', '01548 555 489', 'bespokedecor@poshgardens.com', 'Building 28, Earlstree Industrial Estate', 'DD36DD');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('9', 'Custom Gnomes', '01161 154 889', 'sales@gnomeaccessories.co.uk', '99 High Road', 'TT19NB');
INSERT INTO `mydb`.`supplier` (`supplier_id`, `name`, `contact_no`, `email`, `Address_line_1`, `Address_postcode`) VALUES ('10', 'Pots and Plants and Pots', '01547 581 214', 'purchases@plantsnpotsnpotsnplants.co.uk', 'Room 3, Moldyhawk Lane', 'W356FB');


INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('fchristmas', '0000 0000 0001', 'Nicholas', 'American Express', '2222-12-12', '2013-05-01', '27 Salmon Street', 'M9 7QH');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('bmiller', '2548 2469 2548 ', 'Bryony', 'VISA', '2012-04-15', '2011-02-05', 'Castle 1', 'HG01 3DE');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('bmiller', '1542 5598 6589', 'Bryony', 'VISA', '2019-01-09', NULL, 'Castle 1', 'HG01 3DE');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('bbaggins', '6584 1547 1589', 'Bilbo Baggins', 'MasterCard', '2019-09-01', '2014-02-06', '68 Finch Road', 'GG16 8HL');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('aharris', '1165 2589 3564', 'Angus', 'VISA', '2016-04-26', '2014-01-01', '99 Everyway', 'PR1 1LL');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('darmstrong', '8895 8845 2156', 'D Armstrong', 'MasterCard', '2020-01-01', '2012-04-05', '88 Fatlady Road', 'WA14 5GG');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('bbaggins', '8495 1548 9852', 'Frodo Baggins', 'MasterCard', '2019-02-02', NULL, '68 Finch Road', 'GG16 8HL');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('sbartlett', '5478 5486 2365', 'S Bartlett', 'VISA', '2023-07-01', NULL, 'Touche House', 'GG16 8HL');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('mleech', '1245 0025 8596', 'Mark Leech', 'VISA', '2025-08-01', NULL, '8 Cecil Road', 'M9 6RP');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('aclarke', '5489 2154 6582', 'Mark Leech', 'VISA', '2024-01-09', NULL, '8 Cecil Road', 'M9 6RP');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('lparker', '0056 4582 8569', 'L Parker', 'American Express', '2020-06-01', NULL, '36 Teeside Way', 'PR1 1QR');
INSERT INTO `mydb`.`payment_details` (`Customer_user_name`, `card_number`, `name_on_card`, `card_type`, `exp_date`, `start_date`, `Address_line_1`, `Address_postcode`) VALUES ('aharris', '1258 4578 9856', 'E Harris', 'VISA', '2016-12-12', '2012-12-12', '99 Everyway', 'PR1 1LL');

INSERT INTO `mydb`.`sales_order` (`sales_id`, `Customer_user_name`, `Address_line_1`, `Address_postcode`) VALUES ('1', 'aharris', '99 Everyway', 'PR1 1LL');
INSERT INTO `mydb`.`sales_order` (`sales_id`, `Customer_user_name`, `Address_line_1`, `Address_postcode`) VALUES ('2', 'lparker', '36 Teeside Way', 'PR1 1QR');
INSERT INTO `mydb`.`sales_order` (`sales_id`, `Customer_user_name`, `Address_line_1`, `Address_postcode`) VALUES ('3', 'aharris', '99 Everyway', 'PR1 1LL');
INSERT INTO `mydb`.`sales_order` (`sales_id`, `Customer_user_name`, `Address_line_1`, `Address_postcode`) VALUES ('4', 'fchristmas', 'Grotto', 'NP1');
INSERT INTO `mydb`.`sales_order` (`sales_id`, `Customer_user_name`, `Address_line_1`, `Address_postcode`) VALUES ('5', 'lparker', 'Summer Grotto', 'SP1');
INSERT INTO `mydb`.`sales_order` (`sales_id`, `Customer_user_name`, `Address_line_1`, `Address_postcode`) VALUES ('6', 'bmiller', 'Castle 1', 'HG01 3DE');
INSERT INTO `mydb`.`sales_order` (`sales_id`, `Customer_user_name`, `Address_line_1`, `Address_postcode`) VALUES ('7', 'sbartlett', 'Touche House', 'GG16 8HL');

INSERT INTO `mydb`.`transaction` (`transaction_id`, `Sales_Order_sales_id`, `date`, `amount`, `Payment_Details_Customer_user_name`, `Payment_Details_card_number`) VALUES ('1', '1', '2016-04-14 10:00', '59.88', 'aharris', '1258 4578 9856');
INSERT INTO `mydb`.`transaction` (`transaction_id`, `Sales_Order_sales_id`, `date`, `amount`, `Payment_Details_Customer_user_name`, `Payment_Details_card_number`) VALUES ('2', '2', '2016-04-14 12:00', '3000', 'lparker', '0056 4582 8569');
INSERT INTO `mydb`.`transaction` (`transaction_id`, `Sales_Order_sales_id`, `date`, `amount`, `Payment_Details_Customer_user_name`, `Payment_Details_card_number`) VALUES ('3', '3', '2016-04-15 12:15', '699', 'aharris', '1165 2589 3564');
INSERT INTO `mydb`.`transaction` (`transaction_id`, `Sales_Order_sales_id`, `date`, `amount`, `Payment_Details_Customer_user_name`, `Payment_Details_card_number`) VALUES ('4', '4', '2016-04-18 09:10', '280', 'fchristmas', '0000 0000 0001');
INSERT INTO `mydb`.`transaction` (`transaction_id`, `Sales_Order_sales_id`, `date`, `amount`, `Payment_Details_Customer_user_name`, `Payment_Details_card_number`) VALUES ('5', '5', '2016-04-19 08:20', '9500', 'lparker', '0056 4582 8569');
INSERT INTO `mydb`.`transaction` (`transaction_id`, `Sales_Order_sales_id`, `date`, `amount`, `Payment_Details_Customer_user_name`, `Payment_Details_card_number`) VALUES ('6', '7', '2016-05-01 00:00', '1708.85', 'sbartlett', '5478 5486 2365');

INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('1', '75', '4', '5', '500', 'on order', 'G4', '8');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('2', '350', '58', '12', '75', 'in stock', 'A6', '8');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('3', '160', '6', '40', '1000', 'back order', 'E3', '1');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('4', '145', '3', '10', '400', 'on order', 'E3', '1');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('5', '38', '189', '20', '350', 'in stock', 'E4', '1');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('6', '85.99', '22', '12', '500', 'in stock', 'B1', '3');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('7', '3000', '15', '5', '60', 'in stock', 'B3', '2');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('8', '4.99', '86', '25', '5000', 'in stock', 'D3', '5');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('9', '9500', '12', '3', '25', 'in stock', 'D6', '4');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('10', '150.99', '5', '10', '0', 'discontinued', 'D7', '7');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('11', '899', '3', '5', '100', 'back order', 'A3', '3');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('12', '8000', '8', '4', '10', 'in stock', 'A4', '6');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('13', '135', '200', '15', '200', 'in stock', 'C2', '7');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('14', '35', '86', '10', '150', 'in stock', 'C6', '5');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('15', '1300', '15', '2', '30', 'on order', 'D3', '6');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('16', '85.99', '325', '50', '600', 'in stock', 'D3', '7');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('17', '98.84', '14', '6', '50', 'in stock', 'E1', '7');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('18', '125', '3', '25', '75', 'on order', 'E6', '7');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('19', '86', '4', '10', '80', 'on order', 'D3', '10');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('20', '13.86', '152', '25', '200', 'in stock', 'E2', '10');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('21', '45', '358', '100', '400', 'in stock', 'A4', '5');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('22', '55', '19', '20', '150', 'on order', 'B4', '7');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('23', '750', '14', '8', '20', 'in stock', 'B6', '2');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('24', '29.99', '86', '20', '100', 'in stock', 'E1', '8');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('25', '45', '300', '100', '1000', 'in stock', 'D3', '9');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('26', '185', '2000', '15', '2500', 'in stock', 'D2', '1');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('27', '358.65', '150', '6', '0', 'discontinued', 'A2', '3');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('28', '447.25', '428', '30', '450', 'in stock', 'F1', '2');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('29', '149.99', '12', '8', '50', 'in stock', 'F3', '9');
INSERT INTO `mydb`.`stock` (`catalogue_id`, `sale_price`, `current_quantity`, `reorder_level`, `reorder_quantity`, `stock_status`, `warehouse_location`, `Supplier_supplier_id`) VALUES ('30', '8.99', '436', '70', '800', 'in stock', 'F1', '5');

INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('1', '8', '12', '4.99');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('2', '7', '2', '3000');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('3', '16', '5', '85.99');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('3', '21', '1', '45');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('3', '1', '3', '75');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('4', '5', '5', '38');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('5', '9', '1', '9500');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('6', '2', '3', '350');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('6', '16', '2', '85.99');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('7', '13', '5', '135');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('7', '11', '1', '899');
INSERT INTO `mydb`.`sales_order_line` (`Sales_Order_sales_id1`, `Stock_catalogue_id`, `sales_quantity`, `unit_price`) VALUES ('7', '30', '15', '8.99');

INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('1', '1', '2016-04-14  10:00', 'Order Created', 'Create', ' bfinch');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('2', '1', '2016-04-14  12:00', 'Order Picked and Packed', 'Packed', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('3', '2', '2016-04-15  12:15', 'Order Created', 'Create', ' bfinch');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('4', '2', '2016-04-15  14:20', 'Order Picked and Packed', 'Packed', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('5', '2', '2016-04-16  09:10', 'Order Dispatched', 'Dispatch', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('6', '1', '2016-04-18  09:10', 'Order Dispatched', 'Dispatch', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('7', '3', '2016-04-19  08:20', 'Order Created', 'Create', ' delm');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('8', '4', '2016-04-25  16:00', 'Order Packed', 'Packed', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('9', '4', '2016-04-29  17:00', 'Order Dispatched', 'Dispatch', ' dcarr5');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('10', '5', '2016-05-01  00:00', 'Order Created', 'Create', ' jfinch');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('11', '1', '2016-05-01  00:00', 'Full Payment Received', 'Payment', ' bweaver8');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('12', '5', '2016-05-02  00:00', 'Order Dispatched', 'Dispatch', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('13', '2', '2016-05-03  12:04', 'Partial Payment Received', 'Payment', ' bweaver8');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('14', '6', '2016-05-04  10:30', 'Order Created', 'Create', ' jfinch');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('15', '6', '2016-05-04  15:24', 'Order Packed', 'Packed', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('16', '2', '2016-05-04  16:12', 'Return Received', 'Return', ' dcarr5');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('17', '6', '2016-05-04  16:30', 'Order Dispatched', 'Dispatch', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('18', '3', '2016-05-04  16:31', 'Order Packed', 'Packed', ' dcarr5');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('19', '3', '2016-05-04  16:32', 'Order Dispatched', 'Dispatch', ' dcarr5');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('20', '4', '2016-05-05  09:20', 'Full Payment received ', 'Payment', 'jwatson0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('21', '5', '2016-05-05  09:21', 'Full Payment received ', 'Payment', 'jwatson0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('22', '7', '2016-05-07  08:45', 'Order Created', 'Create', ' delm');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('23', '7', '2016-05-07  10:35', 'Order Packed', 'Packed', ' mhughes0');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('24', '3', '2016-05-08  00:00', 'Full Payment received ', 'Payment', 'eryan3');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('25', '6', '2016-05-09  15:10', 'Full Return', 'Return', ' bweaver8');
INSERT INTO `mydb`.`sales_order_event` (`sales_event_id`, `Sales_Order_sales_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('26', '7', '2016-05-10  10:00', 'Full Payment Received', 'Payment', 'jwatson0');


INSERT INTO `mydb`.`sales_order_return` (`Sales_Order_sales_id`, `date`, `reason`) VALUES ('2', '2016-05-04', 'Didnt mean to order 2');
INSERT INTO `mydb`.`sales_order_return` (`Sales_Order_sales_id`, `date`, `reason`) VALUES ('6', '2016-05-09', 'They dont fit in with the garden, they are too big');

INSERT INTO `mydb`.`sales_order_return_line` (`Stock_catalogue_id`, `Sales_Order_Return_Sales_Order_sales_id`, `return_quantity`, `shelved_quantity`) VALUES ('7', '2', '1', '1');
INSERT INTO `mydb`.`sales_order_return_line` (`Stock_catalogue_id`, `Sales_Order_Return_Sales_Order_sales_id`, `return_quantity`, `shelved_quantity`) VALUES ('2', '6', '3', '2');
INSERT INTO `mydb`.`sales_order_return_line` (`Stock_catalogue_id`, `Sales_Order_Return_Sales_Order_sales_id`, `return_quantity`, `shelved_quantity`) VALUES ('16', '6', '2', '2');

INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('1', '1');
INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('2', '1');
INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('3', '3');
INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('4', '6');
INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('5', '7');
INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('6', '10');
INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('7', '7');
INSERT INTO `mydb`.`purchase_order` (`purchase_id`, `Supplier_supplier_id`) VALUES ('8', '8');

INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('1', '3', '1000', '100');
INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('2', '4', '400', '120');
INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('3', '11', '100', '700');
INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('4', '15', '50', '1100');
INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('5', '18', '350', '100');
INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('6', '19', '1000', '75');
INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('7', '22', '70', '50');
INSERT INTO `mydb`.`purchase_order_line` (`Purchase_Order_purchase_id`, `Stock_catalogue_id`, `purchase_quantity`, `purchase_unit_price`) VALUES ('8', '1', '500', '45.86');

INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('1', '1', '2016-05-14  08:57', '', 'Despatched', ' astock');
INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('2', '2', '2016-05-15  08:57', 'due back in 01/07/16', 'Awaiting Delivery', ' astock');
INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('3', '3', '2016-04-15  18:28', 'due back in 05/06/16', 'Awaiting Delivery', ' astock');
INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('4', '4', '2016-05-01  15:48', '', 'Despatched', ' astock');
INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('5', '5', '2016-04-29  14:26', '', 'Order Confirmed', ' astock');
INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('6', '6', '2016-05-17  07:45', '', 'Picking/Packing', ' astock');
INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('7', '7', '2016-04-29  14:26', '', 'Payment Required', ' astock');
INSERT INTO `mydb`.`purchase_order_event` (`purchase_event_id`, `Purchase_Order_purchase_id`, `time_stamp`, `description`, `type`, `Employee_username`) VALUES ('8', '8', '2016-05-12  17:51', '', 'Received', ' astock');


INSERT INTO `mydb`.`purchase_order_return` (`Purchase_Order_purchase_id`, `date`, `reason`) VALUES ('7', '2016-05-15', 'wrong gnome sent');

INSERT INTO `mydb`.`purchase_order_return_line` (`Purchase_Order_Return_Purchase_Order_purchase_id`, `Stock_catalogue_id`, `return_quantity`) VALUES ('7', '22', '70');


INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('aharris', '3', '2');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('aharris', '9', '1');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('bmiller', '13', '1');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('mleech', '14', '1');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('fchristmas', '18', '1');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('bbaggins', '17', '5');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('bbaggins', '20', '3');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('lparker', '25', '9');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('sbartlett', '25', '12');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('darmstrong', '8', '3');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('fchristmas', '8', '10');
INSERT INTO `mydb`.`wishlist` (`Customer_user_name`, `Stock_catalogue_id`, `wish_quantity`) VALUES ('bstinch', '8', '1');


