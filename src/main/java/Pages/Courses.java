package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Courses {
    private SelenideElement courses = $x("//p[text()='კურსები']"),
            sectionName = $x("//div/p[text()='კურსები']"),
            logo=$x("//a[@data-testid='logo']"),
            homePageValidation=$x("//p[@title='როგორია შენი განწყობა?']");

    public SelenideElement getCourses() {
        return courses;
    }

    public SelenideElement getSectionName() {
        return sectionName;
    }

    public SelenideElement getLogo() {
        return logo;
    }

    public SelenideElement getHomePageValidation() {
        return homePageValidation;
    }
}
