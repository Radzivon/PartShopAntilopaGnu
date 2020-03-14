CREATE TABLE `infodb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO users(login, pass, name, surname) values ('admin', 'admin','name', 'surname');
INSERT INTO users(login, pass ,name, surname) values ('user', 'user','name', 'surname');
drop table if exists brands;
CREATE TABLE `infodb`.`brands` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

  INSERT INTO brands(name) values ('brand');
  INSERT INTO brands(name) values ('Toyota');

drop table if exists parts;
CREATE TABLE `infodb`.`parts` (
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
--
INSERT INTO parts(name, brandId, model, price, realiseDate, partCondition, partDescription) values ('name', '1', 'model','100', '2020-02-19', 'USED','description');
INSERT INTO parts(name, brandId, model, price, realiseDate, partCondition, partDescription) values ('Engine', '2', 'JZ-GTE','1100', '2002-02-20','USED','Very good engine');
drop table if exists orders;
CREATE TABLE `infodb`.`orders` (
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

  INSERT INTO orders(name, orderTime, deliveryDate, customerId, totalCost, orderCondition, dateOfCompletion,note,deliveryCondition) values ('name', '2020-02-24T19:28:24.456', '2020-02-24T20:30:24.456', '2','200', 'COMPLETED', '2020-02-24T20:30:24.456','note','ON_THE_WAY');
  INSERT INTO orders(name, orderTime, deliveryDate, customerId, totalCost, orderCondition, dateOfCompletion,note,deliveryCondition) values ('first order', '2020-02-24T20:30:24.456', '2020-02-24T20:30:24.456','2', '400', 'ADOPTED', '2020-02-24T20:30:24.456','note','ON_THE_WAY');
drop table if exists photos;
CREATE TABLE `infodb`.`photos` (
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

  INSERT INTO photos(imageUrl,comment,dateOfDownload,partId) values ('https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/1JZ-GTE_VVT-i_engine_in_1989_Toyota_Cressida.jpg/300px-1JZ-GTE_VVT-i_engine_in_1989_Toyota_Cressida.jpg',null,'2020-02-24T20:30:24.456','2');
  INSERT INTO photos(imageUrl,comment,dateOfDownload,partId) values ('https://www.kosiski.com/wp-content/uploads/2016/07/Parts.jpg',null,'2020-02-24T20:30:24.456','1');

 drop table if exists order_items;
  CREATE TABLE `infodb`.`order_items` (
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

INSERT INTO order_items(partId ,orderId, quantity) VALUES ('2', '2','2');
INSERT INTO order_items(partId ,orderId, quantity) VALUES ('1', '1','1');