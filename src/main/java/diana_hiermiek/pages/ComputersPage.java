package diana_hiermiek.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ComputersPage extends BasePage {

    private final SelenideElement PAGE_TITLE = $x("//h1[contains(@class,'page-title')]");
    private final SelenideElement MICE_BUTTON = $x("//div[@class='brand-box--column']/a[contains(@href, 'myishi')]");

    public MicePage clickOnMiceButton() {
        MICE_BUTTON.click();
        return new MicePage();
    }

    @Override
    public ComputersPage waitPageToLoad() {
        MICE_BUTTON.shouldBe(visible);
        return this;
    }
}
