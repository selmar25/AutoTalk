--liquibase formatted sql

--changeset kvkrishnaprasad:1

INSERT INTO `user_location` (`id`, `user_id`, `latitude`, `longitude`, `timestamp`)
VALUES
	(1,28,2.31,3.47,'2015-02-09 09:40:18'),
	(2,25,2.31,3.4,'2015-02-09 09:40:28');


--rollback delete from `user_location` where id in (1, 2)