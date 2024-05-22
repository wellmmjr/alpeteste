CREATE TABLE IF NOT EXISTS `fornecedor` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`nome_fantasia` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_0900_ai_ci',
	`cnpj` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_0900_ai_ci',
	`fkendereco` INT(10) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `fkendereco_fornecedor` (`fkendereco`) USING BTREE,
	CONSTRAINT `fkendereco_fornecedor` FOREIGN KEY (`fkendereco`) REFERENCES `endereco` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
