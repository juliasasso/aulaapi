CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `categoria` (`id`,`nome`) VALUES (1,'informatica');
INSERT INTO `categoria` (`id`,`nome`) VALUES (2,'moveis para escritorio');
INSERT INTO `categoria` (`id`,`nome`) VALUES (3,'perfumaria');
