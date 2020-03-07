

CREATE TABLE `items` (
  `id_items` bigint(11) NOT NULL AUTO_INCREMENT,
  `items_name` varchar(45) NOT NULL,
  `items_price` double DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `items_image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_items`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;




INSERT INTO `items` (`id_items`, `items_name`, `items_price`, `description`, `country`, `items_image`) VALUES (5,'Royal Canin for cats',9.85,'Pet food','Russia','royal'),(7,'Felix for cats',2.85,'Pet food','Russia','felix'),(8,'Gurme for cats',1.25,'Pet food','Russia','gurme'),(9,'Kitycat for cats',1.15,'Pet food','Russia','kitycat'),(10,'Wiskas for cats',1.99,'Pet food','Russia','wiskas');






CREATE TABLE `order` (
  `id_order` bigint(11) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(11) NOT NULL,
  `id_items` bigint(11) NOT NULL,
  `order_status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_order`),
  KEY `id_user__idx` (`id_user`),
  KEY `id_items__idx` (`id_items`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;




INSERT INTO `order` (`id_order`, `id_user`, `id_items`, `order_status`) VALUES (5,30,5,0);







CREATE TABLE `user` (
  `id_user` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `salt` varchar(45) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;




INSERT INTO `user` (`id_user`, `name`, `login`, `age`, `email`, `password`, `salt`) VALUES (34,'alex','alex',25,'alex@mail.ru','310888','310888'),(35,'max','max',26,'max@gmail.com','310888','310888');



