insert into question(id, text, description) values (1, 'В каком слове верно выделена буква, обозначающая ударный гласный звук?', 'Правильное ударение стоит в слове: сирОты.');
insert into question(id, text, description) values (2, 'Укажите пример без ошибки в образовании формы слова', 'Пример без ошибки: железнодорожный рельс.');
insert into question(id, text, description) values (3, 'Укажите предложение с грамматической ошибкой (с нарушением синтаксической нормы)', 'Предложение с грамматической ошибкой: Все радовались красотой природы (радовались чему? красоте).');
insert into question(id, text, description) values (4, 'Картины Крамского были купле(1)ы П.М. Третьяковым и позже выставле(2)ы на всеобщее обозрение почте(3)ейшей публике, восторже(4)о принявшей это решение. - В каком варианте ответа правильно указаны все цифры, на месте которых пишется НН?', 'НН пишется в 3,4 словах (почтеннейшей, восторженно).');
insert into question(id, text, description) values (5, 'В каком ряду во всех словах пропущена безударная проверяемая гласная корня?', 'Безударные гласные в корне слова пропущены в ряду: властелин, покарать, осознавать.');
insert into question(id, text, description) values (6, 'В каком ряду в обоих словах на месте пропуска пишется буква Е?', 'Буква Е пишется на месте пропуска в словах: развлекаемый, неприемлемый.');
insert into question(id, text, description) values (7, 'В каком предложении оба выделенных слова пишутся слитно?', 'Пишутся слитно: Подарок готовили ВТАЙНЕ от окружающих, ВПОЛГОЛОСА переговариваясь по вечерам.');
insert into question(id, text, description) values (8, 'Рисуя свой идеальный мир (1) А.И. Куинджи воспринимает жизнь (2) как благо (3) дарующее человеку красоту и радость впечатлений (4) позволяющих творить неустанно. - В каком варианте ответа правильно указаны все цифры, на месте которых в предложении должны стоять запятые?', 'Запятые должны стоять: 1,3,4. Рисуя свой идеальный мир, А.И. Куинджи воспринимает жизнь как благо, дарующее человеку красоту и радость впечатлений, позволяющих творить неустанно.');
insert into question(id, text, description) values (9, 'Укажите предложение, в котором надо поставить одну запятую:', 'Одна запятая должна стоять в следующем предложении: Композитор работал в консерватории не только днём, но и ночью.');

insert into answer(id, text, correct, question_id) values (1, 'сливОвый', false, 1);
insert into answer(id, text, correct, question_id) values (2, 'углУбить', false, 1);
insert into answer(id, text, correct, question_id) values (3, 'сирОты', true, 1);
insert into answer(id, text, correct, question_id) values (4, 'отобрАла', false, 1);

insert into answer(id, text, correct, question_id) values (5, 'вкусные торта', false, 2);
insert into answer(id, text, correct, question_id) values (6, 'без туфлей', false, 2);
insert into answer(id, text, correct, question_id) values (7, 'железнодорожный рельс', true, 2);
insert into answer(id, text, correct, question_id) values (8, 'в двухтысяче втором году', false, 2);

insert into answer(id, text, correct, question_id) values (9, 'Спортсмены познакомились и подружились с жителями спортивного лагеря.', false, 3);
insert into answer(id, text, correct, question_id) values (10, 'Подготовка к выступлению заняла много времени.', false, 3);
insert into answer(id, text, correct, question_id) values (11, 'Те, кто не смог посмотреть новый фильм, очень сожалели об этом.', false, 3);
insert into answer(id, text, correct, question_id) values (12, 'Все радовались красотой природы.', true, 3);

insert into answer(id, text, correct, question_id) values (13, '1, 2', false, 4);
insert into answer(id, text, correct, question_id) values (14, '3', false, 4);
insert into answer(id, text, correct, question_id) values (15, '3, 4', true, 4);
insert into answer(id, text, correct, question_id) values (16, '1, 3, 4', false, 4);

insert into answer(id, text, correct, question_id) values (17, 'вл..стелин, пок..рать, осозн..вать', true, 5);
insert into answer(id, text, correct, question_id) values (18, 'зар...зиться, заг...реть, обн...вление', false, 5);
insert into answer(id, text, correct, question_id) values (19, 'с...реневый, вл...жение, р...сти', false, 5);
insert into answer(id, text, correct, question_id) values (20, 'выск...чить, погл...тить, ч...рстветь', false, 5);

insert into answer(id, text, correct, question_id) values (21, 'выгон...шь, колебл...шься', false, 6);
insert into answer(id, text, correct, question_id) values (22, 'независ...мый, предв...дишь', false, 6);
insert into answer(id, text, correct, question_id) values (23, 'пряч...шь, отверт...т', false, 6);
insert into answer(id, text, correct, question_id) values (24, 'развлека...мый, неприемл...мый', true, 6);

insert into answer(id, text, correct, question_id) values (25, 'Все разговоры (НА)СЧЁТ продажи имения продолжались уже (В)ТЕЧЕНИЕ месяца', false, 7);
insert into answer(id, text, correct, question_id) values (26, '(НЕ)СМОТРЯ на привилегии, отец жил довольно скромно, (БЕЗ)УСТАЛИ работая в саду.', false, 7);
insert into answer(id, text, correct, question_id) values (27, 'Подарок готовили (В)ТАЙНЕ от окружающих, (В)ПОЛГОЛОСА переговариваясь по вечерам.', true, 7);
insert into answer(id, text, correct, question_id) values (28, '(ПО)НЕВОЛЕ задумаешься о будущем, когда националисты (В)ОТКРЫТУЮ говорят о ненависти к инородцам.', false, 7);

insert into answer(id, text, correct, question_id) values (29, '1, 2, 3, 4', false, 8);
insert into answer(id, text, correct, question_id) values (30, '1, 3, 4', true, 8);
insert into answer(id, text, correct, question_id) values (31, '2, 3, 4', false, 8);
insert into answer(id, text, correct, question_id) values (32, '3, 4', false, 8);

insert into answer(id, text, correct, question_id) values (33, 'Забота Александра Константиновича о студентах и преподавателях консерватории была огромна.', false, 9);
insert into answer(id, text, correct, question_id) values (34, 'Глазунова обожали и боготворили студенты и ценители его музыки.', false, 9);
insert into answer(id, text, correct, question_id) values (35, 'Композитор работал в консерватории не только днём но и ночью.', true, 9);
insert into answer(id, text, correct, question_id) values (36, 'Ни свет ни заря в пустынных залах филармонии начинала звучать музыка.', false, 9);
