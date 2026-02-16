package Steps.Utiles;

import Data.Models.Offers;
import Pages.EatAndDrinks;
import Pages.Entertainment;
import Pages.SearchResult;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dataCollect {
    ArrayList<Offers> websiteData=new ArrayList<>();
    ArrayList<Offers> eatAndDrink=new ArrayList<>();
    SearchResult searchResult=new SearchResult();
    EatAndDrinks eatAndDrinks=new EatAndDrinks();
    public Set<Double> collectPrices(Entertainment entertainment){
        String previousUrl;
        Set<Double> uniquePrices = new HashSet<>();
        do {
            previousUrl = entertainment.page.url();
            List<String> priceTexts = entertainment.prices.allInnerTexts();
            for (String text : priceTexts) {
                // ვასუფთავებთ ტექსტს (მაგ: "120 ₾" -> 120.0)
                String cleaned = text.replaceAll("[^0-9.]", "");
                if (!cleaned.isEmpty()) {
                    uniquePrices.add(Double.parseDouble(cleaned));
                }
            }
            entertainment.arrowRight.click();
            entertainment.page.waitForTimeout(1000);
        }while (!entertainment.page.url().equals(previousUrl));
        return uniquePrices;
    }
    public double getMax(Set<Double> priceArray ){
        return Collections.max(priceArray);
    }
    public ArrayList<Offers> collect(ElementsCollection Title,ElementsCollection Price,ElementsCollection Discount){
        for(int i=0;i<Title.size();i++){
            var title=Title.get(i).getText();
            var price=Double.parseDouble(Price.get(i).getText().replace('₾',' ').trim());
            var discount=Math.abs(Integer.parseInt(Discount.get(0).getText().replace('%',' ').trim()));
            websiteData.add(new Offers(title,price,discount));
        }
        return websiteData;
    }
    public ArrayList<Offers> collectEatAndDrinkTitles(){
        for (int i=0;i<eatAndDrinks.getTitle().size();i++){
            var titleLink=eatAndDrinks.getTitle().get(i);
            eatAndDrink.add(new Offers(titleLink));
        }
        return eatAndDrink;
    }
    public ArrayList<Offers> collectEatAndDrinkTitles(ElementsCollection Title){
        for (int i=0;i<Title.size();i++){
            var titleLink=Title.get(i);
            eatAndDrink.add(new Offers(titleLink));
        }
        return eatAndDrink;
    }
    public String extractDescription(){

        return eatAndDrinks.getDescriptionGuestString().getText();
    }
    public int[] extractGuestRange(String text) {
        Pattern pattern = Pattern.compile("(\\d+)\\s*-\\s*(\\d+)\\s*სტუმ\\S*");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            int min = Integer.parseInt(matcher.group(1));
            int max = Integer.parseInt(matcher.group(2));
           // System.out.println(min+" "+max);
            return new int[]{min, max};
        }
        return new int[]{0, 0};
    }

}
