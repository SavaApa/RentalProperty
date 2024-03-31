INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (1, 3, 2, 1),
       (2, 2, 1, 1);

INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (1, 'Downtown', 2, 1500.00, true, false, 'Apartment'),
       (2, 'Suburbia', 3, 2000.00, false, true, 'House');

INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (1, '123 Main St, Downtown', 1200.00, 'Apartment', 2, 'Downtown', true, false, 1, 1),
       (2, '456 Elm St, Suburbia', 1800.00, 'House', 3, 'Suburbia', true, true, 2, 2);

INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (1, '2024-03-15', 'ACCEPTED', 1, 1, 1),
       (2, '2024-03-20', 'REJECTED', 2, 2, 2);

INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (1, '2024-04-01', '2025-03-31', 1, 1, 1, 1),
       (2, '2024-04-05', '2025-04-04', 2, 2, 2, 2);

INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (1, 1200.00, '2024-04-01', 'PAID', 1),
       (2, 1800.00, '2024-04-05', 'PAID', 2);

INSERT INTO user_info (ui_id, email, password)
VALUES (1, 'landlord1@example.com', 'password123'),
       (2, 'tenant1@example.com', 'password456');

INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id)
VALUES (1, 'John', 'Doe', 1, NULL, 1),
       (2, 'Jane', 'Smith', 2, 1, NULL);

INSERT INTO roles (r_id, role_name)
VALUES (1, 'Landlord'),
       (2, 'Tenant');

INSERT INTO authorities (aut_id, authority_name)
VALUES (1, 'READ'),
       (2, 'WRITE');

INSERT INTO role_authority (role_id, authority_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (2, 2);
