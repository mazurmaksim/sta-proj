create table `groups`
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
    st_group varchar(10) null,
    st_status enum('army', 'ordinary_student', 'halforphan', 'migrant', 'chernobyl', 'crypple', 'the_poor', 'orphan') null,
    constraint students_groups_group_name_fk
        foreign key (st_group) references `groups` (group_name),
    constraint students_status_status_fk
        foreign key (st_status) references status (status)
);

create table finance_info
(
    studentId int not null,
    inn varchar(8) not null,
    `grant` double null,
    constraint finance_info_id_uindex
        unique (studentId),
    constraint finance_info_inn_uindex
        unique (inn),
    constraint finance_info_students_id_fk
        foreign key (studentId) references students (id)
);

alter table finance_info
    add primary key (studentId);

