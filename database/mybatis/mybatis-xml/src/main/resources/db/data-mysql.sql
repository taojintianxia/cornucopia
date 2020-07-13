truncate demo_ds.t_order;

INSERT INTO demo_ds.t_order (id, user_id, status)
VALUES (1, 35, 'init'),
       (2, 12, 'init'),
       (3, 28, 'init'),
       (4, 21, 'run'),
       (5, 24, 'finished');