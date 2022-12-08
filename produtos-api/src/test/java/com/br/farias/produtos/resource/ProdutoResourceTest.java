package com.br.farias.produtos.resource;


import com.br.farias.produtos.creator.ProdutoCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String URL = "/produtos";

    @Test
    void allShouldReturnProdutoDtoWhenSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].descricao").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].descricao").value("Vassoura Harry Potter"))
        ;
    }

    @Test
    void allShouldReturnProdutoDtoWhenSuccessV2() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                );

        result.andDo(MockMvcResultHandlers.print());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.[0].descricao").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.[0].descricao").value("Vassoura Harry Potter"));
    }

    @Test
    void byIdShouldReturnProdutoDtoWhenSuccess() throws Exception {
        var result = mockMvc
                .perform(MockMvcRequestBuilders.get(URL.concat("/{id}"), 1)
                .contentType(MediaType.APPLICATION_JSON)
        );

        result.andDo(MockMvcResultHandlers.print());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.descricao").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value("Vassoura Harry Potter"));
    }

    @Test
    void createShouldReturnProdutoDtoWhenSuccess() throws Exception {
        var request = ProdutoCreator.createRequest();

        var jsonBody = objectMapper.writeValueAsString(request);
        var result = mockMvc
                .perform(MockMvcRequestBuilders.post(URL)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                );

        result.andDo(MockMvcResultHandlers.print());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.cadastro").value(request.getCadastro().toString()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value(request.getDescricao()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.observacao").value(request.getObservacao()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.quantidade").value(request.getQuantidade()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.valorUnitario").value(request.getValorUnitario()));
    }

    @Test
    void createShouldReturnProdutoDtoWhenSuccessFaker() throws Exception {
        var request = ProdutoCreator.createFakerRequest();

        var jsonBody = objectMapper.writeValueAsString(request);
        var result = mockMvc
                .perform(MockMvcRequestBuilders.post(URL)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                );

        result.andDo(MockMvcResultHandlers.print());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.cadastro").value(request.getCadastro().toString()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value(request.getDescricao()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.observacao").value(request.getObservacao()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.quantidade").value(request.getQuantidade()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.valorUnitario").value(request.getValorUnitario()));
    }

    @Test
    void updateShouldReturnProdutoDtoWhenSuccess() throws Exception {
        var request = ProdutoCreator.updateRequest();

        var jsonBody = objectMapper.writeValueAsString(request);
        var result = mockMvc
                .perform(MockMvcRequestBuilders.put(URL.concat("/{id}"), 1)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                );

        result.andDo(MockMvcResultHandlers.print());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.cadastro").value(request.getCadastro().toString()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value(request.getDescricao()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.observacao").value(request.getObservacao()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.quantidade").value(request.getQuantidade()));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.valorUnitario").value(request.getValorUnitario()));
    }


}
