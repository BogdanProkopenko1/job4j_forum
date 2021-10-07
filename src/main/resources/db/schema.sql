create table posts(
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now()
);

create table comments(
    id serial primary key,
    message text,
    created timestamp without time zone not null default now()
);

create table posts_comments(
    post_id int references posts(id),
    comments_id int references comments(id)
);