package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Condition.visible;

@Getter
public class AllProductsPage extends BasePage {
    private final ElementsCollection BUY_BUTTONS = $$x("//a[@class='prod-cart__buy']");
    private final ElementsCollection PRODUCT_DESCRIPTION_LABELS = $$x("//div[@class='prod-cart__descr']");

    @Override
    public AllProductsPage waitPageToLoad() {
        BUY_BUTTONS.get(0).shouldBe(visible);
        return this;
    }
}
