package Steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.net.URL;

public class Courses {
    Pages.Courses courses=new Pages.Courses();
    @Step("go to Courses Category")
    public Courses goToCourses(){
        courses.getCourses().shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Verify Courses Category Availability")
    public Courses verifySportPageAvailability(){
        courses.getSectionName().shouldBe(Condition.visible);

        return this;
    }
    @Step("Click To Logo")
    public Courses clickToLogo(){
        courses.getLogo().shouldBe(Condition.visible).click();

        return this;
    }
    @Step("Validate HomePage Redirection")
    public  Courses verifyHomePage(){
        courses.getHomePageValidation().shouldBe(Condition.visible);
        return this;
    }

}
