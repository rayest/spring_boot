insert  into `security_role`(`id`,`name`) values (1,'ROLE_ADMIN'),(2,'ROLE_USER');

insert  into `security_user`(`id`,`password`,`username`) values (1,'root','root'),(2,'sang','sang');

insert  into `security_user_roles`(`security_user_id`,`roles_id`) values (1,1),(2,2);