INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18'), 3, 2, 1),
       (UUID_TO_BIN('7fcbff56-9b94-45ed-b7bd-4af5b1d63fbe'), 2, 1, 1);

INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979'), 'Downtown', 2, 1500.00, true, false, 'APARTMENT'),
       (UUID_TO_BIN('bb49bdc2-4d9b-4016-ba0a-b0016d1dd575'), 'Suburbia', 3, 2000.00, false, true, 'OFFICE');

INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (UUID_TO_BIN('d80d88a6-2d5e-4da3-9407-010287fc7c0a'), '123 Main St, Downtown', 1200.00, 'APARTMENT', 2, 'Downtown', true, false, UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18'), UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979')),
       (UUID_TO_BIN('1bf8cdbc-e5ba-4bed-ae53-4b4ce62b9a52'), '456 Elm St, Suburbia', 1800.00, 'OFFICE', 3, 'Suburbia', true, true, UUID_TO_BIN('7fcbff56-9b94-45ed-b7bd-4af5b1d63fbe'), UUID_TO_BIN('bb49bdc2-4d9b-4016-ba0a-b0016d1dd575'));

INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (UUID_TO_BIN('3a9d3f69-2dde-4cf6-bce2-9594b273cf41'), '2024-03-15', 'ACCEPTED', UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18'), UUID_TO_BIN('d80d88a6-2d5e-4da3-9407-010287fc7c0a'), UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979')),
       (UUID_TO_BIN('c13496f3-0029-459c-8866-255c92e941d2'), '2024-03-20', 'REJECTED', UUID_TO_BIN('7fcbff56-9b94-45ed-b7bd-4af5b1d63fbe'), UUID_TO_BIN('1bf8cdbc-e5ba-4bed-ae53-4b4ce62b9a52'), UUID_TO_BIN('bb49bdc2-4d9b-4016-ba0a-b0016d1dd575'));

INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (UUID_TO_BIN('7e4ab44b-2ef3-46ef-ac38-c00fa7ad36cd'), '2024-04-01', '2025-03-31', UUID_TO_BIN('3a9d3f69-2dde-4cf6-bce2-9594b273cf41'), UUID_TO_BIN('d80d88a6-2d5e-4da3-9407-010287fc7c0a'), UUID_TO_BIN('193e4a81-38c8-4f18-bdf7-590205283979'), UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18')),
       (UUID_TO_BIN('16cd2838-13e7-49a0-87ed-bcd53f27fb79'), '2024-04-05', '2025-04-04', UUID_TO_BIN('c13496f3-0029-459c-8866-255c92e941d2'), UUID_TO_BIN('1bf8cdbc-e5ba-4bed-ae53-4b4ce62b9a52'), UUID_TO_BIN('bb49bdc2-4d9b-4016-ba0a-b0016d1dd575'), UUID_TO_BIN('7fcbff56-9b94-45ed-b7bd-4af5b1d63fbe'));

INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (UUID_TO_BIN('c14f6009-46d4-40b6-8671-7d7a4e5db206'), 1200.00, '2024-04-01', 'PAID', UUID_TO_BIN('7e4ab44b-2ef3-46ef-ac38-c00fa7ad36cd')),
       (UUID_TO_BIN('7c378635-0f41-4a23-97d1-1f02459b161a'), 1800.00, '2024-04-05', 'PAID', UUID_TO_BIN('16cd2838-13e7-49a0-87ed-bcd53f27fb79'));

INSERT INTO user_info (ui_id, user_name, email, password)
VALUES (UUID_TO_BIN('915ffd16-3eaa-4faf-b4fe-52a59ac040aa'), 'John123', 'landlord1@example.com', 'password123'),
       (UUID_TO_BIN('ab587544-2567-48b0-9b15-a7f178071fde'),'Jane231', 'tenant1@example.com', 'password456');

INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id)
VALUES (UUID_TO_BIN('590f1736-3040-4827-9847-e4160678671b'), 'John', 'Doe', UUID_TO_BIN('915ffd16-3eaa-4faf-b4fe-52a59ac040aa'), NULL, UUID_TO_BIN('e8240961-836b-43cc-948c-4fb4d2cbcb18')),
       (UUID_TO_BIN('654cc27a-1082-4e64-86b9-93003c5d2ad2'), 'Jane', 'Smith', UUID_TO_BIN('ab587544-2567-48b0-9b15-a7f178071fde'), UUID_TO_BIN('bb49bdc2-4d9b-4016-ba0a-b0016d1dd575'), NULL);

INSERT INTO roles (r_id, role_name)
VALUES (UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'), 'Landlord'),
       (UUID_TO_BIN('dcb27f3b-e76e-4781-9f9f-6ab6f9964c23'), 'Tenant');

INSERT INTO authorities (aut_id, authority_name)
VALUES (UUID_TO_BIN('d230360d-b081-47a2-96e8-ddbd54b70219'), 'READ'),
       (UUID_TO_BIN('85a9805e-573e-4648-b4e0-b6216d2d88aa'), 'WRITE');

INSERT INTO role_authority (role_id, authority_id)
VALUES (UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'), UUID_TO_BIN('d230360d-b081-47a2-96e8-ddbd54b70219')),
       (UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2'), UUID_TO_BIN('85a9805e-573e-4648-b4e0-b6216d2d88aa')),
       (UUID_TO_BIN('dcb27f3b-e76e-4781-9f9f-6ab6f9964c23'), UUID_TO_BIN('d230360d-b081-47a2-96e8-ddbd54b70219'));


INSERT INTO user_role (user_id, role_id)
VALUES (UUID_TO_BIN('590f1736-3040-4827-9847-e4160678671b'), UUID_TO_BIN('afed4fbe-b75c-497c-ad63-b76b7b837ae2')),
       (UUID_TO_BIN('654cc27a-1082-4e64-86b9-93003c5d2ad2'), UUID_TO_BIN('dcb27f3b-e76e-4781-9f9f-6ab6f9964c23'));





