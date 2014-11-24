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