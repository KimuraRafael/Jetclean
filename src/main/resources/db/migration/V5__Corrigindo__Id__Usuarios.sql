-- Corrige o id da tabela usuarios: serial (inteiro) -> UUID, igual as demais tabelas
ALTER TABLE usuarios ALTER COLUMN id DROP DEFAULT;
ALTER TABLE usuarios ALTER COLUMN id TYPE UUID USING gen_random_uuid();
DROP SEQUENCE IF EXISTS usuarios_id_seq;

-- E-mail unico: cada usuario se identifica pelo e-mail no login
ALTER TABLE usuarios ADD CONSTRAINT uk_usuarios_email UNIQUE (email);
