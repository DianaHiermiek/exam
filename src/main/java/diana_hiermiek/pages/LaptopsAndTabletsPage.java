package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LaptopsAndTabletsPage extends BasePage {

    private final SelenideElement LAPTOPS_BUTTON = $x("//div[@class='brand-box--column']/a[@href = 'https://avic.ua/noutbuki']");

    public LaptopsPage clickOnLaptopsButton() {
        LAPTOPS_BUTTON.click();
        return new LaptopsPage();
    }

    @Override
    public LaptopsAndTabletsPage waitPageToLoad() {
        LAPTOPS_BUTTON.shouldBe(visible);
        return this;
    }
}
