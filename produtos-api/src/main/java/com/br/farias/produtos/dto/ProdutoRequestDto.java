package com.br.farias.produtos.dto;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@With
public class ProdutoRequestDto {

    private LocalDate cadastro;
    private String descricao;
    private String observacao;
    private Integer quantidade;
    private BigDecimal valorUnitario;
}