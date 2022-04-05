create table system_preference
(
    id int auto_increment,
    skey varchar(255) null,
    value varchar(255) null,
    description varchar(255) null,
    constraint system_preference_pk
        primary key (id)
);