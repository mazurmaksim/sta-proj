create table student_grants
(
    id         int auto_increment
        primary key,
    april      double      null,
    august     double      null,
    get_date   datetime(6) null,
    december   double      null,
    february   double      null,
    january    double      null,
    july       double      null,
    june       double      null,
    march      double      null,
    may        double      null,
    november   double      null,
    october    double      null,
    september  double      null,
    year       int         null,
    student_id int         not null,
    constraint grant_by_date_index
        foreign key (student_id) references students (id)
);

