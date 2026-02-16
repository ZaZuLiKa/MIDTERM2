package Pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Entertainment {

    public Page page;

    public Entertainment(Page page) {
        this.page = page;
        this.arrowRight = page.locator("//img[@src='/icons/ep_arrow-right-bold.svg']");
        this.sectionName=page.locator("//div/p[text()='გართობა']");
        this.entertainmentMenu=page.locator("//p[text()='გართობა']");
        this.prices=page.locator("//p[@weight='bold' and text()='₾']");
        this.h2=page.locator("//h2");
        this.filterButton=page.locator("button[data-testid='filter-button']");
        this.allPTags=page.locator("//p[@type='body' and @color='dark' and @weight='regular']");
    }

    public Locator
            arrowRight,
            entertainmentMenu ,
            sectionName ,
            prices,
    filterButton,
    h2,
    allPTags;
}
