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

create table `Pessoa` (
    `id` bigint(20) not null auto_increment,
    `version` int(11) default null,
    `nome` varchar(255) not null,
    `email` varchar(255) default null,
    primary key (`id`)
) engine=InnoDB default charset=utf8;

CREATE TABLE `Aluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `fone` varchar(20) NOT NULL,
  `foneComercial` varchar(20) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `registroAcademico` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) engine=InnoDB default charset=utf8;

CREATE TABLE `Curso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `descricao` varchar(200) NOT NULL,
  `duracao` varchar(200) NOT NULL,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) engine=InnoDB default charset=utf8;


CREATE TABLE `Disciplina` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `cargaHoraria` double NOT NULL,
  `nome` varchar(200) NOT NULL,
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
  UNIQUE KEY `UK_alunos_id` (`alunos_id`),
  KEY `FK_o6kll0x3n7biikaahd1tkedhg` (`Turma_id`),
  CONSTRAINT `FK_Aluno` FOREIGN KEY (`alunos_id`) REFERENCES `Aluno` (`id`),
  CONSTRAINT `FK_Turma` FOREIGN KEY (`Turma_id`) REFERENCES `Turma` (`id`)
) engine=InnoDB default charset=utf8;


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
  CONSTRAINT `FK_Turma` FOREIGN KEY (`turma_id`) REFERENCES `Turma` (`id`),
  CONSTRAINT `FK_Professor` FOREIGN KEY (`professor_id`) REFERENCES `Professor` (`id`),
  CONSTRAINT `FK_Disciplina` FOREIGN KEY (`disciplina_id`) REFERENCES `Disciplina` (`id`)
) engine=InnoDB default charset=utf8;



CREATE TABLE `DiarioDeClasse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `finalVigencia` datetime NOT NULL,
  `inicioVigencia` datetime NOT NULL,
  `disciplina_id` bigint(20) NOT NULL,
  `professor_id` bigint(20) NOT NULL,
  `turma_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_disciplina_id` (`disciplina_id`),
  KEY `FK_professor_id` (`professor_id`),
  KEY `FK_turma_id` (`turma_id`),
  CONSTRAINT `FK_Professor` FOREIGN KEY (`professor_id`) REFERENCES `Professor` (`id`),
  CONSTRAINT `FK_Disciplina` FOREIGN KEY (`disciplina_id`) REFERENCES `Disciplina` (`id`),
  CONSTRAINT `FK_Turma` FOREIGN KEY (`turma_id`) REFERENCES `Turma` (`id`)
) engine=InnoDB default charset=utf8;



CREATE TABLE `LancamentoDiario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `data` datetime NOT NULL,
  `descricaoDeAtividades` varchar(200) NOT NULL,
  `diarioDeClasse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_diarioDeClasse_id` (`diarioDeClasse_id`),
  CONSTRAINT `FK_DiarioDeClasse` FOREIGN KEY (`diarioDeClasse_id`) REFERENCES `DiarioDeClasse` (`id`)
) engine=InnoDB default charset=utf8;


CREATE TABLE `FrequenciaAluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `presente` bit(1) DEFAULT NULL,
  `aluno_id` bigint(20) DEFAULT NULL,
  `lancamentoDiario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_aluno_id` (`aluno_id`),
  KEY `FK_lancamentoDiario_id` (`lancamentoDiario_id`),
  CONSTRAINT `FK_Aluno` FOREIGN KEY (`aluno_id`) REFERENCES `Aluno` (`id`),
  CONSTRAINT `FK_LancamentoDiario` FOREIGN KEY (`lancamentoDiario_id`) REFERENCES `LancamentoDiario` (`id`)
) engine=InnoDB default charset=utf8;



 CREATE TABLE `AvaliacaoAluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `aluno` tinyblob NOT NULL,
  `dataAvaliacao` datetime NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `nota` double NOT NULL,
  `diarioDeClasse_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_diarioDeClasse_id` (`diarioDeClasse_id`),
  CONSTRAINT `FK_AvaliacaoAluno_diarioDeClasse_id` FOREIGN KEY (`diarioDeClasse_id`) REFERENCES `DiarioDeClasse` (`id`)
) engine=InnoDB default charset=utf8;

CREATE TABLE `FrequenciaDisciplinaTurma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `diaDaSemana` varchar(30) NOT NULL,
  `horarioFinal` time NOT NULL,
  `horarioInicial` time NOT NULL,
  `disciplinasTurmaProfessor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_disciplinasTurmaProfessor_id` (`disciplinasTurmaProfessor_id`),
  CONSTRAINT `FK_DisciplinasTurmaProfessor` FOREIGN KEY (`disciplinasTurmaProfessor_id`) REFERENCES `DisciplinasTurmaProfessor` (`id`)
) engine=InnoDB default charset=utf8;
