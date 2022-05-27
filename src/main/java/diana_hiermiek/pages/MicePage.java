package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class MicePage extends BasePage {

    private final SelenideElement PAGE_TITLE = $x("//div[@class='page-title page-title-category']");
    private final SelenideElement PRODUCER_2E = $x("//div[@class='filter__items checkbox']//a[contains(@href, '2e')]");
    private final SelenideElement FIRST_POPULAR_PRODUCER = $$x("//div[@class='filter__items checkbox']//a").get(0);
    private final ElementsCollection MICE_PRODUCTS = $$x("//div[@class='row js_more_content js_height-block']");
    private final ElementsCollection PRODUCT_DESCRIPTION_LABELS = $$x("//div[@class='prod-cart__descr']");

    public MicePage clickOn2EProducer() {
        PRODUCER_2E.click();
        return this;
    }

    public MicePage clickOnPlatinetProducer() {
        FIRST_POPULAR_PRODUCER.click();
        return this;
    }


    @Override
    public MicePage waitPageToLoad() {
        PRODUCER_2E.shouldBe(visible);
        return this;
    }
}
