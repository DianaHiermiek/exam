package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class IphonePage extends BasePage {

    private final SelenideElement PAGE_TITLE = $x("//div[@class='page-title page-title-category']");
    private final SelenideElement FIRST_BUY_BUTTON = $x("//a[@class='prod-cart__buy']");
    private final SelenideElement ADD_TO_CART_POPUP = $("#js_cart");
    private final SelenideElement CONTINUE_SHOPPING_BUTTON = $x("//div[@class='btns-cart-holder']//a[contains(@class," +
            "'btn--orange')]");
    private final SelenideElement NUMBER_OF_PRODUCTS_CART_LABEL = $x("//div[contains(@class,'header-bottom__cart')" +
            "]//div[contains(@class,'cart_count')]");
    private final ElementsCollection PRODUCT_DESCRIPTION_LABELS = $$x("//div[@class='prod-cart__descr']");

    public IphonePage clickOnFirstBuyButton() {
        FIRST_BUY_BUTTON.click();
        return this;
    }

    public IphonePage clickOnContinueShoppingButton() {
        CONTINUE_SHOPPING_BUTTON.click();
        return this;
    }

    @Override
    public IphonePage waitPageToLoad() {
        PAGE_TITLE.shouldHave(text("iPhone"));
        return this;
    }
}
