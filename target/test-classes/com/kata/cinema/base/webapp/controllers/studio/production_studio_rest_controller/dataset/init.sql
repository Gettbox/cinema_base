insert into movies (id, countries, data_release, description, mpaa, name, original_name, rars, time)
values (100, 'США', '2009-12-10', 'описание фильма Аватар', 'GENERAL_AUDIENCES', 'Аватар', 'Avatar', 'ZERO_PLUS', 'time_value');

insert into production_studios (id, date_foundation, description, name)
values (100, '1935 г.', 'Описание 20th Century Studios', '20th Century Studios');

insert into studio_performances (id, name)
values (100, 'PERFORM_NAME');

insert into production_studio_movies (id, movies_id, studio_performances_id, production_studios_id)
values (100, 100, 100, 100);