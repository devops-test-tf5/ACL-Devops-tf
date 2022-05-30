DELIMITER //

CREATE PROCEDURE `sp_get_all_users` ()
BEGIN
select * from users;
END //

DELIMITER ;
