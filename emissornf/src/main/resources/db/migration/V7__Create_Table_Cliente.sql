CREATE TABLE IF NOT EXISTS `cliente` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`email` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`telefone` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`fkendereco` INT(10) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `fkendereco` (`fkendereco`) USING BTREE,
	CONSTRAINT `fkendereco` FOREIGN KEY (`fkendereco`) REFERENCES `endereco` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
