INSERT INTO roles (r_id, role_name)
VALUES (X'afed4fbeb75c497cad63b76b7b837ae2', 'ROLE_TENANT');

INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (X'e8240961836b43cc948c4fb4d2cbcb18', 3, 2, 1);

INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (X'193e4a8138c84f18bdf7590205283979', 'Downtown', 2, 1500.00, true, false, 'APARTMENT');

INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (X'd80d88a62d5e4da39407010287fc7c0a', '123 Main St, Downtown', 1200.00, 'APARTMENT', 2, 'Downtown', true, false, X'e8240961836b43cc948c4fb4d2cbcb18', X'193e4a8138c84f18bdf7590205283979');

INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (X'3a9d3f692dde4cf6bce29594b273cf41', '2024-03-15', 'ACCEPTED', X'e8240961836b43cc948c4fb4d2cbcb18', X'd80d88a62d5e4da39407010287fc7c0a', X'193e4a8138c84f18bdf7590205283979');

INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (X'7e4ab44b2ef346efac38c00fa7ad36cd', '2024-04-01', '2025-03-31', X'3a9d3f692dde4cf6bce29594b273cf41', X'd80d88a62d5e4da39407010287fc7c0a', X'193e4a8138c84f18bdf7590205283979', X'e8240961836b43cc948c4fb4d2cbcb18');

INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (X'c14f600946d440b686717d7a4e5db206', 1200.00, '2024-04-01', 'PAID', X'7e4ab44b2ef346efac38c00fa7ad36cd');

INSERT INTO user_info (ui_id, user_name, email, password)
VALUES (X'915ffd163eaa4fafb4fe52a59ac040aa', 'tenant', 'tenant1@example.com', '$2a$12$SL4/YvVvek34tEMIyLE4YechMwFcrESrQnELltzzhHpBleXU8oyq6');

INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id)
VALUES (X'590f1736304048279847e4160678671b', 'John', 'Doe', X'915ffd163eaa4fafb4fe52a59ac040aa', X'193e4a8138c84f18bdf7590205283979', NULL);

INSERT INTO authorities (aut_id, authority_name)
VALUES (X'd230360db08147a296e8ddbd54b70219', 'GET');

INSERT INTO user_info_role (user_info_id, role_id)
VALUES (X'915ffd163eaa4fafb4fe52a59ac040aa', X'afed4fbeb75c497cad63b76b7b837ae2');

INSERT INTO role_authority (role_id, auth_id)
VALUES (X'afed4fbeb75c497cad63b76b7b837ae2', X'd230360db08147a296e8ddbd54b70219');

