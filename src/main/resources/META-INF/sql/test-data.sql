
insert into CATEGORIES (name) values ('Dinning');
insert into CATEGORIES (name) values ('Travel');
insert into CATEGORIES (name) values ('Entertainment');
insert into CATEGORIES (name) values ('Car');
insert into CATEGORIES (name) values ('Health');

insert into USERS (first_name, last_name, email, password, phone_number) values ('Andres', 'Bravo', 'abrovo@gmail.com', 'brabopass', '19176769666');
insert into USERS (first_name, last_name, email, password, phone_number) values ('Brian', 'Porter', 'bporter@gmail.com', 'porterpass', '12122786659');
insert into USERS (first_name, last_name, email, password, phone_number) values ('Meladie', 'Gardout', 'mgardout@gmail.com', 'gardoutpass', '12122789676');
insert into USERS (first_name, last_name, email, password, phone_number) values ('Chris', 'Pine', 'cpine@gmail.com', 'pinepass', '16469861253');
insert into USERS (first_name, last_name, email, password, phone_number) values ('Armie', 'Hammer', 'ahammer@gmail.com', 'hammerpass', '12128563125');

insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(1,3,500,'2017-10-26');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(3,2,50,'2017-10-25');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(2,4,250,'2017-10-24');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(4,1,10,'2017-10-01');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(1,5,5000,'2017-10-13');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(5,1,5250,'2017-10-02');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(5,1,120,'2017-10-30');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(1,2,30,'2017-10-10');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(2,3,870,'2017-10-05');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(1,3,220,'2017-10-26');
insert into BUDGET_ENTRIES(user_id, category_id, amount, entry_date) values(4,4,1000,'2017-10-26');

