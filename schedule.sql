CREATE TABLE schedules (
                           id int auto_increment primary key,
                           author varchar(255) not null ,
                           task varchar(255) not null ,
                           password varchar(255) not null ,
                           created_at datetime default current_timestamp,
                           updated_at datetime default current_timestamp on update current_timestamp);