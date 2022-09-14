-- liquibase formatted sql
-- changeset kull:liqubase run create table answers and insert data
create table IF NOT EXISTS answers (
                                         id  serial primary key,
                                         question_id int not null,
                                         answer int not null,
                                         constraint fk_question
                                         foreign key (question_id)
                                        references question (id));

insert into answers(id,question_id,answer)
values (1,1,3),
       (2,2,2),
       (3,3,1),
       (4,4,2),
       (5,5,3),
       (6,6,1),
       (7,7,2),
       (8,8,1),
       (9,9,2),
       (10,10,3),
       (11,11,3);