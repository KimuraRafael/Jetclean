CREATE TABLE lavagens
(
    id                 UUID           NOT NULL,
    descricao          VARCHAR(255)   NOT NULL,
    preco              NUMERIC(10, 2) NOT NULL,
    data_ultima_edicao TIMESTAMP      NOT NULL,

    CONSTRAINT pk_lavagens PRIMARY KEY (id),
    CONSTRAINT ck_lavagens_preco CHECK (preco >= 0)
);
