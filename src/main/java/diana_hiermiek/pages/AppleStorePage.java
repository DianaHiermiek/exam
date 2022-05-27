package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AppleStorePage extends BasePage {

    private final ElementsCollection BRAND_BOXES = $$x("//div[@class='height brand-box']");
    private final SelenideElement IPHONE_BUTTON = $x("//div[@class='brand-box__title']/a[contains(@href,'iphone')]");

    public IphonePage clickOnIphoneButton() {
        IPHONE_BUTTON.click();
        return new IphonePage();
    }

    @Override
    public AppleStorePage waitPageToLoad() {
        BRAND_BOXES.get(0).shouldBe(visible);
        return this;
    }
}
