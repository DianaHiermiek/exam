package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LaptopsPage extends BasePage {

    private final SelenideElement PAGE_TITLE = $x("//div[contains(@class,'page-title')]");
    private final ElementsCollection PRODUCT_DESCRIPTION_LABELS = $$x("//div[@class='prod-cart__descr']");
    private final ElementsCollection LAPTOPS_PRODUCTS = $$x("//div[@class='row js_more_content js_height-block']");
    private final SelenideElement PRODUCER_Asus = $x("//div[@class='filter__items checkbox']//a[contains(@href, 'asus')]");

    public LaptopsPage clickOnAsusProducer() {
        PRODUCER_Asus.click();
        return this;
    }

    @Override
    public LaptopsPage waitPageToLoad() {
        PAGE_TITLE.shouldBe(visible);
        return this;
    }
}
