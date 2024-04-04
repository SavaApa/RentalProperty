INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (UNHEX(REPLACE('5481891ddd4045f19844149e01f0c5bb', '-', '')), 3, 2, 1),
       (UNHEX(REPLACE('fdd80989fb3546968c654a7d141c23e1', '-', '')), 2, 1, 1);

INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (UNHEX(REPLACE('5481891ddd4045f19844149e01f0c5bb', '-', '')), 'Downtown', 2, 1500.00, true, false, 'Apartment'),
       (UNHEX(REPLACE('fdd80989fb3546968c654a7d141c23e1', '-', '')), 'Suburbia', 3, 2000.00, false, true, 'House');

INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), '123 Main St, Downtown', 1200.00, 'APARTMENT', 2, 'Downtown', true, false, UNHEX(REPLACE('5481891ddd4045f19844149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891ddd4045f19844149e01f0c5bb', '-', ''))),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), '456 Elm St, Suburbia', 1800.00, 'PRIVATE_HOUSE', 3, 'Suburbia', true, true, UNHEX(REPLACE('fdd80989fb3546968c654a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989fb3546968c654a7d141c23e1', '-', '')));

INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), '2024-03-15', 'ACCEPTED', UNHEX(REPLACE('5481891ddd4045f19844149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891ddd4045f19844149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891ddd4045f19844149e01f0c5bb', '-', ''))),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), '2024-03-20', 'REJECTED', UNHEX(REPLACE('fdd80989fb3546968c654a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989fb3546968c654a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989fb3546968c654a7d141c23e1', '-', '')));

INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), '2024-04-01', '2025-03-31', UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', ''))),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), '2024-04-05', '2025-04-04', UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')));

INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), 1200.00, '2024-04-01', 'PAID', UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', ''))),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), 1800.00, '2024-04-05', 'PAID', UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')));

INSERT INTO user_info (ui_id, email, password)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), 'landlord1@example.com', 'password123'),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), 'tenant1@example.com', 'password456');

INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), 'John', 'Doe', UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), NULL, UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', ''))),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), 'Jane', 'Smith', UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), NULL);

INSERT INTO roles (r_id, role_name)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), 'Landlord'),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), 'Tenant');

INSERT INTO authorities (aut_id, authority_name)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), 'READ'),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), 'WRITE');

INSERT INTO role_authority (role_id, authority_id)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', ''))),
       (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', ''))),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')));

INSERT INTO user_role (user_id, role_id)
VALUES (UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', '')), UNHEX(REPLACE('5481891d-dd40-45f1-9844-149e01f0c5bb', '-', ''))),
       (UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')), UNHEX(REPLACE('fdd80989-fb35-4696-8c65-4a7d141c23e1', '-', '')));




