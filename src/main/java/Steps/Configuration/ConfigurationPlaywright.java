package Steps.Configuration;
import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.util.List;

public class ConfigurationPlaywright {
    private final boolean HEADLESS = true;
    private final int SLOWMO = 500;
    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    public Page page;
    @BeforeSuite
    public void setup() {
        playwright = Playwright.create();

//        browser = playwright.firefox()
        browser = playwright.firefox()
                .launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(HEADLESS)
                                .setSlowMo(SLOWMO)
                                .setArgs(List.of("--start-maximized"))
                );

        browserContext = browser.newContext(
                new Browser.NewContextOptions()
//                        .setViewportSize(1900,1080)
                        .setViewportSize(null)
//                        .setRecordVideoDir(Paths.get("videos/"))
//                        .setRecordVideoSize(1280,720)

        );

        page = browserContext.newPage();


    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // ვიღებთ სქრინშოთს Playwright-ით და ვაბამთ Allure-ს
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            Allure.addAttachment("Failed Screen", new ByteArrayInputStream(screenshot));
        }
        browser.close();
    }
    @AfterSuite
    void tearDown() {
        if (page != null) page.close();
        if (browserContext != null) browserContext.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

    }


}
