-- for Master Slave
INSERT INTO demo_ds_master.t_order VALUES(1000, 10, 'init');
INSERT INTO demo_ds_master.t_order VALUES(1001, 10, 'init');
INSERT INTO demo_ds_master.t_order VALUES(1100, 11, 'init');
INSERT INTO demo_ds_master.t_order VALUES(1101, 11, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(100000, 1000, 10, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(100001, 1000, 10, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(100100, 1001, 10, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(100101, 1001, 10, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(110000, 1100, 11, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(110001, 1100, 11, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(110100, 1101, 11, 'init');
INSERT INTO demo_ds_master.t_order_item VALUES(110101, 1101, 11, 'init');

INSERT INTO demo_ds_slave_0.t_order VALUES(1000, 10, 'init');
INSERT INTO demo_ds_slave_0.t_order VALUES(1001, 10, 'init');
INSERT INTO demo_ds_slave_0.t_order VALUES(1100, 11, 'init');
INSERT INTO demo_ds_slave_0.t_order VALUES(1101, 11, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(100000, 1000, 10, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(100001, 1000, 10, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(100100, 1001, 10, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(100101, 1001, 10, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(110000, 1100, 11, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(110001, 1100, 11, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(110100, 1101, 11, 'init');
INSERT INTO demo_ds_slave_0.t_order_item VALUES(110101, 1101, 11, 'init');

INSERT INTO demo_ds_slave_1.t_order VALUES(1000, 10, 'init');
INSERT INTO demo_ds_slave_1.t_order VALUES(1001, 10, 'init');
INSERT INTO demo_ds_slave_1.t_order VALUES(1100, 11, 'init');
INSERT INTO demo_ds_slave_1.t_order VALUES(1101, 11, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(100000, 1000, 10, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(100001, 1000, 10, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(100100, 1001, 10, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(100101, 1001, 10, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(110000, 1100, 11, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(110001, 1100, 11, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(110100, 1101, 11, 'init');
INSERT INTO demo_ds_slave_1.t_order_item VALUES(110101, 1101, 11, 'init');