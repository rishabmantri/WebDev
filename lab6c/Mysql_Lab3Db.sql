CREATE TABLE `phoneEntry` (
  `phoneno` INT NOT NULL,
  `fname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `phonebook` VARCHAR(45) NULL,
  PRIMARY KEY (`phoneno`));


INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`, `phonebook`) VALUES ('10', 'Leo', 'Messi', 'A');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`, `phonebook`) VALUES ('7', 'Chris', 'Ronaldo', 'A');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`, `phonebook`) VALUES ('18', 'Virat', 'Kohli', 'B');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`, `phonebook`) VALUES ('45', 'Rohit', 'Sharma', 'B');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`, `phonebook`) VALUES ('12', 'Yuvraj', 'Singh', 'B');

INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`) VALUES ('23', 'Lebron', 'James');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`) VALUES ('3', 'Dwyane', 'Wade');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`) VALUES ('30', 'Steph', 'Curry');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`) VALUES ('1', 'Devin', 'Booker');
INSERT INTO `phoneEntry` (`phoneno`, `fname`, `lname`) VALUES ('13', 'Paul', 'Goerge');




