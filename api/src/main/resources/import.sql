INSERT INTO location (location_id, name, `description`, created_at, address, total_rating, type) VALUES (1, 'Test Lokacija 1', 'Prijatna lokacija na zelenoj livadi van gradske vreve i...', '2025-11-22', 'Milenka Grcica 15', 0, 'Otvorena');

INSERT INTO location (location_id, name, `description`, created_at, address, total_rating, type) VALUES (2, 'Test Lokacija 2', 'Ususkana u samom centru grada, ova lokacija za mestane decenijama predstavlja...', '2024-10-29', 'Melhiora Erdujheljija 211', 0, 'Zatvorena');



INSERT INTO event (id, recurrent, location_location_id, name, address, type, `date`, price) VALUES (1, 0, 1, 'Livada Fest', 'Milenka Grcica 15', 'Otvorena', '2025-11-29', 1000);

INSERT INTO event (id, recurrent, location_location_id, name, address, type, `date`, price) VALUES (2, 1, 2, 'The Big Leagues', 'Melhiora Erdujheljija 211', 'Zatvorena', '2026-12-10', 0);
