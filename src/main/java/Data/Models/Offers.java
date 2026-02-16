package Data.Models;

import com.codeborne.selenide.SelenideElement;

public class Offers {
    private String title,organizationName;
    private double price;
    private int discount;
    private SelenideElement titleLink;
    public Offers(String title,double price, int discount) {
        this.title = title;
        this.price = price;
        this.discount = discount;
    }

    public Offers(SelenideElement titleLink) {
        this.titleLink = titleLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SelenideElement getTitleLink() {
        return titleLink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
