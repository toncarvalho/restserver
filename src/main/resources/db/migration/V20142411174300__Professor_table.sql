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