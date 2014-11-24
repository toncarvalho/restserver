CREATE TABLE `DisciplinasTurmaProfessor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `disciplina_id` bigint(20) NOT NULL,
  `professor_id` bigint(20) NOT NULL,
  `turma_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kpdottd6fyhoq6e07x361iohe` (`disciplina_id`),
  KEY `FK_dxhgjux027q4l1a88yw5lvpw5` (`professor_id`),
  KEY `FK_6cr6qcg9j2vxpworp3qm988pb` (`turma_id`),
  CONSTRAINT `FK_6cr6qcg9j2vxpworp3qm988pb` FOREIGN KEY (`turma_id`) REFERENCES `Turma` (`id`),
  CONSTRAINT `FK_dxhgjux027q4l1a88yw5lvpw5` FOREIGN KEY (`professor_id`) REFERENCES `Professor` (`id`),
  CONSTRAINT `FK_kpdottd6fyhoq6e07x361iohe` FOREIGN KEY (`disciplina_id`) REFERENCES `Disciplina` (`id`)
) engine=InnoDB default charset=utf8;