CREATE TABLE `Disciplina` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `cargaHoraria` double NOT NULL,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) engine=InnoDB default charset=utf8;
