CREATE TABLE `FrequenciaAluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `presente` bit(1) DEFAULT NULL,
  `aluno_id` bigint(20) DEFAULT NULL,
  `lancamentoDiario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_aluno_id` (`aluno_id`),
  KEY `FK_lancamentoDiario_id` (`lancamentoDiario_id`),
  CONSTRAINT `FK_Aluno_to_Frequencia` FOREIGN KEY (`aluno_id`) REFERENCES `Aluno` (`id`),
  CONSTRAINT `FK_LancamentoDiario_toFrequencia` FOREIGN KEY (`lancamentoDiario_id`) REFERENCES `LancamentoDiario` (`id`)
) engine=InnoDB default charset=utf8;