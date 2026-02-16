import Data.Models.Offers;
import Steps.*;
import Steps.Configuration.BaseTest;
import Steps.Utiles.SQLLogic;
import Steps.Utiles.dataCollect;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.management.Descriptor;
import java.util.*;

import static Data.Constants.*;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

public class TestRunner extends BaseTest {
    Home homePage = new Home();
    SearchResultSteps searchResultSteps = new SearchResultSteps();
    EatAndDrinksSteps eatAndDrinksSteps = new EatAndDrinksSteps();
    SportSteps sportSteps = new SportSteps();
    Courses courses = new Courses();

    @Test(priority = 1, description = "DateBase Validation", dataProvider = "SearchQuery",successPercentage = 60)
    public void databaseValidationTest(String Search) {
        //System.out.println(Search);
        homePage
                .verifyHomePageLoad()
                    .verifySearchButton()
                        .enterSearchPhrase(Search)
                                    .pressSearchButton();
        searchResultSteps
                .verifySearchResultPage()
                                .offerCheck();
    }
    @DataProvider(name = "SearchQuery")
    private Object[][] searchQuery() {
        List<Object[]> dataList = Arrays.asList(SEARCH_QUERIES);
        // Shuffle the list to randomize order
        Collections.shuffle(dataList);
        // Convert it back to Object[][]
        return dataList.toArray(new Object[0][]);
    }
    @Test(priority = 2,description = "Filter Validation")
    public void filterTest() {
        eatAndDrinksSteps
                .goToEatAndDrinks()
                    .verifyPageAvailibility()
                            .clickOnGuestFilter()
                                .chooseGuestCount()
                                            .checkOffer();
    }
    @Test(priority = 3, description = "Prince Range Validation")
    public void priceRangeTest() {
        sportSteps
                .goToSport()
                    .verifySportPageAvailability()
                        .clickOnPriceFilter(priceFilterName)
                                    .pickPriceRange(priceFilter)
                                        .verifyPrices(preDefinedStartingPrice, preDefinedLastPrice);
    } //აქაც მაქვს იდეები ამ ტესტი გასაუმჯობესებლად ,რომ ყველა რეინჯი დატაპროვაიდერით გავტესტო . დროის თემაა ,თუ მექნება მოვუბრუნდები .

    @Test(priority = 4,description = "Logo Test")
    public void logoTest() {
        courses
                .goToCourses()
                    .verifySportPageAvailability()
                                        .clickToLogo()
                                            .verifyHomePage();
    }

}
