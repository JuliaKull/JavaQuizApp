-- liquibase formatted sql
-- changeset kull:liqubase run create table question
create table IF NOT EXISTS questions (
                                    id  serial primary key,
                                    topic varchar(50) not null ,
                                    rank varchar(50) not null ,
                                    title varchar(300) not null ,
                                    answer_a varchar(100)  not null ,
                                    answer_b varchar(100)  not null ,
                                    answer_c varchar(100) not null);