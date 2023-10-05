create database games;
use games;
create table Games_Features(
    response_name varchar(60),
    release_date varchar(10),
    metacritic int,
    recommendation_count int,
    is_free char(5),
    genre_is_non_game char(5),
    genre_is_indie char(5),
    genre_is_action char(5),
    genre_is_adventure char(5),
    genre_is_casual char(5),
    genre_is_strategy char(5),
    genre_is_rpg char(5),
    genre_is_simulation char(5),
    genre_is_early_access char(5),
    genre_is_free_to_play char(5),
    genre_is_sports char(5),
    genre_is_racing char(5),
    genre_is_massively_multiplayer char(5),
    price_initial float,
    cod int primary key auto_increment
);

-- drop table Games_Features ;

load data local INFILE "/home/jpthimt/Downloads/steamgames/games-features-edit.csv"
into table Games_Features
FIELDS TERMINATED by ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';