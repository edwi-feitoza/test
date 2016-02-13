CREATE DATABASE `fiveware_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `fiveware_test`.`dados_pessoais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100),
  `sexo` CHAR(1) NOT NULL,
  `estado_civil` CHAR(3) NOT NULL,
  `telefone` VARCHAR(20),
  `possui_imovel` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`));