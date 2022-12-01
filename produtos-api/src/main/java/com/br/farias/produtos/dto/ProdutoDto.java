package com.br.farias.produtos.dto;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@With
public class ProdutoDto {

    private Long id;
    private LocalDate cadastro;
    private String descricao;
    private String observacao;
    private Integer quantidade;
    private BigDecimal valorUnitario;
}