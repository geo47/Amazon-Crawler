import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class ChromeDriverInstance {

    // static variable single_instance of type Singleton
    private static ChromeDriver CHROME_DRIVER = null;

    // private constructor restricted to this class itself
    private ChromeDriverInstance() {}

    // static method to create instance of Singleton class
    public static ChromeDriver getInstance() {
        System.setProperty("webdriver.chrome.driver",
                "//home//muzamil//Desktop//Project//Curation//java//spring-boot-elasticsearch//spring-boot-elasticsearch//chromedriver//chromedriver");

        List<String> args = new ArrayList<>();
        args.add("--log-level=3");
        args.add("--silent");
        args.add("--disable-popup-blocking");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(args);
//        chromeOptions.addArguments("headless");
//        chromeOptions.addArguments("window-size=1200x600"); // optional

//        chromeOptions.addArguments("--window-size=1920,1080");
//        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--disable-extensions");
//        chromeOptions.setExperimentalOption("useAutomationExtension", false);
//        chromeOptions.addArguments("--proxy-server='direct://'");
//        chromeOptions.addArguments("--proxy-bypass-list=*");
//        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--headless");
        CHROME_DRIVER = null;
        if (CHROME_DRIVER == null)
            CHROME_DRIVER = new ChromeDriver(chromeOptions);

        return CHROME_DRIVER;
    }

}
