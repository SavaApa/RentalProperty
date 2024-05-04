-- Insert data for landlords
INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (UUID(), 3, 2, 1),
       (UUID(), 2, 1, 1);

-- Insert data for tenants
INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (UUID(), 'Downtown', 2, 1500.00, true, false, 'APARTMENT'),
       (UUID(), 'Suburbia', 3, 2000.00, false, true, 'OFFICE');

-- Insert data for properties
INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (UUID(), '123 Main St, Downtown', 1200.00, 'APARTMENT', 2, 'Downtown', true, false, (SELECT l_id FROM landlords LIMIT 1), (SELECT t_id FROM tenants LIMIT 1)),
       (UUID(), '456 Elm St, Suburbia', 1800.00, 'OFFICE', 3, 'Suburbia', true, true, (SELECT l_id FROM landlords LIMIT 1 OFFSET 1), (SELECT t_id FROM tenants LIMIT 1 OFFSET 1));

-- Insert data for applications
INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (UUID(), '2024-03-15', 'ACCEPTED', (SELECT l_id FROM landlords LIMIT 1), (SELECT prop_id FROM properties LIMIT 1), (SELECT t_id FROM tenants LIMIT 1)),
       (UUID(), '2024-03-20', 'REJECTED', (SELECT l_id FROM landlords LIMIT 1 OFFSET 1), (SELECT prop_id FROM properties LIMIT 1 OFFSET 1), (SELECT t_id FROM tenants LIMIT 1 OFFSET 1));

-- Insert data for contracts
INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (UUID(), '2024-04-01', '2025-03-31', (SELECT ap_id FROM applications LIMIT 1), (SELECT prop_id FROM properties LIMIT 1), (SELECT t_id FROM tenants LIMIT 1), (SELECT l_id FROM landlords LIMIT 1)),
       (UUID(), '2024-04-05', '2025-04-04', (SELECT ap_id FROM applications LIMIT 1 OFFSET 1), (SELECT prop_id FROM properties LIMIT 1 OFFSET 1), (SELECT t_id FROM tenants LIMIT 1 OFFSET 1), (SELECT l_id FROM landlords LIMIT 1 OFFSET 1));

-- Insert data for payments
INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (UUID(), 1200.00, '2024-04-01', 'PAID', (SELECT c_id FROM contracts LIMIT 1)),
       (UUID(), 1800.00, '2024-04-05', 'PAID', (SELECT c_id FROM contracts LIMIT 1 OFFSET 1));

-- Insert data for user_info
INSERT INTO user_info (ui_id, email, password)
VALUES (UUID(), 'landlord1@example.com', 'password123'),
       (UUID(), 'tenant1@example.com', 'password456');

-- Insert data for users
INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id)
VALUES (UUID(), 'John', 'Doe', (SELECT ui_id FROM user_info LIMIT 1), NULL, (SELECT l_id FROM landlords LIMIT 1)),
       (UUID(), 'Jane', 'Smith', (SELECT ui_id FROM user_info LIMIT 1 OFFSET 1), (SELECT t_id FROM tenants LIMIT 1 OFFSET 1), NULL);

-- Insert data for roles
INSERT INTO roles (r_id, role_name)
VALUES (UUID(), 'Landlord'),
       (UUID(), 'Tenant');

-- Insert data for authorities
INSERT INTO authorities (aut_id, authority_name)
VALUES (UUID(), 'READ'),
       (UUID(), 'WRITE');

-- Insert data for role_authority
INSERT INTO role_authority (role_id, authority_id)
VALUES ((SELECT r_id FROM roles LIMIT 1), (SELECT aut_id FROM authorities LIMIT 1)),
       ((SELECT r_id FROM roles LIMIT 1 OFFSET 1), (SELECT aut_id FROM authorities LIMIT 1 OFFSET 1));

-- Insert data for user_role

MERGE INTO user_role (user_id, role_id)
    KEY(user_id, role_id)
    VALUES ((SELECT u_id FROM users LIMIT 1), (SELECT r_id FROM roles LIMIT 1)),
    ((SELECT u_id FROM users LIMIT 1 OFFSET 1), (SELECT r_id FROM roles LIMIT 1 OFFSET 1));









