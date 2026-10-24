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
    private LocalDateTime dataHoraLavagem;

    @Column(length = 500)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lavagem_id")
    private Lavagens lavagem;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraLavagem() {
        return dataHoraLavagem;
    }

    public void setDataHoraLavagem(LocalDateTime dataHoraLavagem) {
        this.dataHoraLavagem = dataHoraLavagem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Lavagens getLavagem() {
        return lavagem;
    }

    public void setLavagem(Lavagens lavagem) {
        this.lavagem = lavagem;
    }
}
