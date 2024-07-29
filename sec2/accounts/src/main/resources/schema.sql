CREATE TABLE IF NOT EXISTS `Customer` (
                                          `customerId` int AUTO_INCREMENT  PRIMARY KEY,
                                          `name` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `mobileNumber` varchar(20) NOT NULL,
    `createdAt` date NOT NULL,
    `createdBy` varchar(20) NOT NULL,
    `updatedAt` date DEFAULT NULL,
    `updatedBy` varchar(20) DEFAULT NULL
    );

CREATE TABLE IF NOT EXISTS `Accounts` (
                                          `customer_id` int NOT NULL,
                                          `account_number` int AUTO_INCREMENT  PRIMARY KEY,
                                          `account_type` varchar(100) NOT NULL,
    `branch_address` varchar(200) NOT NULL,
    `createdAt` date NOT NULL,
    `createdBy` varchar(20) NOT NULL,
    `updatedAt` date DEFAULT NULL,
    `updatedBy` varchar(20) DEFAULT NULL
    );