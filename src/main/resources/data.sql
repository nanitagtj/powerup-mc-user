INSERT INTO `user` (
    `dni_number`,
    `mail`,
    `name`,
    `password`,
    `phone`,
    `surname`,
    `id_role`
  )
VALUES
  (
    '123',
    'email@some.com',
    'Name',
    '$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S',
    '+5712345678901',
    'Surname',
    1
  );


INSERT INTO `role` (`id`, `description`, `name`) VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('2', 'ROLE_OWNER', 'ROLE_OWNER');

INSERT INTO `user` (`id_person`, `id_role`) VALUES ('1', '1');