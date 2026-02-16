package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Sport {
    private SelenideElement sectionName = $x("//div/p[text()='სპორტი ']"),
            sport = $x("//p[text()='სპორტი ']"),
            priceFilter=$x("//p[contains(text(),'ფასი')]");
    private ElementsCollection filterPanel = $$("button[data-testid='filter-button']"),
            allPTags=$$x("//p[@type='body' and @color='dark']"),
            price = $$x("//p[@weight='bold' and text()='₾']");
    public SelenideElement getSectionName() {
        return sectionName;
    }

    public ElementsCollection getPrice() {
        return price;
    }

    public ElementsCollection getAllPTags() {
        return allPTags;
    }

    public SelenideElement getSport() {
        return sport;
    }

    public ElementsCollection getFilterPanel() {
        return filterPanel;
    }

    public SelenideElement getPriceFilter() {
        return priceFilter;
    }
}
