package br.com.aula.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        loginPage.preencherFormularioDeLogin("fulano", "pass");
        loginPage.submeterFormularioDeLogin();

        // ACT
        this.browser.findElement(By.id("username")).sendKeys("fulano");
        this.browser.findElement(By.id("password")).sendKeys("pass");
        this.browser.findElement(By.id("button-submit")).click();

        // ASSERTS
        // Verificar se a navegação mudou para /leiloes
        Assertions.assertTrue(browser.getCurrentUrl()
                .equals("http://localhost:8080/leiloes"));

        // Verificar se o nome do usuário é apresentado
        Assertions.assertTrue(
                browser.findElement(By.id("usuario-logado"))
                        .getText().equals("fulano"));
    }

    @Test
    void naoDeveriaFazerLoginComSucesso() {
        // ACT
        this.browser.findElement(By.id("username")).sendKeys("x");
        this.browser.findElement(By.id("password")).sendKeys("y");
        this.browser.findElement(By.id("button-submit")).click();

        // ASSERTS
        // Verificar se a navegação continua em /login
        Assertions.assertTrue(browser.getCurrentUrl()
                .contains("http://localhost:8080/login"));

        // Verificar se a mensagem de erro é apresentada
        Assertions.assertTrue(
                browser.getPageSource().contains("Usuário e senha inválidos"));

    }
}
