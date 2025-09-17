CREATE TABLE persons (id  integer, age integer, birth_date date, cpf varchar(20), email varchar(150), name varchar(120) not null, primary key (id), unique (email));
CREATE TABLE products (id  integer, name varchar(120) not null, price double precision, quantity integer, status boolean, primary key (id));
