package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class DiscountedProductsPage extends BasePage {

    private final SelenideElement PAGE_TITLE = $x("//h1[contains(@class,'page-title')]");
    private final ElementsCollection TYPE_OF_PRODUCTS_LABELS = $$x("//div[@class='brand__ttl']");
    private final ElementsCollection NUMBERS_ON_TITLES = $$x("//div[@class='brand__ttl']/span");
    private final ElementsCollection SHOW_ALL_BUTTONS = $$x("//div[@class='brand__top']/a[@class='brand__more']");

    public AllProductsPage clickOnShowAllButton(int buttonIndex) {
        SHOW_ALL_BUTTONS.get(buttonIndex).click();
        return new AllProductsPage();
    }

    @Override
    public DiscountedProductsPage waitPageToLoad() {
        TYPE_OF_PRODUCTS_LABELS.get(0).shouldBe(visible);
        return this;
    }
}
