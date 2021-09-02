INSERT INTO authorities(id, name)
VALUES (1, '*');
INSERT INTO roles(id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'VIEWER');
INSERT INTO roles_has_authorities(id_role, id_authority)
VALUES (1, 1),
       (2, 1);
INSERT INTO cards(id, is_recap, size, type)
VALUES (1, 1, 'tiny', 'APPOINTMENT'),
       (2, 1, 'tiny', 'MEETING'),
       (3, 0, 'giant', 'APPOINTMENT'),
       (4, 0, 'giant', 'MEETING');
INSERT INTO users(id, created_at, updated_at, email, first_name, last_name, password, username, id_role)
VALUES (1, null, null, 'admin.myplanning@gmail.com', 'Administrateur', 'myPlanning',
        '$2a$10$vffSrvmJqAGoqrGj9M2E1eaAA6yrZVPe1T0VZ2JtpSD5WpLD3zLMm', 'Admin', 1),
       (2, null, null, 'amaury.lapaque@gmail.com', 'Amaury', 'Lapaque',
        '$2a$10$vffSrvmJqAGoqrGj9M2E1eaAA6yrZVPe1T0VZ2JtpSD5WpLD3zLMm', 'amaury.lapaque', 1);
INSERT INTO agendas(id, name, color, id_team, id_user)
VALUES (1, '#ffffff', 'Agenda par défaut', 1, 1),
       (2, '#ffffff', 'Agenda par défaut', 1, 2);
INSERT INTO teams(id, name)
VALUES (1, 'My team');
INSERT INTO teams_or_users_shared_agendas(id_agenda, id_user, id_team)
VALUES (1, 2, 1),
       (2, 1, 1);
INSERT INTO users_has_cards(id_user, id_card)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4);