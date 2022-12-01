package com.br.farias.produtos.convert;

import com.br.farias.produtos.dto.ProdutoDto;
import com.br.farias.produtos.dto.ProdutoRequestDto;
import com.br.farias.produtos.entity.Produto;

public class ProdutoConvert {

    public static Produto dtoToEntity(ProdutoRequestDto request) {
        return Produto.builder()
                .cadastro(request.getCadastro())
                .descricao(request.getDescricao())
                .observacao(request.getObservacao())
                .quantidade(request.getQuantidade())
                .valorUnitario(request.getValorUnitario())
                .build();
    }

    public static ProdutoDto entityToDto(Produto entity) {
        return ProdutoDto.builder()
                .id(entity.getId())
                .cadastro(entity.getCadastro())
                .descricao(entity.getDescricao())
                .observacao(entity.getObservacao())
                .quantidade(entity.getQuantidade())
                .valorUnitario(entity.getValorUnitario())
                .build();
    }

}
