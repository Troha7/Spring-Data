-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_store.my_store_id_seq;

-- Создание таблицы "order"
CREATE TABLE IF NOT EXISTS my_store.order
(
    id            serial,
    creation_date date,
    cost          double precision,
    primary key   (id)
    );

-- Создание таблицы "product"
CREATE TABLE IF NOT EXISTS my_store.product
(
    id           integer NOT NULL DEFAULT nextval('my_store.my_store_id_seq'),
    order_id     integer,
    name         text NOT NULL,
    cost         double precision,
    primary key  (id),
    foreign key  (order_id) references my_store.order (id)
    );

-- Создание индекса
CREATE INDEX IF NOT EXISTS idx_product_cost ON my_store.product USING hash (cost);

