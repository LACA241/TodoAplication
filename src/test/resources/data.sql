INSERT INTO szl.users(id_user, first_name, surename, phone, email_address)VALUES
(1,'Peter','Zeman',0958741963,'pzeman@yahoo.com'),
(2,'Zoltan','Zelezny',949582654,'zzelazny@yahoo.com'),
(3,'Erika','Potocna',915123456,'e.potocna@citrommail.com'),
 (4,'Valeria','Kaffa',905987456,'v.kaffa@gmail.com'),
 (5,'Jozef','Zahorak',0903654951,'jzahorak@gmail.com');

 insert into szl.tasks (id_task, title, description, status, due_date, id_user) values
 (1,'cleaning','clean bathroom','in progres','2023-10-15',3),
 (2,'work','finis project Hawai','in progres','2023-12-15',1),
 (3,'work','send an E-mail','Initial','2023-10-01',1),
 (4,'Home','Terras ceaning','Initial','2023-10-26',2),
 (5,'Home','Children Homework','Initial','2023-09-30',4),
 (6,'Home','Car to workshop','Initial','2023-09-30',5);