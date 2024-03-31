CREATE TABLE IF NOT EXISTS landlords
(
    l_id         INT PRIMARY KEY,
    num_property INT NOT NULL,
    rented_out   INT NOT NULL,
    num_free     INT NOT NULL
);

CREATE TABLE IF NOT EXISTS tenants
(
    t_id                INT PRIMARY KEY,
    preference_district VARCHAR(255) NOT NULL,
    preference_num_room INT          NOT NULL,
    preference_max_rent DECIMAL      NOT NULL,
    pet_friendly        BOOLEAN      NOT NULL,
    parking_required    BOOLEAN      NOT NULL,
    preference_property VARCHAR(255) NOT NULL
);

create table properties
(
    prop_id       INT PRIMARY KEY,
    address       VARCHAR(255) NOT NULL,
    price         DECIMAL      NOT NULL,
    type_property VARCHAR(255) NOT NULL,
    num_rooms     INT          NOT NULL,
    district      VARCHAR(255) NOT NULL,
    parking_space BOOLEAN      NOT NULL,
    pets          BOOLEAN      NOT NULL,
    landlord_id   INT          NOT NULL,
    tenant_id     INT          NOT NULL,
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id)
);



CREATE TABLE IF NOT EXISTS applications
(
    ap_id              INT PRIMARY KEY,
    began_date         DATE         NOT NULL,
    application_status VARCHAR(255) NOT NULL,
    landlord_id        INT          NOT NULL,
    property_id        INT          NOT NULL,
    tenant_id          INT          NOT NULL,
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id),
    FOREIGN KEY (property_id) REFERENCES properties (prop_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id)
);

CREATE TABLE IF NOT EXISTS contracts
(
    c_id           INT PRIMARY KEY,
    start_date     DATE NOT NULL,
    end_date       DATE NOT NULL,
    application_id INT  NOT NULL,
    property_id    INT  NOT NULL,
    tenant_id      INT  NOT NULL,
    landlord_id    INT  NOT NULL,
    FOREIGN KEY (application_id) REFERENCES applications (ap_id),
    FOREIGN KEY (property_id) REFERENCES properties (prop_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id),
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id)
);

CREATE TABLE IF NOT EXISTS payments
(
    pay_id         INT PRIMARY KEY,
    amount         DECIMAL      NOT NULL,
    payment_date   DATE         NOT NULL,
    payment_status VARCHAR(255) NOT NULL,
    contract_id    INT          NOT NULL,
    FOREIGN KEY (contract_id) REFERENCES contracts (c_id)
);

CREATE TABLE IF NOT EXISTS user_info
(
    ui_id    INT PRIMARY KEY,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    u_id         INT PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    user_info_id INT          NOT NULL,
    tenant_id    INT,
    landlord_id  INT,
    FOREIGN KEY (user_info_id) REFERENCES user_info (ui_id),
    FOREIGN KEY (tenant_id) REFERENCES tenants (t_id),
    FOREIGN KEY (landlord_id) REFERENCES landlords (l_id)
);

CREATE TABLE IF NOT EXISTS roles
(
    r_id      INT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities
(
    aut_id         INT PRIMARY KEY,
    authority_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS role_authority
(
    role_id      INT REFERENCES roles (r_id),
    authority_id INT REFERENCES authorities (aut_id),
    PRIMARY KEY (role_id, authority_id),
    FOREIGN KEY (role_id) REFERENCES roles (r_id)
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (u_id),
    FOREIGN KEY (role_id) REFERENCES roles (r_id)

);
