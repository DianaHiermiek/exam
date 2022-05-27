package diana_hiermiek.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Getter
public abstract class BasePage implements Page {

    private final SelenideElement LOGO_BUTTON = $x("//div[@class='header-bottom__logo']");

    public HomePage clickOnLogoButton() {
        LOGO_BUTTON.click();
        return new HomePage();
    }

    public void returnToPreviousPage() {
        executeJavaScript("window.history.go(-1)");
    }
}
