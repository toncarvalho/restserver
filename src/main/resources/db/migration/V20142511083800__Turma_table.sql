CREATE TABLE `Turma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `curso` tinyblob NOT NULL,
  `finalAnoLetivo` datetime NOT NULL,
  `inicioAnoLetivo` datetime NOT NULL,
  `periodoTurma` varchar(200) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) engine=InnoDB default charset=utf8;