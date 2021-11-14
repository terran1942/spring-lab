CREATE TABLE `customer`
(
    `id`       bigint       NOT NULL AUTO_INCREMENT,
    `username` varchar(64)  NOT NULL,
    `password` varchar(64)  NOT NULL,
    `level`    int          NOT NULL DEFAULT '0',
    `email`    varchar(256) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `customer_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

