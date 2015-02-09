--liquibase formatted sql

--changeset kvkrishnaprasad:1
ALTER TABLE `user_location`
 add column `timestamp` timestamp

--rollback alter table user_location drop column timestamp

