DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

DROP TABLE IF EXISTS brands;
CREATE TABLE `brands` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

DROP TABLE IF EXISTS parts;
CREATE TABLE `parts` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `brandId` INT NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `price` BIGINT NOT NULL,
  `realiseDate` DATE NULL,
  `partCondition` VARCHAR(45) NOT NULL,
  `partDescription` VARCHAR(500) NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `brandId_idx` (`brandId` ASC) VISIBLE,
  CONSTRAINT `brandId`
    FOREIGN KEY (`brandId`)
    REFERENCES `infodb`.`brands` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

DROP TABLE IF EXISTS orders;
CREATE TABLE `orders` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `orderTime` DATETIME NOT NULL,
  `deliveryDate` DATETIME NULL,
  `totalCost` BIGINT NOT NULL,
  `customerId` INT NOT NULL,
  `orderCondition` VARCHAR(45) NOT NULL,
  `dateOfCompletion` DATETIME NULL,
  `note` VARCHAR(200) NULL,
  `deliveryCondition` VARCHAR(45) NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `customerId_idx` (`customerId` ASC) VISIBLE,
  CONSTRAINT `customerId`
    FOREIGN KEY (`customerId`)
    REFERENCES `infodb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

DROP TABLE IF EXISTS photos;
CREATE TABLE `photos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `imageUrl` VARCHAR(250) NOT NULL,
  `comment` VARCHAR(250) NULL,
  `dateOfDownload` DATETIME NOT NULL,
  `partId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `partId_idx` (`partId` ASC) VISIBLE,
  CONSTRAINT `partId`
    FOREIGN KEY (`partId`)
    REFERENCES `infodb`.`parts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

DROP TABLE IF EXISTS order_items;
  CREATE TABLE `order_items` (
  `partId` INT NOT NULL,
  `orderId` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`partId`,`orderId`),
  INDEX `partId_idx` (`partId` ASC) VISIBLE,
  INDEX `orderId_idx` (`orderId` ASC) VISIBLE,
  CONSTRAINT `partId_FK`
    FOREIGN KEY (`partId`)
    REFERENCES `infodb`.`parts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderId_FK`
    FOREIGN KEY (`orderId`)
    REFERENCES `infodb`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);