package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Home {
    private SelenideElement searchInput=$x("//input[@name='search']"),
                            logo=$x("//a[@data-testid='logo']");

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public SelenideElement getLogo() {
        return logo;
    }
}
