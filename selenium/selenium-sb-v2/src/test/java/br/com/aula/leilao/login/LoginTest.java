package br.com.aula.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver browser;

    @BeforeEach
    void setup() {
        System.out.println("beforeEach");
        // ARRANGE
        System.setProperty(
                "webdriver.chrome.driver",
                "drivers/chromedriver.exe");

        this.browser = new ChromeDriver();
        this.browser.navigate().to("http://localhost:8080/login");
    }

    @AfterEach
    void afterEach() {
        browser.quit();
    }

    @Test
    void deveriaFazerLoginComSucesso() {

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
}
