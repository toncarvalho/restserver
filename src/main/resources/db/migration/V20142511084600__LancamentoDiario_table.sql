CREATE TABLE `LancamentoDiario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `data` datetime NOT NULL,
  `descricaoDeAtividades` varchar(200) NOT NULL,
  `diarioDeClasse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_diarioDeClasse_id` (`diarioDeClasse_id`),
  CONSTRAINT `FK_DiarioDeClasse_to_LancamentoDiario` FOREIGN KEY (`diarioDeClasse_id`) REFERENCES `DiarioDeClasse` (`id`)
) engine=InnoDB default charset=utf8;