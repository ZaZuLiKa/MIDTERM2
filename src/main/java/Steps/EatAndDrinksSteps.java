package Steps;

import Data.Models.Offers;
import Pages.EatAndDrinks;
import Pages.SearchResult;
import Steps.Utiles.dataCollect;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.refresh;

public class EatAndDrinksSteps {
    EatAndDrinks eatAndDrinks=new EatAndDrinks();
    dataCollect dataCollect=new dataCollect();
    ArrayList<Offers> data;
    @Step
    public EatAndDrinksSteps goToEatAndDrinks(){
        eatAndDrinks.getEatAndDrinks().shouldBe(Condition.visible).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("Verify Eat&Drinks Page availibility")
    public  EatAndDrinksSteps verifyPageAvailibility(){
        eatAndDrinks.getSectionName().shouldBe(Condition.visible);
        return this;
    }
    @Step("Click on Guest Filter")
    public EatAndDrinksSteps clickOnGuestFilter(){
        eatAndDrinks.getFilterPanel()
                .find(text("სტუმრების რაოდენობა"))
                .shouldBe(visible).click();
        return this;
    }
    @Step("Choose Guest Count")
    public EatAndDrinksSteps chooseGuestCount(){
        eatAndDrinks.getAllPTags().find(text("2-5 სტუმარი")).shouldBe(visible).click();
        refresh();// drop-down Menu-ს დასახურად ,ვჩქარობ უკეთესი ვარიანტი ვერ მოვიფიქრე ჯერ . ეს კომენტარი თუ აქ აღარ იყო ,ესეიგი დრო მოვნახე და გავაუმჯობესე :)
        return this;
    }
    @Step("check Offers")
    public EatAndDrinksSteps checkOffer(){
        data = dataCollect.collectEatAndDrinkTitles(eatAndDrinks.getTitle().shouldHave(sizeGreaterThan(0)));
       for (Offers offers:data){
           offers.getTitleLink().shouldBe(visible).click();
           var range= dataCollect.extractGuestRange(dataCollect.extractDescription());
           Assert.assertTrue(range[0]>=2 && range[1]<=5,"სტუმრების რაოდენობა სცდება ფილტრით დაწესებულ საზღვრებს(2-5 სტუმარი)");
           back();
       }
       //ასე 1 სტეპში იმიტომ გავაკეთე რომ არ მინდოდა testRunner-ში Loop-ის ჩადგმა ,რომ რამდენიმე სტეპი გამემეორებინა. დატაპროვაიდერით მაქვს იდეები ამ ტესტის გასაუმჯობესებლად და თუ მოვიცალე დავხვეწავ ,იმედია დედლაინამდე მოვასწრებ.
        return this;
    }

}
