package Steps;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.codeborne.selenide.Selenide.screenshot;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        TakeScreenShotByAnnotation();
    }
    @Attachment(value = "Screen shot", type = "image/png")
    public byte[] TakeScreenShotByAnnotation() {
        return screenshot(OutputType.BYTES);
    }
}
