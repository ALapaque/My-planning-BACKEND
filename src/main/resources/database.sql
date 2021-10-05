create table authorities
(
    id bigint auto_increment
        primary key,
    name varchar(60) null,
    constraint UK_nb3atvjf9ov5d0egnuk47o5e
        unique (name)
);

create table cards
(
    id bigint auto_increment
        primary key,
    is_recap bit not null,
    size varchar(255) null,
    type varchar(255) null
);

create table roles
(
    id bigint auto_increment
        primary key,
    name varchar(60) null,
    constraint UK_ofx66keruapi6vyqpv6f2or37
        unique (name)
);

create table roles_has_authorities
(
    id_role bigint not null,
    id_authority bigint not null,
    constraint FKcgy5jeehtlt2h25d1315u1p8f
        foreign key (id_authority) references authorities (id),
    constraint FKlp15i3fx1ftm3s7admn1algoc
        foreign key (id_role) references roles (id)
);

create table teams
(
    id bigint auto_increment
        primary key,
    name varchar(60) not null
);

create table users
(
    id bigint auto_increment
        primary key,
    created_at datetime null,
    updated_at datetime null,
    email varchar(40) null,
    first_name varchar(40) null,
    last_name varchar(40) null,
    organization varchar(100) null,
    password varchar(100) null,
    username varchar(100) null,
    id_role bigint null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (username),
    constraint FKt92dgi4412ywy3u8tm9jwdya5
        foreign key (id_role) references roles (id)
);

create table agendas
(
    id bigint auto_increment
        primary key,
    by_default bit null,
    color varchar(255) null,
    name varchar(60) null,
    id_team bigint null,
    id_user bigint null,
    constraint FKa61x80biityaj00swdr2yl4w2
        foreign key (id_team) references teams (id),
    constraint FKfnybo5c3atfrpqoj10ldyyhc9
        foreign key (id_user) references users (id)
);

create table events
(
    id bigint auto_increment
        primary key,
    created_at datetime null,
    updated_at datetime null,
    is_a_day_off bit not null,
    end_date datetime not null,
    event_type varchar(255) not null,
    meeting_url varchar(255) null,
    name varchar(255) not null,
    is_private bit not null,
    report longtext null,
    start_date datetime not null,
    status_displayed varchar(255) not null,
    id_agenda bigint null,
    constraint FKeaagvq3erkp787ffflft8wibb
        foreign key (id_agenda) references agendas (id)
);

create table agendas_has_shared_events
(
    id_event bigint not null,
    id_agenda bigint not null,
    constraint FK85k5tqtgkqjfysi6gommo35th
        foreign key (id_agenda) references agendas (id),
    constraint FKo8j2p2j7ynbtgain8a89ob0ii
        foreign key (id_event) references events (id)
);

create table comments
(
    id bigint auto_increment
        primary key,
    created_at datetime null,
    updated_at datetime null,
    content varchar(255) null,
    id_event bigint null,
    id_user bigint null,
    constraint FK2e1j871ildbkagpidsson8krk
        foreign key (id_user) references users (id),
    constraint FKe6dcp7ugmiuvcqof3q58xhuqi
        foreign key (id_event) references events (id)
);

create table teams_or_users_shared_agendas
(
    id_agenda bigint not null,
    id_user bigint null,
    id_team bigint null,
    constraint FKciakxdiff6qssqvaqx74xwosn
        foreign key (id_user) references users (id),
    constraint FKo8v482s9ra4kcnjg228lreemu
        foreign key (id_agenda) references agendas (id),
    constraint FKs4xmrb0ccicmr2iphmbbxpx9s
        foreign key (id_team) references teams (id)
);

create definer = root@localhost trigger tgr_team_or_user_not_null_BEFORE_INSERT
    before insert
    on teams_or_users_shared_agendas
    for each row
BEGIN

    IF NEW.id_user IS NULL AND NEW.id_team IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'id_user or id_team must not be NULL';
    ELSEIF NEW.id_user IS NOT NULL AND NEW.id_team IS NOT NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'id_user or id_team must be NULL';
    END IF;
END;

create definer = root@localhost trigger tgr_team_or_user_not_null_BEFORE_UPDATE
    before update
    on teams_or_users_shared_agendas
    for each row
BEGIN

    IF NEW.id_user IS NULL AND NEW.id_team IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'id_user or id_team must not be NULL';
    ELSEIF NEW.id_user IS NOT NULL AND NEW.id_team IS NOT NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'id_user or id_team must be NULL';
    END IF;
END;

create table users_has_cards
(
    id_user bigint not null,
    id_card bigint not null,
    constraint FKd32niudrmkekv0ry8sysr11p1
        foreign key (id_user) references users (id),
    constraint FKj4k5h3p7s1uowj4ou61smrlqy
        foreign key (id_card) references cards (id)
);

create table users_has_teams
(
    id_user bigint not null,
    id_team bigint not null,
    constraint FKjkqq1doy1g8xiuqgmrwmvhxjl
        foreign key (id_team) references teams (id),
    constraint FKpoxytxw9tbt4n1txo8d3jao17
        foreign key (id_user) references users (id)
);

