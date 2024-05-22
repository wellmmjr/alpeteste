CREATE TABLE IF NOT EXISTS `tributacaovenda` (
	`fkvenda` INT(10) UNSIGNED NOT NULL,
	`fktributacao` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
	INDEX `fktributacao` (`fktributacao`) USING BTREE,
	INDEX `fkvenda_tributacao` (`fkvenda`) USING BTREE,
	CONSTRAINT `fktributacao` FOREIGN KEY (`fktributacao`) REFERENCES `tributacoes` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `fkvenda_tributacao` FOREIGN KEY (`fkvenda`) REFERENCES `venda` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
