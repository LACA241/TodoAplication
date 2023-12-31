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

insert into szl.tasks (id_task, title, description, status, due_date, id_user)
values(6,'Home','Car to workshop','Initial','2023-09-30',5);

CREATE TABLE szl.users (
	id_user int4 NOT NULL,
	first_name varchar NULL,
	surename varchar NULL,
	phone int4 NULL,
	email_address varchar NULL,
	CONSTRAINT users_pk PRIMARY KEY (id_user)
);

insert into szl.users(id_user, first_name, surename, phone, email_address)
values(5,'Jozef','Zahorak',0903654951,'jzahorak@gmail.com');