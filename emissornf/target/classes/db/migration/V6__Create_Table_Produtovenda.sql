CREATE TABLE IF NOT EXISTS `produtovenda` (
	`fkproduto` INT(10) NOT NULL,
	`fkvenda` INT(10) UNSIGNED NOT NULL,
	INDEX `fkproduto` (`fkproduto`) USING BTREE,
	INDEX `fkvenda_produtos` (`fkvenda`) USING BTREE,
	CONSTRAINT `fkproduto` FOREIGN KEY (`fkproduto`) REFERENCES `produto` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `fkvenda_produtos` FOREIGN KEY (`fkvenda`) REFERENCES `venda` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
