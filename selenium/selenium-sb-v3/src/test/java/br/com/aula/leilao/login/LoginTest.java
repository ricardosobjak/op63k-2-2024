package br.com.aula.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    LoginPage loginPage;

    @BeforeEach
    void beforeEach() {
        loginPage = new LoginPage();
    }

    @AfterEach
    void afterEach() {
        loginPage.fechar();
    }

    @Test
    void deveriaFazerLoginComSucesso() {
        // ACT
        loginPage.preencherFormularioDeLogin("fulano", "pass");
        loginPage.submeterFormularioDeLogin();

        // ASSERTS
        // Verificar se a navegação mudou para /leiloes
        Assertions.assertTrue(loginPage.estaNaPaginaDeLeiloes());

        // Verificar se o nome do usuário é apresentado
        Assertions.assertEquals(
                loginPage.getNomeUsuarioLogado(),
                "fulano");
    }

    @Test
    void naoDeveriaFazerLoginComSucesso() {
        // ACT
        loginPage.preencherFormularioDeLogin("x", "y");
        loginPage.submeterFormularioDeLogin();

        // ASSERTS
        // Verificar se a navegação continua em /login
        Assertions.assertTrue(loginPage.estaNaPaginaDeLogin());

        // Verificar se a mensagem de erro é apresentada
        Assertions.assertTrue(
            loginPage.contemTexto("Usuário e senha inválidos")
        );

    }
}
