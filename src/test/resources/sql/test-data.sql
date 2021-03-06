
insert into MyBudget.CATEGORIES (name) values ('Dinning');
insert into MyBudget.CATEGORIES (name) values ('Travel');
insert into MyBudget.CATEGORIES (name) values ('Entertainment');
insert into MyBudget.CATEGORIES (name) values ('Car');
insert into MyBudget.CATEGORIES (name) values ('Health');

insert into MyBudget.PHONES (country_code, area_code, number) values (1, 212, 6636659);
insert into MyBudget.PHONES (country_code, area_code, number) values (1, 917, 2239666);
insert into MyBudget.PHONES (country_code, area_code, number) values (1, 417, 3219676);
insert into MyBudget.PHONES (country_code, area_code, number) values (1, 718, 4521253);
insert into MyBudget.PHONES (country_code, area_code, number) values (1, 516, 8301708);

insert into MyBudget.USERS (first_name, last_name, email, password, phone_id) values ('Andres', 'Bravo', 'abrovo@gmail.com', 'brabopass', 5);
insert into MyBudget.USERS (first_name, last_name, email, password, phone_id) values ('Brian', 'Porter', 'bporter@gmail.com', 'porterpass', 1);
insert into MyBudget.USERS (first_name, last_name, email, password, phone_id) values ('Meladie', 'Gardout', 'mgardout@gmail.com', 'gardoutpass', 2);
insert into MyBudget.USERS (first_name, last_name, email, password, phone_id) values ('Chris', 'Pine', 'cpine@gmail.com', 'pinepass', 3);
insert into MyBudget.USERS (first_name, last_name, email, password, phone_id) values ('Armie', 'Hammer', 'ahammer@gmail.com', 'hammerpass', 4);

insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(1,3,'test1',500,'2017-10-26');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(3,2,'test2',50,'2017-10-25');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(2,4,'test3',250,'2017-10-24');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(4,1,'test4',10,'2017-10-01');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(1,5,'test5',5000,'2017-10-13');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(5,1,'test6',5250,'2017-10-02');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(5,1,'test7',120,'2017-10-30');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(1,2,'test8',30,'2017-10-10');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(2,3,'test9',870,'2017-10-05');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(1,3,'test10',220,'2017-10-26');
insert into MyBudget.BUDGET_ENTRIES(user_id, category_id, description, amount, entry_date) values(4,4,'test11',1000,'2017-10-26');

