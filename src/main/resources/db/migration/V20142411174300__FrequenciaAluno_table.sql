CREATE TABLE `FrequenciaAluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `presente` bit(1) DEFAULT NULL,
  `aluno_id` bigint(20) DEFAULT NULL,
  `lancamentoDiario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_epeuano7puixq496i0nhtsgfl` (`aluno_id`),
  KEY `FK_nk14tlq2m1yrwj6iux48rrjl8` (`lancamentoDiario_id`),
  CONSTRAINT `FK_epeuano7puixq496i0nhtsgfl` FOREIGN KEY (`aluno_id`) REFERENCES `Aluno` (`id`),
  CONSTRAINT `FK_nk14tlq2m1yrwj6iux48rrjl8` FOREIGN KEY (`lancamentoDiario_id`) REFERENCES `LancamentoDiario` (`id`)
) engine=InnoDB default charset=utf8;