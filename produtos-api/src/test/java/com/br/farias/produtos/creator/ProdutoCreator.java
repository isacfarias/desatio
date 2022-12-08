package com.br.farias.produtos.creator;

import com.br.farias.produtos.dto.ProdutoRequestDto;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoCreator {


    public static ProdutoRequestDto createRequest() {
        return ProdutoRequestDto.builder()
                .cadastro(LocalDate.now())
                .descricao("MTB Onça banguela Aro 29")
                .observacao("12 velocidades")
                .quantidade(15)
                .valorUnitario(new BigDecimal("15000.0"))
                .build();
    }

    public static ProdutoRequestDto createFakerRequest() {
        var faker = new Faker();
        return ProdutoRequestDto.builder()
                .cadastro(LocalDate.now())
                .descricao(faker.commerce().productName())
                .observacao(faker.commerce().material())
                .quantidade(faker.number().randomDigitNotZero())
                .valorUnitario(new BigDecimal(faker.commerce().price().replace(",", ".")))
                .build();
    }

    public static ProdutoRequestDto updateRequest() {
        return ProdutoRequestDto.builder()
                .cadastro(LocalDate.now())
                .descricao("Vassoura Harry Potter")
                .observacao("edição limitada")
                .quantidade(1)
                .valorUnitario(new BigDecimal("550000.0"))
                .build();
    }
}
