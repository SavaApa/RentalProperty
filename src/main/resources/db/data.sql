INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (UNHEX('e8240961836b43cc948c4fb4d2cbcb18'), 3, 2, 1),
       (UNHEX('7fcbff569b9445edb7bd4af5b1d63fbe'), 2, 1, 1);

INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (UNHEX('193e4a8138c84f18bdf7590205283979'), 'Downtown', 2, 1500.00, true, false, 'APARTMENT'),
       (UNHEX('bb49bdc24d9b4016ba0ab0016d1dd575'), 'Suburbia', 3, 2000.00, false, true, 'OFFICE');

INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (UNHEX('d80d88a62d5e4da39407010287fc7c0a'), '123 Main St, Downtown', 1200.00, 'APARTMENT', 2, 'Downtown', true, false, UNHEX('e8240961836b43cc948c4fb4d2cbcb18'), UNHEX('193e4a8138c84f18bdf7590205283979')),
       (UNHEX('1bf8cdbce5ba4bedae534b4ce62b9a52'), '456 Elm St, Suburbia', 1800.00, 'OFFICE', 3, 'Suburbia', true, true, UNHEX('7fcbff569b9445edb7bd4af5b1d63fbe'), UNHEX('bb49bdc24d9b4016ba0ab0016d1dd575'));

INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (UNHEX('3a9d3f692dde4cf6bce29594b273cf41'), '2024-03-15', 'ACCEPTED', UNHEX('e8240961836b43cc948c4fb4d2cbcb18'), UNHEX('d80d88a62d5e4da39407010287fc7c0a'), UNHEX('193e4a8138c84f18bdf7590205283979')),
       (UNHEX('c13496f30029459c8866255c92e941d2'), '2024-03-20', 'REJECTED', UNHEX('7fcbff569b9445edb7bd4af5b1d63fbe'), UNHEX('1bf8cdbce5ba4bedae534b4ce62b9a52'), UNHEX('bb49bdc24d9b4016ba0ab0016d1dd575'));

INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (UNHEX('7e4ab44b2ef346efac38c00fa7ad36cd'), '2024-04-01', '2025-03-31', UNHEX('3a9d3f692dde4cf6bce29594b273cf41'), UNHEX('d80d88a62d5e4da39407010287fc7c0a'), UNHEX('193e4a8138c84f18bdf7590205283979'), UNHEX('e8240961836b43cc948c4fb4d2cbcb18')),
       (UNHEX('16cd283813e749a087edbcd53f27fb79'), '2024-04-05', '2025-04-04', UNHEX('c13496f30029459c8866255c92e941d2'), UNHEX('1bf8cdbce5ba4bedae534b4ce62b9a52'), UNHEX('bb49bdc24d9b4016ba0ab0016d1dd575'), UNHEX('7fcbff569b9445edb7bd4af5b1d63fbe'));

INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (UNHEX('c14f600946d440b686717d7a4e5db206'), 1200.00, '2024-04-01', 'PAID', UNHEX('7e4ab44b2ef346efac38c00fa7ad36cd')),
       (UNHEX('7c3786350f414a2397d11f02459b161a'), 1800.00, '2024-04-05', 'PAID', UNHEX('16cd283813e749a087edbcd53f27fb79'));

INSERT INTO user_info (ui_id, email, password)
VALUES (UNHEX('915ffd163eaa4fafb4fe52a59ac040aa'), 'landlord1@example.com', 'password123'),
       (UNHEX('ab587544256748b09b15a7f178071fde'), 'tenant1@example.com', 'password456');

INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id)
VALUES (UNHEX('590f1736304048279847e4160678671b'), 'John', 'Doe', UNHEX('915ffd163eaa4fafb4fe52a59ac040aa'), NULL, UNHEX('e8240961836b43cc948c4fb4d2cbcb18')),
       (UNHEX('654cc27a10824e6486b993003c5d2ad2'), 'Jane', 'Smith', UNHEX('ab587544256748b09b15a7f178071fde'), UNHEX('bb49bdc24d9b4016ba0ab0016d1dd575'), NULL);

INSERT INTO roles (r_id, role_name)
VALUES (UNHEX('afed4fbeb75c497cad63b76b7b837ae2'), 'Landlord'),
       (UNHEX('dcb27f3be76e47819f9f6ab6f9964c23'), 'Tenant');

INSERT INTO authorities (aut_id, authority_name)
VALUES (UNHEX('d230360db08147a296e8ddbd54b70219'), 'READ'),
       (UNHEX('85a9805e573e4648b4e0b6216d2d88aa'), 'WRITE');

INSERT INTO role_authority (role_id, authority_id)
VALUES (UNHEX('afed4fbeb75c497cad63b76b7b837ae2'), UNHEX('d230360db08147a296e8ddbd54b70219')),
       (UNHEX('afed4fbeb75c497cad63b76b7b837ae2'), UNHEX('85a9805e573e4648b4e0b6216d2d88aa')),
       (UNHEX('dcb27f3be76e47819f9f6ab6f9964c23'), UNHEX('d230360db08147a296e8ddbd54b70219'));

INSERT INTO user_role (user_id, role_id)
VALUES (UNHEX('590f1736304048279847e4160678671b'), UNHEX('afed4fbeb75c497cad63b76b7b837ae2')),
       (UNHEX('654cc27a10824e6486b993003c5d2ad2'), UNHEX('dcb27f3be76e47819f9f6ab6f9964c23'));




