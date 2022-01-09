import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class First_WebdriverClass {

    public static void main(String[] args) throws Exception{

//        System.setProperty("webdriver.chrome.driver","//home//muzamil//Desktop//Project//Curation//java//selenium-java-3.14.0//chromedriver//chromedriver");

// objects and variables instantiation
        WebDriver driver = ChromeDriverInstance.getInstance();
//        String appUrl = "https://www.cublick.com/";
//        String appUrl = "https://www.pinterest.com/pin/339529259379416495/";
//        String appUrl = "https://en.wikipedia.org/wiki/Pakistan";
//        String appUrl = "https://www.mygon.com/pt/guia/lisboa/restaurantes";
        String appUrl = "https://www.babynameguide.com/categoryafrican.asp?strCat=African";
//        String appUrl = "https://newsstand.naver.com/?list=ct1&pcode=330";

// launch the firefox browser and open the application url
        driver.get(appUrl);

        driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.onmouseover=function(e) {\n" +
                "        e.target.style.backgroundColor = \"green\";\n" +
                "};" +
                "window.onmouseout=function(e) {\n" +
                " e.target.style.backgroundColor = \"initial\";\n" +
                "   };" +
                "window.onclick=function(e) {\n" +
                "e.preventDefault();\n" +
                " console.log(e.target)\n" +
                "   };" +
                "window.onload = function() {\n" +
                "    var anchorElements = document.getElementsByTagName('a');\n" +
                "    for (var i in anchorElements)\n" +
                "        anchorElements[i].onclick = function() {\n" +
                "            alert(this.href);\n" +
                "            return false;\n" +
                "        }\n" +
                "}");
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));


//        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        String html = (String)((ChromeDriver) driver).executeScript("return document.body.innerHTML");
//        WebElement webElement = ((ChromeDriver) driver).findElementByClassName("focusPanelCenter");
//        System.out.println(webElement.getText());
        log(driver.getPageSource());

// enter a valid username in the email textbox
//        WebElement username = driver.findElement(By.id("Email"));
//        username.clear();
//        username.sendKeys("TestSelenium");
//
//// enter a valid password in the password textbox
//        WebElement password = driver.findElement(By.id("Passwd"));
//        password.clear();
//        password.sendKeys("password123");
//
//// click on the Sign in button
//        WebElement SignInButton = driver.findElement(By.id("signIn"));
//        SignInButton.click();
//
//// close the web browser
//        driver.close();
//        System.out.println("Test script executed successfully.");
//
//// terminate the program
//        System.exit(0);
//        driver.close();
//        driver.quit();
    }

    public static void log(String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("//home//muzamil//Desktop//Project//Curation//java//selenium-java-3.14.0//output.txt"));
        writer.write(message);

        writer.close();
//        PrintWriter out = new PrintWriter(new FileWriter("//home//muzamil//Desktop//Project//Curation//java//selenium-java-3.14.0//output.txt", true), true);
//        out.write(message);
//        out.close();
    }
}
