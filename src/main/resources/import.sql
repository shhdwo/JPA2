insert into profile (created_at, updated_at, version, about_me, life_motto, name, surname) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1,  'bla', 'bla bla', 'Garri', 'Kasparow');
insert into profile (created_at, updated_at, version, about_me, life_motto, name, surname) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1,  'bla', 'bla bla', 'Magnus', 'Carlsen');

insert into statistics (created_at, updated_at, version, games_drawn, games_lost, games_won, level, points) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1, 1, 2, 20, 2, 600);
insert into statistics (created_at, updated_at, version, games_drawn, games_lost, games_won, level, points) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1, 1, 2, 18, 2, 301);

insert into user (created_at, updated_at, version, email, password, profile_id, statistics_id) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1, 'email@example.com', '1234567890', 1, 1);
insert into user (created_at, updated_at, version, email, password, profile_id, statistics_id) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1, 'bla@example.com', '1234567890', 2, 2);

insert into matches (created_at, updated_at, version, points1, points2, result, player1_id, player2_id) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1, 0, 0, 2, 1, 2);
insert into matches (created_at, updated_at, version, points1, points2, result, player1_id, player2_id) values ('2017-03-28 00:00:00', '2017-03-28 00:00:00', 1, 0, 0, 2, 2, 1);