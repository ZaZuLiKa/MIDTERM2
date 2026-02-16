package Steps;

import Steps.Utiles.dataCollect;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.*;

import static org.aspectj.weaver.ResolvedType.isVisible;

public class Entertainment {

    Pages.Entertainment entertainment;
    dataCollect dataCollect=new dataCollect();
    public Entertainment(Page page) {
        this.entertainment = new Pages.Entertainment(page);
    }
    @Step("Open URL")
    public Entertainment openURL(String url) {
        entertainment.page.navigate(url);
        return this;
    }
    @Step("Open Entertainment")
    public Entertainment openEntertainmentPage(){
        entertainment.entertainmentMenu.first().click();
        return this;
    }
    @Step("Verify Entertainment Page Availability")
    public Entertainment verifyEntertainmentPage(){
        entertainment.sectionName.waitFor(isVisible());

        return this;
    }
    @Step("Click On Sorting ")
    public Entertainment clickSorting(){
        entertainment.filterButton
                .filter(new Locator.FilterOptions().setHasText("სორტირება"))
                .locator("visible=true")
                .click();
        return this;
    }
    @Step("Choose Sorting by Price Desc")
    public Entertainment chooseSortingByPriceDesc(){
        entertainment.allPTags.filter(new Locator.FilterOptions().setHasText("ფასი-კლებით")).locator("visible=true").click();
        return this;
    }
    @Step("verify Highest Price")
    public Entertainment verifyPrice() throws InterruptedException {
        var firstPrice=entertainment.prices.first().textContent();
        var data= dataCollect.collectPrices(entertainment);
        Assert.assertEquals(extractGelSymbol(firstPrice),dataCollect.getMax(data),"ფასები არ ემთხვევა,კლებადობით სორტირება ვერ მუშაობს როგორც საჭიროა");
        return this;
    }
    private Double extractGelSymbol(String price){
        String cleaned = price.replaceAll("[^0-9.]", "");
        return Double.parseDouble(cleaned);
    }
    private Locator.WaitForOptions isVisible() {
        return new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE);
    }
}
