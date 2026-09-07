CREATE TABLE veiculos
(
    id            UUID        NOT NULL,
    tipo_veiculo  VARCHAR(30) NOT NULL,
    cor           VARCHAR(50) NOT NULL,
    placa         VARCHAR(10) NOT NULL,
    modelo        VARCHAR(100) NOT NULL,

    CONSTRAINT pk_veiculos PRIMARY KEY (id),
    CONSTRAINT uk_veiculos_placa UNIQUE (placa)
);