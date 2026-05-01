INSERT INTO user (user_id, `role`, email, password, name, created_at, phone_number, birthday, address, city) VALUES (1, 'ADMIN', 'dan23.ftn@gmail.com', '$2a$12$oQAVtfwUGXriGx2keS/B5OCuZF1xBSKTLZUFmlqfe0yu.QZCjukvu', 'Dan', '2026-05-01', '0698765432', '1989-11-11', 'Theresien Platz 11a', 'Wien');

INSERT INTO user (user_id, `role`, email, password, name, created_at, phone_number, birthday, address, city) VALUES (2, 'USER', 'mar23.ftn@gmail.com', '$2a$10$nUcxE.JBf4RrtvQpzN/hZONuXnzdFI5qGoWVzX4Dl7Z35tZeRmOiW', 'Mar', '2026-04-30', '065123456', '2009-11-11', 'Jules Verne 25', 'Paris');



INSERT INTO location (location_id, name, `description`, created_at, address, total_rating, type) VALUES (1, 'Test Lokacija 1', 'Prijatna lokacija na zelenoj livadi van gradske vreve i...', '2025-11-22', 'Milenka Grcica 15', 0, 'Otvorena');

INSERT INTO location (location_id, name, `description`, created_at, address, total_rating, type) VALUES (2, 'Test Lokacija 2', 'Ususkana u samom centru grada, ova lokacija za mestane decenijama predstavlja...', '2024-10-29', 'Melhiora Erdujheljija 211', 0, 'Zatvorena');



INSERT INTO event (id, recurrent, location_location_id, name, address, type, `date`, price) VALUES (1, 0, 1, 'Livada Fest', 'Milenka Grcica 15', 'Otvorena', '2025-11-29', 1000);

INSERT INTO event (id, recurrent, location_location_id, name, address, type, `date`, price) VALUES (2, 1, 2, 'The Big Leagues', 'Melhiora Erdujheljija 211', 'Zatvorena', '2025-12-10', 0);


INSERT INTO rate (id, performance, sound_and_lighting, venue, overall_impression) VALUES (1, 10, 9, 8, 9);
INSERT INTO comment (id, created_at, deleted, text, parent_comment_id, user_user_id) VALUES (1, '2026-04-30', 0, 'Highly recommended to anyone! I truly had fun on this occassion. Bring your family and friends! Oh, and do not forget...', null, 1);
INSERT INTO review (id, created_at, event_count, hidden, comment_id, event_id, location_location_id, rate_id, user_user_id) VALUES (1, '2026-02-27', 1, 0, 1, 2, 2, 1, 1);

INSERT INTO rate (id, performance, sound_and_lighting, venue, overall_impression) VALUES (2, 7, 5, 5, 6);
INSERT INTO comment (id, created_at, deleted, text, parent_comment_id, user_user_id) VALUES (2, '2026-04-30', 0, 'Would not come back, after what happened - the sound was awful, the organization was not the best, and we were not told that we had to bring our own snacks!', null, 2);
INSERT INTO review (id, created_at, event_count, hidden, comment_id, event_id, location_location_id, rate_id, user_user_id) VALUES (2, '2026-02-27', 1, 0, 2, 2, 2, 2, 2);

INSERT INTO rate (id, performance, sound_and_lighting, venue, overall_impression) VALUES (3, null, null, null, null);
INSERT INTO comment (id, created_at, deleted, text, parent_comment_id, user_user_id) VALUES (3, '2026-05-01', 1, 'Deleted reply comment display test...', 2, 1);
INSERT INTO review (id, created_at, event_count, hidden, comment_id, event_id, location_location_id, rate_id, user_user_id) VALUES (3, '2026-02-27', 1, 1, 3, 2, 2, 3, 1);
