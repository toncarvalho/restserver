CREATE TABLE `FrequenciaDisciplinaTurma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `diaDaSemana` varchar(30) NOT NULL,
  `horarioFinal` time NOT NULL,
  `horarioInicial` time NOT NULL,
  `disciplinasTurmaProfessor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_disciplinasTurmaProfessor_id` (`disciplinasTurmaProfessor_id`),
  CONSTRAINT `FK_disciplinasTurmaProfessor_id_to_FrequenciaDisciplinaTurma` FOREIGN KEY (`disciplinasTurmaProfessor_id`) REFERENCES `DisciplinasTurmaProfessor` (`id`)
) engine=InnoDB default charset=utf8;