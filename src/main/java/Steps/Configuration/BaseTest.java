package Steps.Configuration;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private String baseURL="https://swoop.ge/";
    @BeforeSuite
    public void Cfg(){
        Configuration.browser="chrome";//default
        Configuration.savePageSource=false;
        Configuration.browserSize="1920x1080";
        Configuration.headless=true;
       Configuration.timeout=10000;
    }
    @BeforeMethod
    public void BrowserStart(){
        open(baseURL);
    }
}
