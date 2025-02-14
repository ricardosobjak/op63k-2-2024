package br.edu.utfpr.bankapi.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
public class TransferControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    EntityManager entityManager;

        @Test
    void deveriaRetornar400ParaRequisicaoInvalida() throws Exception {
        // ARRANGE
        var json = "{}"; // Dados para requisição

        // ACT
        var res = mvc.perform(
                MockMvcRequestBuilders
                        .post("/transaction/transfer").content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // ASSERT
        Assertions.assertEquals(400, res.getStatus());
    }

}