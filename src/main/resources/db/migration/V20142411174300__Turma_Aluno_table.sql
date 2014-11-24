CREATE TABLE `Turma_Aluno` (
  `Turma_id` bigint(20) NOT NULL,
  `alunos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_6ui02pfufvota5lfouwtbxrfx` (`alunos_id`),
  KEY `FK_o6kll0x3n7biikaahd1tkedhg` (`Turma_id`),
  CONSTRAINT `FK_6ui02pfufvota5lfouwtbxrfx` FOREIGN KEY (`alunos_id`) REFERENCES `Aluno` (`id`),
  CONSTRAINT `FK_o6kll0x3n7biikaahd1tkedhg` FOREIGN KEY (`Turma_id`) REFERENCES `Turma` (`id`)
) engine=InnoDB default charset=utf8;