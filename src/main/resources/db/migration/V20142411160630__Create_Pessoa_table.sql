create table `Pessoa` (
    `id` bigint(20) not null auto_increment,
    `version` int(11) default null,
    `nome` varchar(255) not null,
    `email` varchar(255) default null,
    primary key (`id`)
) engine=InnoDB default charset=utf8;
