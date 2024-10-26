CREATE TABLE IF NOT EXISTS `customer` (
    `customer_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `mobile_number` varchar(255) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(255) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `accounts` (
    `account_number` int AUTO_INCREMENT PRIMARY KEY ,
    `customer_id` int NOT NULL,
    `account_type` varchar(255) NOT NULL,
    `branch_address` varchar(255) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(255) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(255) DEFAULT NULL
);