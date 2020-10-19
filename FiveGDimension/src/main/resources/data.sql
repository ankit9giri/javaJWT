insert ignore into users (id, username, email, password, role)
values (1, 'admin', 'admin@admin.com', 'admin', '{ROLE_ADMIN}');

insert ignore into roles (id, role_name)
values (1, 'ROLE_ADMIN');

insert ignore into roles (id, role_name)
values (2, 'ROLE_USER');

