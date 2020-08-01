USE estadisticacovid;
select * from user;


INSERT INTO user (id,enabled,password,username) VALUES(1, 1, "$2a$10$1zX6zlXFvVdYkSSnGwN6TOomb.i.i6OcMwkRQv8bmEwMvtTHnjeEi", "user");
#INSERT INTO user (id,createdat,enabled,password,updatedat,username) VALUES(2, "2020-03-22 00:00:01", 1, "$2a$10$k6whblCKsrbE3rKHsMejZ.LX6wNtjX2tOdwwa/VSdrZ47zUzxLgk6", "2020-03-22 00:00:01", "gerente");

#INSERT INTO user_role (id,createdat,role,updatedat,user_id) VALUES(1, "2020-03-22 00:00:01", "ROLE_USER", "2020-03-22 00:00:01", 1);
#INSERT INTO user_role (id,createdat,role,updatedat,user_id) VALUES(2, "2020-03-22 00:00:01", "ROLE_ADMIN", "2020-03-22 00:00:01", 2);