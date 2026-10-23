package com.JetClean.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "lavagens")
public class Lavagens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String descricao;

    @NotNull
    @DecimalMin("0.00")
    @Column(nullable = false, precision = 10, scale = 2)
    @Digits(integer = 8, fraction = 2)
    private BigDecimal preco;

    @UpdateTimestamp
    @Column(name = "data_ultima_edicao", nullable = false)
    private LocalDateTime data_ultima_edicao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDateTime getData_ultima_edicao() {
        return data_ultima_edicao;
    }

    public void setData_ultima_edicao(LocalDateTime data_ultima_edicao) {
        this.data_ultima_edicao = data_ultima_edicao;
    }
}
