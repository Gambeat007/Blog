INSERT INTO articles (id, published_at, title, body)
VALUES (111, CURRENT_TIMESTAMP(), 'title1', 'body1'),
       (222, CURRENT_TIMESTAMP(), 'title2', 'body2'),
       (333, CURRENT_TIMESTAMP(), 'title3', 'body3'),
       (444, CURRENT_TIMESTAMP(), 'title4', 'body4'),
       (555, CURRENT_TIMESTAMP(), 'title5', 'body5'),
       (666, CURRENT_TIMESTAMP(), 'title6', 'body6'),
       (777, CURRENT_TIMESTAMP(), 'title7', 'body7'),
       (888, CURRENT_TIMESTAMP(), 'title8', 'body8');


INSERT INTO reviews (id, published_at, body, article, article_rating)
VALUES (1111, CURRENT_TIMESTAMP(), 'revBody1', 333, '10.0'),
       (2222, CURRENT_TIMESTAMP(), 'revBody2', 333, '10.0'),
       (3333, CURRENT_TIMESTAMP(), 'revBody3', 555, '8.0'),
       (4444, CURRENT_TIMESTAMP(), 'revBody4', 666, '6.0'),
       (5555, CURRENT_TIMESTAMP(), 'revBody5', 666, '8.0');