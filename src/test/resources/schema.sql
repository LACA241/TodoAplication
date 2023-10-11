create schema szl;


CREATE TABLE szl.users (
                           id_user int4 NOT NULL,
                           first_name varchar NULL,
                           surename varchar NULL,
                           phone int4 NULL,
                           email_address varchar NULL,
                           CONSTRAINT users_pk PRIMARY KEY (id_user)
);

CREATE TABLE szl.tasks (
                           id_task int4 NOT NULL,
                           title varchar NULL,
                           description varchar NULL,
                           status varchar NULL,
                           due_date date NULL,
                           updated_date date NULL,
                           id_user int4 NULL,
                           CONSTRAINT tasks_pk PRIMARY KEY (id_task),
                           CONSTRAINT tasks_fk FOREIGN KEY (id_user) REFERENCES szl.users(id_user)
);