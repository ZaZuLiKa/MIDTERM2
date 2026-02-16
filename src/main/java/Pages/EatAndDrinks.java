package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class EatAndDrinks {
    private SelenideElement eatAndDrinks = $x("//p[text()='კვება']"),
            sectionName = $x("//div/p[text()='კვება']"),
    descriptionGuestString=$x("//div[@data-testid='offer-description']");

    public SelenideElement getDescriptionGuestString() {
        return descriptionGuestString;
    }

    private ElementsCollection filterPanel = $$("button[data-testid='filter-button']"),
    allPTags=$$x("//p[@type='body' and @color='dark' and @weight='regular']"),
            title = $$x("//h3");

    public ElementsCollection getFilterPanel() {
        return filterPanel;
    }

    public SelenideElement getEatAndDrinks() {
        return eatAndDrinks;
    }

    public SelenideElement getSectionName() {
        return sectionName;
    }

    public ElementsCollection getAllPTags() {
        return allPTags;
    }

    public ElementsCollection getTitle() {
        return title;
    }
}
