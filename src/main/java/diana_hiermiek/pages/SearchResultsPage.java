package diana_hiermiek.pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

@Getter
public class SearchResultsPage extends BasePage {

    private final ElementsCollection SEARCH_RESULTS_PRODUCT_LIST = $$x("//div[@class='prod-cart__descr']");

    @Override
    public SearchResultsPage waitPageToLoad() {
        SEARCH_RESULTS_PRODUCT_LIST.get(0).shouldBe(visible);
        return this;
    }
}
