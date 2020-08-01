USE estadisticacovid;

INSERT INTO user (id,enabled,password,username) VALUES(1, 1, "$2a$10$zj1vBIixFAocIEBBLhZkN.c/SCkY3deXKaCce.xAuavi4iqTj1BnC", "user");
INSERT INTO user (id,enabled,password,username) VALUES(2, 1, "$2a$10$J.xjrMjiez5HcnUKDLxyIOt6MJitPylbnbkEa5wKYQib2500m5qRS", "admin");

INSERT INTO user_role (id,role,user_id) VALUES(1, "ROLE_USER", 1);
INSERT INTO user_role (id,role,user_id) VALUES(2, "ROLE_ADMIN", 2);