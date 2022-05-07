
INSERT INTO kurss.cursovaya.age_limits (id, year) VALUES (1, 0);
INSERT INTO kurss.cursovaya.age_limits (id, year) VALUES (2, 6);
INSERT INTO kurss.cursovaya.age_limits (id, year) VALUES (3, 12);
INSERT INTO kurss.cursovaya.genres (id, name, imagesg_id) VALUES (1, 'Аркада', 1);
INSERT INTO kurss.cursovaya.genres (id, name, imagesg_id) VALUES (2, 'Экшон', 2);
INSERT INTO kurss.cursovaya.genres (id, name, imagesg_id) VALUES (3, 'Приключения', 3);
INSERT INTO kurss.cursovaya.genres (id, name, imagesg_id) VALUES (4, 'Файтинг', 4);
INSERT INTO kurss.cursovaya.genres (id, name, imagesg_id) VALUES (5, 'Стратегии', 5);
INSERT INTO kurss.cursovaya.languages (id, name) VALUES (4, 'Japanese');
INSERT INTO kurss.cursovaya.languages (id, name) VALUES (1, 'Russian');
INSERT INTO kurss.cursovaya.languages (id, name) VALUES (3, 'Chinese');
INSERT INTO kurss.cursovaya.languages (id, name) VALUES (2, 'Huinglish');
INSERT INTO kurss.cursovaya.publishers (id, name) VALUES (1, 'EA');
INSERT INTO kurss.cursovaya.publishers (id, name) VALUES (2, 'Wargaming');
INSERT INTO kurss.cursovaya.publishers (id, name) VALUES (3, 'Blizard');

INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (4, '1', 'check this it ', 'фыва', 'Производитель', 'sony', '102,8 млн', '15 ноября f', 'ffff', 4);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (5, '1', 'check this it ', 'фыва', 'Производитель', 'gameboy', '102,8 млн', '15 ноября f', 'ffff', 5);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (6, '1', 'check this it ', 'фыва', 'nintendo', 'NES', '102,8 млн', '15 ноября f', 'ffff', 6);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (7, 'AMD APU 1,6 ГГц (8 ядер) x86-64 архитектура', 'dis', 'фыва', 'Производитель', 'Atari', '102,8 млн', '15 ноября 2013', 'story', 7);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (8, 'AMD APU 1,6 ГГц (8 ядер) x86-64 архитектура', 'dis', 'фыва', 'Производитель', 'Gameboy Color', '102,8 млн', '15 ноября 2013', 'story', 8);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (1, 'AMD APU 1,6 ГГц (8 ядер) x86-64 архитектура', 'dis', 'фыва', 'Производитель', 'SNES', '102,8 млн', '15 ноября 2013', 'story', 1);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (2, 'AMD APU 1,6 ГГц (8 ядер) x86-64 архитектура', 'dis', 'фыва', 'Производитель', 'PS1', '102,8 млн', '15 ноября 2013', 'story', 2);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (3, '1', 'check this it ', 'фыва', 'Chet', 'sega', '102,8 млн', '15 ноября 2013', 'story', 3);
INSERT INTO cursovaya.platforms (id, cpu, description, generation, manufacturer, name, pieces_sold, relase_date, story, imagest_id) VALUES (9, 'Неизвестно', 'Неизвестно', 'Неизвестно', 'Неизвестно', 'Другое', 'Неизвестно', 'Неизвестно', 'Неизвестно', 9);

INSERT INTO cursovaya.basket (id, final_price) VALUES (1, 8);
INSERT INTO cursovaya.basket (id, final_price) VALUES (2, 52);

INSERT INTO cursovaya.products (id, description, full_price, idd, one_day_price, quantity, title, year_of_issue, age_limits_id, genres_id, imagesp_id, languages_id, platforms_id, publishers_id) VALUES (1, 'Вторая часть игры про боевых жаб от то же Rare, с небольшим изменениями - теперь жабам помогают Билли и Джимми из Double Dragon. Великолепный ход собрать самых известных героев жанра "бит-ем апа" в одной игре. Перед началом игры можно выбрать своего героя из трех жаб (включая спасенного в прошлой части) и двоих мужчин. Ловкость, с которой эта банда расправляется с врагами никуда не делась, вдобавок Джимми и Билли имеют свои приемы, но не менее "сочные". Геймплей такой же задорный и веселый как и в первой части. Похоже, Rare понимают, чего жаждут игроки от подобного жанра.', 20, null, 2.5, 22, 'Battletoads', 1993, 1, 1, 1, 4, 1, 1);
INSERT INTO cursovaya.products (id, description, full_price, idd, one_day_price, quantity, title, year_of_issue, age_limits_id, genres_id, imagesp_id, languages_id, platforms_id, publishers_id) VALUES (2, 'Игра Alladdin была портирована на приставку Денди с SEGA, причем, что самое интересное, игру портировали несколько раз, но все равно лучшим оказался не лицензированный порт игры - он был немного укороченным вариантом оригинала, но в свою очередь выглядел и управлялся куда более достойно своих официальных братьев. Игрок будет управлять непосредственно самим Аладдином (за исключением бонусного уровня), проходя привычные для платформера уровни. Мешать ему будет стража султана и всякого рода живность. В качестве оружия Аладдин использует яблоки, кидаясь их во врагов. На уровнях разбросаны драгоценности - сотня таких драгоценных камешков дает дополнительную жизнь герою.', 33333, null, 33, 2, 'Aladdin ', 1993, 1, 1, 2, 4, 1, 1);

INSERT INTO cursovaya.requests (id, date, number_of_days, price, basket_id, products_id) VALUES (3, '2019.11.18  23:19:44', 3, 1, 1, 1);
INSERT INTO cursovaya.requests (id, date, number_of_days, price, basket_id, products_id) VALUES (5, '2019.11.18  23:19:57', 4, 12, 2, 1);
INSERT INTO cursovaya.requests (id, date, number_of_days, price, basket_id, products_id) VALUES (7, '2019.11.18  23:20:00', 4, 1, 2, 2);