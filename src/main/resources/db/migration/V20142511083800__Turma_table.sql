CREATE TABLE `Turma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `curso_id` bigint(20) NOT NULL,
  `finalAnoLetivo` datetime NOT NULL,
  `inicioAnoLetivo` datetime NOT NULL,
  `periodoTurma` varchar(200) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Curso_to_Turma` FOREIGN KEY (`curso_id`) REFERENCES `Curso` (`id`)
) engine=InnoDB default charset=utf8;