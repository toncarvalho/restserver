CREATE TABLE `Curso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `descricao` varchar(200) NOT NULL,
  `duracao` varchar(200) NOT NULL,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) engine=InnoDB default charset=utf8;