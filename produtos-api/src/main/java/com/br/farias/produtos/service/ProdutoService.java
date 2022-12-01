package com.br.farias.produtos.service;


import com.br.farias.produtos.convert.ProdutoConvert;
import com.br.farias.produtos.dto.ProdutoDto;
import com.br.farias.produtos.dto.ProdutoRequestDto;
import com.br.farias.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public List<ProdutoDto> all() {
        return this.repository.findAll().stream().map(ProdutoConvert::entityToDto).collect(Collectors.toList());
    }

    public ProdutoDto byId(Long id) {
        return this.repository
                .findById(id)
                .map(ProdutoConvert::entityToDto)
                .orElse(ProdutoDto.builder().build());
    }

    public ProdutoDto create(ProdutoRequestDto request) {
        return ProdutoConvert
                .entityToDto(this.repository
                        .save(ProdutoConvert.dtoToEntity(request)));
    }

    public ProdutoDto update(Long id, ProdutoRequestDto request) {
        return ProdutoConvert
                .entityToDto(this.repository
                        .save(ProdutoConvert.dtoToEntity(request).withId(id)));
    }

    public void delete(Long id) {
        this.repository
                .findById(id)
                .ifPresent(entity -> this.repository.delete(entity));
    }

}
