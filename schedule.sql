CREATE TABLE schedules (
    id int auto_increment primary key,
    author varchar(255) not null ,
    task varchar(255) not null ,
    password varchar(255) not null ,
    created_at datetime not null ,
    changed_at datetime not null );

alter table schedules modify column changed_at datetime default current_timestamp on update current_timestamp;la
ㅁㅁ
desc schedules;
tla