package Steps;
import Data.Models.Offers;
import Pages.SearchResult;
import Steps.Utiles.SQLLogic;
import Steps.Utiles.dataCollect;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


public class SearchResultSteps {
    SearchResult searchResult=new SearchResult();
    dataCollect dataCollect=new dataCollect();
    SQLLogic sqlLogic=new SQLLogic();
    @Step("Verify Search Result Page Loads")
    public SearchResultSteps verifySearchResultPage(){
        searchResult.getFilterPanel().find(text("სორტირება")).shouldBe(visible);
        return this;
    }
//    @Step("Verify Search Results Name")
//    public SearchResultSteps verifySearchResultsName(ArrayList<Offers> list, String[] sqlData){
//         for(Offers offers:list){
//             Assert.assertEquals(offers.getTitle(),sqlData[0],"Ooops,I wasn't able to detect offer");
//         }
//        return this;
//    }
//    @Step("Verify Search Results Price")
//    public SearchResultSteps verifySearchResultsPrice(ArrayList<Offers> list, String[] sqlData){
//        for(Offers offers:list){
//            Assert.assertEquals(offers.getPrice(),Double.parseDouble(sqlData[1]),"Ooops,Price doesnt match");
//        }
//        return this;
//    }
//    @Step("Verify Search Results Discount")
//    public SearchResultSteps verifySearchResultsDiscount(ArrayList<Offers> list, String[] sqlData){
//        for(Offers offers:list){
//            Assert.assertEquals(offers.getDiscount(),Integer.parseInt(sqlData[2]),"Ooops,Discount doesnt match");
//        }
//        return this;
//    }
    @Step("verify Listed Offers  ")
    public  SearchResultSteps offerCheck(){
        ArrayList<Offers> websiteData=dataCollect.collect(searchResult.getTitle(),searchResult.getPrice(),searchResult.getDiscount());
        for(Offers offers:websiteData){
            String [] sqlData=sqlLogic.getOffer(offers.getTitle(),offers.getPrice(),offers.getDiscount());
            Assert.assertEquals(offers.getTitle(),sqlData[0],"Ooops,I wasn't able to detect offer");
            Assert.assertEquals(offers.getPrice(),Double.parseDouble(sqlData[1]),"Ooops,Price doesnt match");
            Assert.assertEquals(offers.getDiscount(),Integer.parseInt(sqlData[2]),"Ooops,Discount doesnt match");
        }
        return this;
    }


}
