package Steps;

import Pages.Sport;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.collections.SizeGreaterThan;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class SportSteps {
    Sport sport=new Sport();
    @Step("go to Sports Category")
    public SportSteps goToSport(){
        sport.getSport().shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Verify Sport Category Availability")
    public SportSteps verifySportPageAvailability(){
        sport.getSectionName().shouldBe(Condition.visible);
        return this;
    }
    @Step("Click On Price Filter")
    public SportSteps clickOnPriceFilter(String priceFilterName){
        //sport.getPriceFilter().shouldBe(visible).click();
        sport.getFilterPanel()
                .find(text(priceFilterName))
                .shouldBe(visible).click();
        return this;
    }
    @Step("Choose Price Range")
    public SportSteps pickPriceRange(String priceFilter){
        sport.getAllPTags().find(text(priceFilter)).shouldBe(visible).click();
        return this;
    }
    @Step("Verify Prices")
    public SportSteps verifyPrices(double start ,double stop){
        var Data=sport.getPrice()
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        for(SelenideElement se:Data){
            String price=se.getText();
            price=price.substring(0,price.length()-1);
            Assert.assertTrue(Double.parseDouble(price)>=start && Double.parseDouble(price)<=stop,
                    "სტუმრების რაოდენობა სცდება ფილტრით დაწესებულ საზღვრებს(2-5 სტუმარი)");
        }
        return this;
    }
}
