package br.com.aula.leilao.leiloes;

import org.junit.jupiter.api.BeforeEach;

import br.com.aula.leilao.login.LoginPage;

public class CadastroLeilaoTest {
    CadastroLeilaoPage cadastroLeilaoPage;

    @BeforeEach
    void beforeEach() {
        LoginPage loginPage = new LoginPage();
        loginPage.preencherFormularioDeLogin("fulano", "pass");
        loginPage.submeterFormularioDeLogin();
        cadastroLeilaoPage = loginPage.abrirPaginaDeCadastroLeilao();
    }

}
