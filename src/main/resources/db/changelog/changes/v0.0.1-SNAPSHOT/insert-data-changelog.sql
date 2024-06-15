INSERT INTO roles (r_id, role_name)
VALUES (UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'), 'TENANT');

INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18'), 3, 2, 1);

INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979'), 'Downtown', 2, 1500.00, true, false, 'APARTMENT');

INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (UUID_TO_BIN('d80d88a6-2d5e-4da3-9407-010287fc7c0a'), '123 Main St, Downtown', 1200.00, 'APARTMENT', 2, 'Downtown', true, false, UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18'), UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979'));

INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (UUID_TO_BIN('3a9d3f69-2dde-4cf6-bce2-9594b273cf41'), '2024-03-15', 'ACCEPTED', UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18'), UUID_TO_BIN('d80d88a6-2d5e-4da3-9407-010287fc7c0a'), UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979'));

INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (UUID_TO_BIN('7e4ab44b-2ef3-46ef-ac38-c00fa7ad36cd'), '2024-04-01', '2025-03-31', UUID_TO_BIN('3a9d3f69-2dde-4cf6-bce2-9594b273cf41'), UUID_TO_BIN('d80d88a6-2d5e-4da3-9407-010287fc7c0a'), UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979'), UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18'));

INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (UUID_TO_BIN('c14f6009-46d4-40b6-8671-7d7a4e5db206'), 1200.00, '2024-04-01', 'PAID', UUID_TO_BIN('7e4ab44b-2ef3-46ef-ac38-c00fa7ad36cd'));

INSERT INTO user_info (ui_id, user_name, email, password, user_id)
VALUES (UUID_TO_BIN('915ffd16-3eaa-4faf-b4fe-52a59ac040aa'), 'tenant', 'tenant1@example.com', '$2a$12$SL4/YvVvek34tEMIyLE4YechMwFcrESrQnELltzzhHpBleXU8oyq6', UUID_TO_BIN('590f1736-3040-4827-9847-e4160678671b'));

INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id, role_id)
VALUES (UUID_TO_BIN('590f1736-3040-4827-9847-e4160678671b'), 'John', 'Doe', UUID_TO_BIN('915ffd16-3eaa-4faf-b4fe-52a59ac040aa'), UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979'), NULL, UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'));

INSERT INTO authorities (aut_id, authority_name, role_id, user_id)
VALUES (UUID_TO_BIN('d230360d-b081-47a2-96e8-ddbd54b70219'), 'TENANT', UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'), UUID_TO_BIN('590f1736-3040-4827-9847-e4160678671b'));

INSERT INTO user_info_role (user_info_id, role_id)
VALUES (UUID_TO_BIN('915ffd16-3eaa-4faf-b4fe-52a59ac040aa'), UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'));

INSERT INTO role_authority (role_id, auth_id)
VALUES (UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'), UUID_TO_BIN('d230360d-b081-47a2-96e8-ddbd54b70219'));

