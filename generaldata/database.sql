create table finance_info
(
    id int not null,
    student_id int not null
        primary key,
    inn varchar(11) not null,
    `grant` double null,
    constraint finance_info_id_uindex
        unique (id),
    constraint finance_info_inn_uindex
        unique (inn)
);

create table st_groups
(
    id int auto_increment
        primary key,
    group_name varchar(10) not null,
    constraint groups_group_name_uindex
        unique (group_name)
);

create table status
(
    id int auto_increment
        primary key,
    status enum('army', 'ordinary_student', 'halforphan', 'migrant', 'chernobyl', 'crypple', 'the_poor', 'orphan') not null,
    constraint status_status_uindex
        unique (status)
);

create table students
(
    id int auto_increment
        primary key,
    name varchar(15) not null,
    last_name varchar(20) not null,
    middle_name varchar(20) not null,
    group_id int null,
    st_status enum('army', 'ordinary_student', 'halforphan', 'migrant', 'chernobyl', 'crypple', 'the_poor', 'orphan') null,
    finance_id int null,
    constraint students_finance_info_id_fk
        foreign key (id) references finance_info (id),
    constraint students_groups_group_name_fk
        foreign key (group_id) references st_groups (id),
    constraint students_status_status_fk
        foreign key (st_status) references status (status)
);

alter table finance_info
    add constraint finance_info_students_id_fk
        foreign key (student_id) references students (id);

