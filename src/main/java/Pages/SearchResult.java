package Pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class SearchResult {
    private ElementsCollection filterPanel = $$("button[data-testid='filter-button']"),
            title = $$x("//h3"),
            price = $$x("//p[@weight='bold' and text()='₾']"),
            discount = $$x("//p[@weight='bold' and text()='%']");

    public ElementsCollection getFilterPanel() {

        return filterPanel;
    }


    public ElementsCollection getTitle() {
        return title;
    }

    public ElementsCollection getPrice() {
        return price;
    }

    public ElementsCollection getDiscount() {
        return discount;
    }
}
