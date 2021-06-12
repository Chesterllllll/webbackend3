DROP TABLE IF EXISTS 'customer'
CREATE TABLE 'customer'(
'id' bigint(20) NOT NULL AUTO_INCREMENT,
'username' varchar(255) DEFAULT NULL;
'password' varchar(255) DEFAULT NULL;
'follower' bigint(20) DEFAULT 0;
'email' varchar (255) DEFAULT NULL;
PRIMARY KEY ('id','username')
)

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE  `comment` ADD CONSTRAINT `FK_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
        ON DELETE CASCADE;


