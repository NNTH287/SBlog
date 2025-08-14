DROP DATABASE IF EXISTS SBlog;
CREATE DATABASE IF NOT EXISTS SBlog;

USE SBlog;

CREATE TABLE `User` (
  `ID` INT PRIMARY KEY AUTO_INCREMENT,
  `Fullname` VARCHAR(100),
  `Username` VARCHAR(50),
  `HashedPassword` VARCHAR(255)
);

CREATE TABLE `Post` (
  `ID` INT PRIMARY KEY AUTO_INCREMENT,
  `UserID` INT,
  `Title` VARCHAR(255),
  `Content` TEXT,
  `CreateDate` DATETIME,
  `UpdateDate` DATETIME
);

CREATE TABLE `Comment` (
  `ID` INT PRIMARY KEY AUTO_INCREMENT,
  `PostID` INT,
  `UserID` INT,
  `Content` TEXT,
  `CreateDate` DATETIME,
  `UpdateDate` DATETIME
);

ALTER TABLE `Comment` ADD FOREIGN KEY (`PostID`) REFERENCES `Post` (`ID`);

ALTER TABLE `Post` ADD FOREIGN KEY (`UserID`) REFERENCES `User` (`ID`);

ALTER TABLE `Comment` ADD FOREIGN KEY (`UserID`) REFERENCES `User` (`ID`);

Use SBlog;

INSERT INTO `User` (`Fullname`, `Username`, `HashedPassword`)
VALUES ('Huy Nguyen', 'huynguyen287123' , '123456');
