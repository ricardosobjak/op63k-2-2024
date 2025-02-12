package br.com.aula.leilao.login;

import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.aula.leilao.leiloes.CadastroLeilaoPage;

public class LoginPage {
    public static final String URL_LOGIN = "http://localhost:8080/login";
    public static final String URL_LEILOES = "http://localhost:8080/leiloes";

    WebDriver browser;

    public LoginPage() {
        // ARRANGE
        System.setProperty(
                "webdriver.chrome.driver",
                "drivers/chromedriver.exe");

        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        browser.quit();
    }

    public void preencherFormularioDeLogin(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
    }

    public void submeterFormularioDeLogin() {
        this.browser.findElement(By.id("button-submit")).click();
    }

    public boolean estaNaPaginaDeLeiloes() {
        return browser.getCurrentUrl().equals(URL_LEILOES);
    }

    public String getNomeUsuarioLogado() {
        return browser.findElement(By.id("usuario-logado"))
                .getText();
    }

    public boolean estaNaPaginaDeLogin() {
        return browser.getCurrentUrl().contains(URL_LOGIN);
    }

    public boolean contemTexto(String string) {
        return browser.getPageSource().contains(string);
    }

    public CadastroLeilaoPage abrirPaginaDeCadastroLeilao() {
        browser.navigate().to(URL_LEILOES + "/new");
        return new CadastroLeilaoPage(browser);
    }
}
