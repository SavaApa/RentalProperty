CREATE TABLE IF NOT EXISTS landlords
(
    l_id         BINARY(16) PRIMARY KEY,
    num_property INT,
    rented_out   INT,
    num_free     INT
);

CREATE TABLE IF NOT EXISTS tenants
(
    t_id                BINARY(16) PRIMARY KEY,
    preference_district VARCHAR(255),
    preference_num_room INT,
    preference_max_rent DECIMAL,
    pet_friendly        BOOLEAN,
    parking_required    BOOLEAN,
    preference_property VARCHAR(255)
);

create table IF NOT EXISTS properties
(
    prop_id       BINARY(16) PRIMARY KEY,
    address       VARCHAR(255),
    price         DECIMAL,
    type_property VARCHAR(255),
    num_rooms     INT,
    district      VARCHAR(255),
    parking_space BOOLEAN,
    pets          BOOLEAN,
    landlord_id   BINARY(16),
    tenant_id     BINARY(16),
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id)
);



CREATE TABLE IF NOT EXISTS applications
(
    ap_id              BINARY(16) PRIMARY KEY,
    began_date         DATE,
    application_status VARCHAR(255),
    landlord_id        BINARY(16),
    property_id        BINARY(16),
    tenant_id          BINARY(16),
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id),
    FOREIGN KEY (property_id) REFERENCES properties (prop_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id)
);

CREATE TABLE IF NOT EXISTS contracts
(
    c_id           BINARY(16) PRIMARY KEY,
    start_date     DATE       NOT NULL,
    end_date       DATE       NOT NULL,
    application_id BINARY(16) NOT NULL,
    property_id    BINARY(16) NOT NULL,
    tenant_id      BINARY(16) NOT NULL,
    landlord_id    BINARY(16) NOT NULL,
    FOREIGN KEY (application_id) REFERENCES applications (ap_id),
    FOREIGN KEY (property_id) REFERENCES properties (prop_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id),
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id)
);

CREATE TABLE IF NOT EXISTS payments
(
    pay_id         BINARY(16) PRIMARY KEY,
    amount         DECIMAL      NOT NULL,
    payment_date   DATE         NOT NULL,
    payment_status VARCHAR(255) NOT NULL,
    contract_id    BINARY(16)   NOT NULL,
    FOREIGN KEY (contract_id) REFERENCES contracts (c_id)
);

CREATE TABLE IF NOT EXISTS user_info
(
    ui_id    BINARY(16) PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    u_id         BINARY(16) PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    user_info_id BINARY(16)   NOT NULL,
    tenant_id    BINARY(16),
    landlord_id  BINARY(16),
    FOREIGN KEY (user_info_id) REFERENCES user_info (ui_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id) ON DELETE SET NULL,
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS roles
(
    r_id      BINARY(16) PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities
(
    aut_id         BINARY(16) PRIMARY KEY,
    authority_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS role_authority
(
    role_id      BINARY(16) REFERENCES roles (r_id),
    authority_id BINARY(16) REFERENCES authorities (aut_id),
    PRIMARY KEY (role_id, authority_id),
    FOREIGN KEY (role_id) REFERENCES roles (r_id)
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id BINARY(16) NOT NULL,
    role_id BINARY(16) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (u_id),
    FOREIGN KEY (role_id) REFERENCES roles (r_id)

);
