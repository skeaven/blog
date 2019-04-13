create database blog;
use blog;
create table article
(
	article_id varchar(32) not null,
	title varchar(200) not null,
	label varchar(100) null,
	create_time long not null,
	update_time long not null,
	author varchar(100) null,
	preview varchar(150) null
);

create unique index article_article_id_uindex
	on article (article_id);

alter table article
	add constraint article_pk
		primary key (article_id);

