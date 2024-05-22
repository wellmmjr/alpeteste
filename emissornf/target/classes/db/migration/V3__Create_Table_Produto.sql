CREATE TABLE IF NOT EXISTS `produto` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`descricao` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`preco` DOUBLE NOT NULL DEFAULT '0',
	`fkfornecedor` INT(10) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `fkfornecedorproduto` (`fkfornecedor`) USING BTREE,
	CONSTRAINT `fkfornecedorproduto` FOREIGN KEY (`fkfornecedor`) REFERENCES `fornecedor` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
