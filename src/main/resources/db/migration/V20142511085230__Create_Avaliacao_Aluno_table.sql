 CREATE TABLE `AvaliacaoAluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `aluno` tinyblob NOT NULL,
  `dataAvaliacao` datetime NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `nota` double NOT NULL,
  `diarioDeClasse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_diarioDeClasse_id` (`diarioDeClasse_id`),
  CONSTRAINT `FK_AvaliacaoAluno_diarioDeClasse_id` FOREIGN KEY (`diarioDeClasse_id`) REFERENCES `DiarioDeClasse` (`id`)
) engine=InnoDB default charset=utf8;
