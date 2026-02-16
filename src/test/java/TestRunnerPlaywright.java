import Steps.Entertainment;
import Steps.Configuration.ConfigurationPlaywright;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Data.Constants.URL;
import static Data.Constants.*;
import static Data.Constants.entertainmentUrl;

public class TestRunnerPlaywright extends ConfigurationPlaywright {

    Entertainment entertainment; // class field

    @BeforeClass
    public void init() {
        entertainment = new Entertainment(page); // init class field
    }

    @Test(priority = 1, description = "descendingOrderTest")
    public void descendingOrderTest() throws InterruptedException {
        entertainment
                .openURL(URL)
                    .openEntertainmentPage()
                        .verifyEntertainmentPage()
                                            .clickSorting()
                                                .chooseSortingByPriceDesc()
                                                                .verifyPrice();
    }
}
