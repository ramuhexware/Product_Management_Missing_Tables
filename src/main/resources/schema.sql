-- Unmapped / Unused database tables (no JPA entity or Java reference exists in application)

CREATE TABLE IF NOT EXISTS deprecated_user_logs (
    log_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    action VARCHAR(255),
    ip_address VARCHAR(45),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS temp_promotions (
    promo_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    promo_code VARCHAR(50) NOT NULL UNIQUE,
    discount_percentage DECIMAL(5,2),
    start_date DATE,
    end_date DATE,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS vendor_discount_rates (
    vendor_id BIGINT PRIMARY KEY,
    vendor_name VARCHAR(100),
    tier_level INT,
    rebate_percentage DECIMAL(5,2),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
