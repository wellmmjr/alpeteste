CREATE TABLE `users` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`full_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`password` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`account_non_expired` BIT(1) NULL DEFAULT NULL,
	`account_non_locked` BIT(1) NULL DEFAULT NULL,
	`credentials_non_expired` BIT(1) NULL DEFAULT NULL,
	`enabled` BIT(1) NULL DEFAULT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `uk_user_name` (`user_name`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
