package diana_hiermiek.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class HomePage extends BasePage {

    private final SelenideElement SEARCH_INPUT = $("#input_search");
    private final SelenideElement SEARCH_BUTTON = $x("//button[@class='button-reset search-btn']");
    private final SelenideElement SIDEBAR_ITEM = $x("//span[@class='sidebar-item']");
    private final SelenideElement APPLE_STORE_BUTTON = $x("//ul[contains(@class,'sidebar-list')]//a[contains(@href, " +
            "'apple-store')]");
    private final SelenideElement COMPUTERS_BUTTON = $x("//ul[contains(@class, 'sidebar-list')]//a[contains(@href, " +
            "'elektronika')]");
    private final SelenideElement DISCOUNTED_PRODUCTS_BUTTON = $x("//div[@class='top-links__left " +
            "flex-wrap']//a[@href='/discount']");
    private final SelenideElement LAPTOPS_AND_TABLETS_BUTTON = $x("//li[contains(@class, 'sidebar-item')]/a[@href = 'https://avic.ua/noutbuki-i-aksessuaryi']");


    public SearchResultsPage searchByKeyword(final String keyword) {
        SEARCH_INPUT.setValue(keyword).pressEnter();
        return new SearchResultsPage();
    }

    public HomePage clickOnSidebarItem() {
        SIDEBAR_ITEM.click();
        return this;
    }

    public AppleStorePage clickOnAppleStoreButton() {
        APPLE_STORE_BUTTON.click();
        return new AppleStorePage();
    }

    public ComputersPage clickOnComputersButton() {
        COMPUTERS_BUTTON.click();
        return new ComputersPage();
    }

    public DiscountedProductsPage clickOnDiscountedProductsButton() {
        DISCOUNTED_PRODUCTS_BUTTON.click();
        return new DiscountedProductsPage();
    }

    public LaptopsAndTabletsPage clickOnLaptopsAndTablesPage() {
        LAPTOPS_AND_TABLETS_BUTTON.click();
        return new LaptopsAndTabletsPage();
    }


    @Override
    public HomePage waitPageToLoad() {
        SIDEBAR_ITEM.shouldBe(visible);
        return this;
    }
}
