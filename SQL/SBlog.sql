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
VALUES ('Huy Nguyen', 'huynguyen287123' , '123456'),
	('Hung Nguyen', 'hung123' , '123456');

INSERT INTO `Post` (`UserID`, `Title`, `Content`, `CreateDate`, `UpdateDate`)
VALUES (1, 'My first post on SBlog', 'This is the first post of me on SBlog' , '2025-01-13 20:00:00', '2025-01-13 20:00:00'),
	(1, 'Another post', 'Another post of me on SBlog' , '2025-01-25 20:00:00', '2025-01-25 20:00:00');

INSERT INTO `Comment` (`PostID`, `UserID`, `Content`, `CreateDate`, `UpdateDate`)
VALUES (1, 1, 'This is the first comment of me on SBlog' , '2025-01-13 20:05:00', '2025-01-13 20:05:00'),
	(1, 2, 'Nice' , '2025-01-14 20:00:00', '2025-01-14 21:00:00');
