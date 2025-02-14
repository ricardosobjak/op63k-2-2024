package br.com.aula.leilao;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    @Test
    public void hello() {
        System.setProperty(
            "webdriver.chrome.driver",
            "drivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080");
        browser.quit();
    }
}
