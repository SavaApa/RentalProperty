INSERT INTO landlords (l_id, num_property, rented_out, num_free)
VALUES (X'e8240961836b43cc948c4fb4d2cbcb18', 3, 2, 1),
       (X'7fcbff569b9445edb7bd4af5b1d63fbe', 2, 1, 1);

INSERT INTO tenants (t_id, preference_district, preference_num_room, preference_max_rent, pet_friendly,
                     parking_required, preference_property)
VALUES (X'193e4a8138c84f18bdf7590205283979', 'Downtown', 2, 1500.00, TRUE, FALSE, 'APARTMENT'),
       (X'bb49bdc24d9b4016ba0ab0016d1dd575', 'Suburbia', 3, 2000.00, FALSE, TRUE, 'OFFICE');

INSERT INTO properties (prop_id, address, price, type_property, num_rooms, district, parking_space, pets, landlord_id,
                        tenant_id)
VALUES (X'd80d88a62d5e4da39407010287fc7c0a', '123 Main St, Downtown', 1200.00, 'APARTMENT', 2, 'Downtown', TRUE, FALSE,
        X'e8240961836b43cc948c4fb4d2cbcb18', X'193e4a8138c84f18bdf7590205283979'),
       (X'1bf8cdbce5ba4bedae534b4ce62b9a52', '456 Elm St, Suburbia', 1800.00, 'OFFICE', 3, 'Suburbia', TRUE, TRUE,
        X'7fcbff569b9445edb7bd4af5b1d63fbe', X'bb49bdc24d9b4016ba0ab0016d1dd575');

INSERT INTO applications (ap_id, began_date, application_status, landlord_id, property_id, tenant_id)
VALUES (X'3a9d3f692dde4cf6bce29594b273cf41', '2024-03-15', 'ACCEPTED', X'e8240961836b43cc948c4fb4d2cbcb18',
        X'd80d88a62d5e4da39407010287fc7c0a', X'193e4a8138c84f18bdf7590205283979'),
       (X'c13496f30029459c8866255c92e941d2', '2024-03-20', 'REJECTED', X'7fcbff569b9445edb7bd4af5b1d63fbe',
        X'1bf8cdbce5ba4bedae534b4ce62b9a52', X'bb49bdc24d9b4016ba0ab0016d1dd575');

INSERT INTO contracts (c_id, start_date, end_date, application_id, property_id, tenant_id, landlord_id)
VALUES (X'7e4ab44b2ef346efac38c00fa7ad36cd', '2024-04-01', '2025-03-31', X'3a9d3f692dde4cf6bce29594b273cf41',
        X'd80d88a62d5e4da39407010287fc7c0a', X'193e4a8138c84f18bdf7590205283979', X'e8240961836b43cc948c4fb4d2cbcb18'),
       (X'16cd283813e749a087edbcd53f27fb79', '2024-04-05', '2025-04-04', X'c13496f30029459c8866255c92e941d2',
        X'1bf8cdbce5ba4bedae534b4ce62b9a52', X'bb49bdc24d9b4016ba0ab0016d1dd575', X'7fcbff569b9445edb7bd4af5b1d63fbe');

INSERT INTO payments (pay_id, amount, payment_date, payment_status, contract_id)
VALUES (X'c14f600946d440b686717d7a4e5db206', 1200.00, '2024-04-01', 'PAID', X'7e4ab44b2ef346efac38c00fa7ad36cd'),
       (X'7c3786350f414a2397d11f02459b161a', 1800.00, '2024-04-05', 'PAID', X'16cd283813e749a087edbcd53f27fb79');

INSERT INTO user_info (ui_id, user_name, email, password)
VALUES (X'915ffd163eaa4fafb4fe52a59ac040aa', 'John123', 'landlord1@example.com', 'password123'),
       (X'ab587544256748b09b15a7f178071fde', 'Jane231', 'tenant1@example.com', 'password456');

INSERT INTO users (u_id, first_name, last_name, user_info_id, tenant_id, landlord_id)
VALUES (X'590f1736304048279847e4160678671b', 'John', 'Doe', X'915ffd163eaa4fafb4fe52a59ac040aa', NULL,
        X'e8240961836b43cc948c4fb4d2cbcb18'),
       (X'654cc27a10824e6486b993003c5d2ad2', 'Jane', 'Smith', X'ab587544256748b09b15a7f178071fde',
        X'bb49bdc24d9b4016ba0ab0016d1dd575', NULL);

INSERT INTO roles (r_id, role_name)
VALUES (X'afed4fbeb75c497cad63b76b7b837ae2', 'Landlord'),
       (X'dcb27f3be76e47819f9f6ab6f9964c23', 'Tenant');

INSERT INTO authorities (aut_id, authority_name)
VALUES (X'd230360db08147a296e8ddbd54b70219', 'READ'),
       (X'85a9805e573e4648b4e0b6216d2d88aa', 'WRITE');

INSERT INTO role_authority (role_id, authority_id)
VALUES (X'afed4fbeb75c497cad63b76b7b837ae2', X'd230360db08147a296e8ddbd54b70219'),
       (X'afed4fbeb75c497cad63b76b7b837ae2', X'85a9805e573e4648b4e0b6216d2d88aa'),
       (X'dcb27f3be76e47819f9f6ab6f9964c23', X'd230360db08147a296e8ddbd54b70219');

INSERT INTO user_role (user_id, role_id)
VALUES (X'590f1736304048279847e4160678671b', X'afed4fbeb75c497cad63b76b7b837ae2'),
       (X'654cc27a10824e6486b993003c5d2ad2', X'dcb27f3be76e47819f9f6ab6f9964c23');

