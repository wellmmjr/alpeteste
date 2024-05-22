CREATE TABLE IF NOT EXISTS `tributacoes` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`descricao` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`percentual` DOUBLE NOT NULL DEFAULT '0',
	`operacao` BINARY(50) NOT NULL DEFAULT '0x30',
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='tabela para registrar descontos e impostos\r\n'
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
