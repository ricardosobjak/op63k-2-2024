package br.com.aula.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    
}
