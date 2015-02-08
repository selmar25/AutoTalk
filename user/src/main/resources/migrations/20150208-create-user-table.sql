--liquibase formatted sql

--changeset nvoxland:1
CREATE TABLE `user` (
  `id` int(11) NOT NULL DEFAULT '0',
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user values (1, "kp", "prasad");

--rollback drop table user;

