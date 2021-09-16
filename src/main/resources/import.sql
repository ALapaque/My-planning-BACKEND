INSERT INTO authorities(id, name) VALUES (1, '*');
INSERT INTO roles(id, name) VALUES (1, 'ADMIN'),(2, 'USER'),(3, 'VIEWER');
INSERT INTO roles_has_authorities(id_role, id_authority) VALUES (1, 1), (2,1);
INSERT INTO cards(id, is_recap, size, type) VALUES (1, 1, 'TINY', 'APPOINTMENT'), (2, 1, 'TINY', 'MEETING'), (3, 0, 'GIANT', 'APPOINTMENT'), (4, 0, 'GIANT', 'MEETING');