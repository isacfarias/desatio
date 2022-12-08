package com.br.farias.produtos.service;

import com.br.farias.produtos.convert.ProdutoConvert;
import com.br.farias.produtos.creator.ProdutoCreator;
import com.br.farias.produtos.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService service;

    @Mock
    private ProdutoRepository repository;


    @Test
    void createShouldReturnProdutoDtoWhenSuccess() throws Exception {
        var request = ProdutoCreator.createFakerRequest();
        var produtoSave = ProdutoConvert.dtoToEntity(request);

        Mockito.when(repository.save(produtoSave)).thenReturn(produtoSave);

        var response = service.create(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getDescricao(), request.getDescricao());

    }

    @Test
    void allShouldReturnProdutoDtoWhenSuccess() throws Exception {
        var request = ProdutoCreator.createFakerRequest();
        var produtoSave = ProdutoConvert.dtoToEntity(request);

        Mockito.when(repository.findAll()).thenReturn(List.of(produtoSave));

        var response = service.all();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.get(0).getDescricao(), request.getDescricao());

    }

    @Test
    void byIdShouldReturnProdutoDtoWhenSuccess() throws Exception {
        var request = ProdutoCreator.createFakerRequest();
        var produtoSave = ProdutoConvert.dtoToEntity(request).withId(1L);


        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(produtoSave));
        var response = service.byId(1L);


        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getDescricao(), request.getDescricao());

    }
}
