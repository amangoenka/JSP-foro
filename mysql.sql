
-- POST TABLE
CREATE TABLE `class`.`posts` ( `post_id` INT(11) NOT NULL AUTO_INCREMENT , `user_name` VARCHAR(100) NOT NULL , `post_title` VARCHAR(500) NOT NULL , `post_desc` VARCHAR(2000) NOT NULL , `catagory_name` VARCHAR(50) NOT NULL , `post_up` INT NOT NULL , `post_down` INT NOT NULL , `post_ts` INT NOT NULL DEFAULT CURRENT_TIMESTAMP , PRIMARY KEY (`post_id`)) ENGINE = InnoDB;
-- Relice
CREATE TABLE `class`.`replies` ( `reply_id` INT(11) NOT NULL AUTO_INCREMENT , `reply_desc` VARCHAR(2000) NOT NULL , `user_name` VARCHAR(100) NOT NULL , `post_id` INT NOT NULL , `reply_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP , `reply_up` INT NULL , PRIMARY KEY (`reply_id`)) ENGINE = InnoDB;
