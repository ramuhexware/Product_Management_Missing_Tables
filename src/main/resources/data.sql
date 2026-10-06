-- Seed data for unmapped unused database tables
INSERT INTO deprecated_user_logs (user_id, action, ip_address) VALUES 
('usr_99', 'LOGIN_DEPRECATED', '192.168.1.10'),
('usr_100', 'UPDATE_PROFILE_V1', '192.168.1.15');

INSERT INTO temp_promotions (promo_code, discount_percentage, start_date, end_date, is_active) VALUES 
('SPRING2024', 15.50, '2024-03-01', '2024-03-31', TRUE),
('FLASHSALE', 25.00, '2024-04-01', '2024-04-02', FALSE);

INSERT INTO vendor_discount_rates (vendor_id, vendor_name, tier_level, rebate_percentage) VALUES 
(101, 'Acme Corp Hardware', 1, 5.25),
(102, 'Global Tech Supply', 2, 8.50);
