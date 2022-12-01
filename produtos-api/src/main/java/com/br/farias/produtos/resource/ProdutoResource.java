package com.br.farias.produtos.resource;

import com.br.farias.produtos.dto.ProdutoDto;
import com.br.farias.produtos.dto.ProdutoRequestDto;
import com.br.farias.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/produtos")
@RequiredArgsConstructor
public class ProdutoResource {

    private final ProdutoService service;

    @GetMapping
    public List<ProdutoDto> all() {
        return this.service.all();
    }

    @GetMapping("/{id}")
    public ProdutoDto byId(@PathVariable Long id) {
        return this.service.byId(id);
    }

    @PostMapping
    public ProdutoDto create(@RequestBody ProdutoRequestDto dto) {
        return this.service.create(dto);
    }

    @PutMapping("/{id}")
    public ProdutoDto update(@PathVariable Long id, @RequestBody ProdutoRequestDto request) {
        return this.service.update(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }

}
