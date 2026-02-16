package Steps;

import Steps.Utiles.SQLLogic;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

public class Home {
    Pages.Home homePage=new Pages.Home();
    SQLLogic sqlLogic=new SQLLogic();
    @Step("Verify HomePage Load ")
    public Home verifyHomePageLoad(){
        homePage.getLogo().shouldBe(Condition.visible);
        return this;
    }
    @Step("Verify Search Button Availability")
    public Home verifySearchButton(){
        homePage.getSearchInput().shouldBe(Condition.visible).shouldBe(Condition.enabled);
        return this;
    }
    @Step("Fill Search Input")
    public Home enterSearchPhrase(String searchString){
        homePage.getSearchInput().setValue(searchString);
        return this;
    }
    @Step("Press Enter for Search ")
    public void pressSearchButton(){
        homePage.getSearchInput().pressEnter();
    }

}
