package com.JetClean.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "agendamentos_lavagens")
public class AgendamentoLavagens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "data_hora_lavagem", nullable = false)
    private LocalDateTime data_hora_lavagem;

    @Column(length = 500)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lavagem_id")
    private Lavagens lavagem_id;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getData_hora_lavagem() {
        return data_hora_lavagem;
    }

    public void setData_hora_lavagem(LocalDateTime data_hora_lavagem) {
        this.data_hora_lavagem = data_hora_lavagem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Veiculo getVeiculo_id() {
        return veiculo_id;
    }

    public void setVeiculo_id(Veiculo veiculo_id) {
        this.veiculo_id = veiculo_id;
    }

    public Lavagens getLavagem_id() {
        return lavagem_id;
    }

    public void setLavagem_id(Lavagens lavagem_id) {
        this.lavagem_id = lavagem_id;
    }
}
