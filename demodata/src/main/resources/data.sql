INSERT INTO users(login, pass, name, surname) values ('admin', 'admin','name', 'surname');
INSERT INTO users(login, pass ,name, surname) values ('user', 'user','name', 'surname');

INSERT INTO brands(name) values ('brand');
INSERT INTO brands(name) values ('Toyota');

INSERT INTO parts(name, brandId, model, price, realiseDate, partCondition, partDescription) values ('name', '1', 'model','100', '2020-02-19', 'USED','description');
INSERT INTO parts(name, brandId, model, price, realiseDate, partCondition, partDescription) values ('Engine', '2', 'JZ-GTE','1100', '2002-02-20','USED','Very good engine');

INSERT INTO orders(name, orderTime, deliveryDate, customerId, totalCost, orderCondition, dateOfCompletion,note,deliveryCondition) values ('name', '2020-02-24T19:28:24.456', '2020-02-24T20:30:24.456', '2','200', 'COMPLETED', '2020-02-24T20:30:24.456','note','ON_THE_WAY');
INSERT INTO orders(name, orderTime, deliveryDate, customerId, totalCost, orderCondition, dateOfCompletion,note,deliveryCondition) values ('first order', '2020-02-24T20:30:24.456', '2020-02-24T20:30:24.456','2', '400', 'ADOPTED', '2020-02-24T20:30:24.456','note','ON_THE_WAY');

INSERT INTO photos(imageUrl,comment,dateOfDownload,partId) values ('https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/1JZ-GTE_VVT-i_engine_in_1989_Toyota_Cressida.jpg/300px-1JZ-GTE_VVT-i_engine_in_1989_Toyota_Cressida.jpg',null,'2020-02-24T20:30:24.456','2');
INSERT INTO photos(imageUrl,comment,dateOfDownload,partId) values ('https://www.kosiski.com/wp-content/uploads/2016/07/Parts.jpg',null,'2020-02-24T20:30:24.456','1');

INSERT INTO order_items(partId ,orderId, quantity) VALUES ('2', '2','2');
INSERT INTO order_items(partId ,orderId, quantity) VALUES ('1', '1','1');