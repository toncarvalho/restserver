CREATE TABLE `FrequenciaDisciplinaTurma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `diaDaSemana` varchar(30) NOT NULL,
  `horarioFinal` time NOT NULL,
  `horarioInicial` time NOT NULL,
  `disciplinasTurmaProfessor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_25rxffo2ndwa54o6twbg28uw1` (`disciplinasTurmaProfessor_id`),
  CONSTRAINT `FK_25rxffo2ndwa54o6twbg28uw1` FOREIGN KEY (`disciplinasTurmaProfessor_id`) REFERENCES `DisciplinasTurmaProfessor` (`id`)
) engine=InnoDB default charset=utf8;

CREATE TABLE `LancamentoDiario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `data` datetime NOT NULL,
  `descricaoDeAtividades` varchar(200) NOT NULL,
  `diarioDeClasse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rb87c39oajpibn3odxqgfwsbh` (`diarioDeClasse_id`),
  CONSTRAINT `FK_rb87c39oajpibn3odxqgfwsbh` FOREIGN KEY (`diarioDeClasse_id`) REFERENCES `DiarioDeClasse` (`id`)
) engine=InnoDB default charset=utf8;

 CREATE TABLE `Professor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `foneCelular` varchar(20) NOT NULL,
  `foneComercial` varchar(20) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `numeroRegistro` varchar(30) NOT NULL,
  `sites` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) engine=InnoDB default charset=utf8;

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

CREATE TABLE `Turma_Aluno` (
  `Turma_id` bigint(20) NOT NULL,
  `alunos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_6ui02pfufvota5lfouwtbxrfx` (`alunos_id`),
  KEY `FK_o6kll0x3n7biikaahd1tkedhg` (`Turma_id`),
  CONSTRAINT `FK_6ui02pfufvota5lfouwtbxrfx` FOREIGN KEY (`alunos_id`) REFERENCES `Aluno` (`id`),
  CONSTRAINT `FK_o6kll0x3n7biikaahd1tkedhg` FOREIGN KEY (`Turma_id`) REFERENCES `Turma` (`id`)
) engine=InnoDB default charset=utf8;