CREATE TABLE agendamentos_lavagens
(
    id                UUID         NOT NULL,
    data_hora_lavagem TIMESTAMP    NOT NULL,
    observacao        VARCHAR(500),
    veiculo_id        UUID         NOT NULL,
    lavagem_id        UUID         NOT NULL,

    CONSTRAINT pk_agendamentos_lavagens PRIMARY KEY (id),
    CONSTRAINT fk_agendamentos_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculos (id),
    CONSTRAINT fk_agendamentos_lavagem FOREIGN KEY (lavagem_id) REFERENCES lavagens (id)
);

CREATE INDEX idx_agendamentos_veiculo ON agendamentos_lavagens (veiculo_id);
CREATE INDEX idx_agendamentos_lavagem ON agendamentos_lavagens (lavagem_id);
