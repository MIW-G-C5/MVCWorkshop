CREATE SCHEMA Klanten;

USE Klanten;


CREATE TABLE `Klant` (
  `klantnr` int(11) NOT NULL AUTO_INCREMENT,
  `voorletters` varchar(10) NOT NULL,
  `voorvoegsels` varchar(10) DEFAULT NULL,
  `achternaam` varchar(45) NOT NULL,
  `telefoon` varchar(10) NOT NULL,
  PRIMARY KEY (`klantnr`)
);



-- Gebruiker definiëren en toegang verlenen
CREATE USER 'userKlanten'@'localhost' IDENTIFIED BY 'pwKlanten';
GRANT ALL PRIVILEGES ON Klanten.* TO 'userKlanten'@'localhost';


