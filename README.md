CREATE  TABLE IF NOT EXISTS `dropwizard_skeleton`.`parts` (`id` INT  AUTO_INCREMENT ,`name` VARCHAR(150) NOT NULL ,`code` VARCHAR(10) NOT NULL, PRIMARY KEY (`id`) )ENGINE = InnoDB;

CREATE USER 'dropwizard'@'localhost' IDENTIFIED BY 'dropwizard';
CREATE DATABASE dropwizard_skeleton;
GRANT ALL PRIVILEGES ON dropwizard.*  TO 'dropwizard'@'localhost';

---- Start the application ------
java -jar target/dropwizard-blog-1.0.0.jar server configuration.yml
