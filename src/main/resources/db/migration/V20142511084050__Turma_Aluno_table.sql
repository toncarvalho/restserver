CREATE TABLE `Turma_Aluno` (
  `Turma_id` bigint(20) NOT NULL,
  `alunos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_alunos_id` (`alunos_id`),
  KEY `FK_alunos_id` (`Turma_id`),
  CONSTRAINT `FK_Aluno_to_turma_aluno` FOREIGN KEY (`alunos_id`) REFERENCES `Aluno` (`id`),
  CONSTRAINT `FK_Turma_to_turma_aluno` FOREIGN KEY (`Turma_id`) REFERENCES `Turma` (`id`)
) engine=InnoDB default charset=utf8;