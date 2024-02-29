DROP TABLE carts IF EXISTS;
DROP TABLE customers IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE transactions IF EXISTS;
DROP TABLE orders IF EXISTS;

CREATE TABLE products (
    id long AUTO_INCREMENT,
    product_uuid VARCHAR2(36) UNIQUE,
    product_name VARCHAR2(50),
    price DOUBLE,
    currency VARCHAR2(10),
    created_date DateTime default CURRENT_TIMESTAMP,
    PRIMARY KEY (product_uuid)
);

CREATE TABLE carts (
    id long AUTO_INCREMENT,
    order_id long,
    product_uuid VARCHAR2(36),
    cart_uuid VARCHAR2(50),
    quantity numeric,
    created_date TIMESTAMP default CURRENT_TIMESTAMP,
    FOREIGN KEY (product_uuid) REFERENCES products(product_uuid)
);

CREATE TABLE customers(
    id long AUTO_INCREMENT,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    registration_date DateTime default CURRENT_TIMESTAMP,
    update_date DateTime
);

CREATE TABLE orders (
    id long AUTO_INCREMENT,
    customer_id long,
    cart_uuid VARCHAR2(50),
    transaction_id long,
    order_date DateTime default CURRENT_TIMESTAMP);

CREATE TABLE transactions (
    id long AUTO_INCREMENT,
    original_amount DOUBLE,
    discounted_amount DOUBLE,
    quantity numeric,
    discount_percentage DOUBLE,
    discount_amount DOUBLE,
    currency VARCHAR2(10),
    transaction_date DateTime default CURRENT_TIMESTAMP);

INSERT INTO products(id,product_uuid,product_name,price,currency) values(1,'96f682d6-919c-4291-b049-537f09e4e7d9','phone', 99.0,'USD');
INSERT INTO products(id,product_uuid,product_name,price,currency) values(2,'f51a5e58-2771-4250-9a0a-8c6ab0bce0d9','shoes', 20.0,'USD');
INSERT INTO products(id,product_uuid,product_name,price,currency) values(3,'ec60efcb-949b-441b-b30e-26f86c92ef1e','tv', 300.0,'USD');
INSERT INTO products(id,product_uuid,product_name,price,currency) values(4,'70948505-4bad-4c77-8e2b-5497b5236236','candy',3.0,'USD');
INSERT INTO products(id,product_uuid,product_name,price,currency) values(5,'8cc2480c-28e2-4591-b32c-c6ab6d3b283e','shoes', 101.0,'USD');
INSERT INTO products(id,product_uuid,product_name,price,currency) values(6,'6cc2480d-28e2-4591-b32d-c6ab6d3b183e','dinner', 120.0,'USD');
INSERT INTO customers(id,first_name,last_name) values(1, 'Olivia' ,'Boyes');
INSERT INTO customers(id,first_name,last_name) values(2, 'Jane','Wyatt');

INSERT INTO carts(order_id,product_uuid,quantity,cart_uuid) values (1,'ec60efcb-949b-441b-b30e-26f86c92ef1e',10,'6e427e4c-7693-4a2b-b0ee-cb699422e3b6');
INSERT INTO carts(order_id,product_uuid,quantity,cart_uuid) values (2,'f51a5e58-2771-4250-9a0a-8c6ab0bce0d9',12,'6e427e4c-7693-4a2b-b0ee-cb699422e3b6');

INSERT INTO orders(id,customer_id,transaction_id, order_date,cart_uuid) values (1, 1, 1,'2024-02-01 00:00:00','6e427e4c-7693-4a2b-b0ee-cb699422e3b6');
INSERT INTO transactions(original_amount,discounted_amount,currency,quantity,discount_percentage,discount_amount,transaction_date) values (1230.0,1191.10,'USD',22,36.9,2.0,'2024-02-28 09:00:01.590226');

COMMIT;