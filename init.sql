CREATE DATABASE wallet_db;
CREATE DATABASE digital_wallet_db;

\c wallet_db;

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    sku VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    stock INT NOT NULL
);

INSERT INTO products (sku, name, price, stock) 
VALUES ('KB-001', 'Teclado Mecánico RGB', 89.99, 15) 
ON CONFLICT (sku) DO NOTHING;

\c digital_wallet_db;

CREATE TABLE IF NOT EXISTS refunds (
    id SERIAL PRIMARY KEY,
    sku VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    wallet_id VARCHAR(100),
    external_transaction_id VARCHAR(100),
    amount NUMERIC(10, 2) NOT NULL,
    currency VARCHAR(10) DEFAULT 'MXN',
    reason VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);