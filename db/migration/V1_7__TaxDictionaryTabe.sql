create table tax_dictionary
(
    id int auto_increment,
    army_tax double null,
    income_tax double null,
    subsistence_level double null,
    date datetime null,
    constraint tax_dictionary_pk
        primary key (id)
);