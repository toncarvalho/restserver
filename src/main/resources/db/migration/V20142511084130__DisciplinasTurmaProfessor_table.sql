CREATE TABLE `DisciplinasTurmaProfessor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `disciplina_id` bigint(20) NOT NULL,
  `professor_id` bigint(20) NOT NULL,
  `turma_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_disciplina_id` (`disciplina_id`),
  KEY `FK_professor_id` (`professor_id`),
  KEY `FK_turma_id` (`turma_id`),
  CONSTRAINT `FK_Turma_to_dtp` FOREIGN KEY (`turma_id`) REFERENCES `Turma` (`id`),
  CONSTRAINT `FK_Professor_to_dtp` FOREIGN KEY (`professor_id`) REFERENCES `Professor` (`id`),
  CONSTRAINT `FK_Disciplina_to_dtp` FOREIGN KEY (`disciplina_id`) REFERENCES `Disciplina` (`id`)
) engine=InnoDB default charset=utf8;