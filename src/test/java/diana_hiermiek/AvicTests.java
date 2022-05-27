package diana_hiermiek;

import com.codeborne.selenide.SelenideElement;
import diana_hiermiek.manager.PageFactoryManager;
import diana_hiermiek.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AvicTests {

    private final Logger LOGGER = Logger.getLogger("AvicTests");
    private final String HOME_PAGE_URL = "https://avic.ua/";

    private HomePage homePage;


    @BeforeEach
    public void openHomePage() {
        LOGGER.info("Open home page");
        open(HOME_PAGE_URL);
        homePage = new PageFactoryManager().getHomePage();
    }


    @Test
    public void checkTheMostPopularProducerOfMouse() {
        LOGGER.info("Test 'checkTheMostPopularProducerOfMouse' started");
        MicePage micePage = homePage.clickOnSidebarItem()
                .clickOnComputersButton()
                .clickOnMiceButton()
                .waitPageToLoad();
        SelenideElement firstPopularProducer = micePage.getFIRST_POPULAR_PRODUCER();
        firstPopularProducer.scrollIntoView(true);
        LOGGER.info("Computers page opened");
        LOGGER.info("Mice page opened");
        LOGGER.info("First popular producer chosen");
        LOGGER.info("Assert that every product has the first popular producer name in the description");
        for (SelenideElement selenideElement :
                micePage.clickOnPlatinetProducer()
                        .waitPageToLoad()
                        .getMICE_PRODUCTS()) {
            selenideElement.shouldHave(text(firstPopularProducer.text()));
        }
        LOGGER.info("Test 'checkProducerOfMouse' complete");
    }

    @Test
    public void checkTheMostPopularProducerOfLaptops() {
        LOGGER.info("Test 'checkTheMostPopularProducerOfLaptops' started");
        LaptopsPage laptopsPage = homePage.clickOnLaptopsAndTablesPage()
                .waitPageToLoad()
                .clickOnLaptopsButton()
                .waitPageToLoad();
        laptopsPage.getPRODUCER_Asus().scrollIntoView(true);
        LOGGER.info("Computers page opened");
        LOGGER.info("Laptops page opened");
        LOGGER.info("'Asus' producer chosen");
        LOGGER.info("Assert that every product has 'Asus' in the description");
        for (SelenideElement selenideElement :
                laptopsPage.clickOnAsusProducer()
                        .waitPageToLoad()
                        .getLAPTOPS_PRODUCTS()) {
            selenideElement.shouldHave(text("ASUS"));
        }
        LOGGER.info("Test 'checkProducerOfMouse' complete");
    }

    /*@Test
    public void checkThatUrlContainsSearchWord() {
        LOGGER.info("Test 'checkThatUrlContainsSearchWord' started");
        LOGGER.info("Input 'iPhone 11' into the search bar");
        homePage.searchByKeyword("iPhone 11");
        LOGGER.info("Assert that current url contains 'query=iPhone+11'");
        assert (url()).contains("query=iPhone+11");
        LOGGER.info("Test 'checkThatUrlContainsSearchWord' complete");
    }

    @Test
    public void checkElementsAmountOnSearchPage() {
        LOGGER.info("Test 'checkElementsAmountOnSearchPage' started");
        LOGGER.info("Input 'iPhone 11' into the search bar");
        LOGGER.info("Search results page opened");
        LOGGER.info("Assert that there are 12 elements on the page");
        assertEquals(12, homePage.searchByKeyword("iPhone 11").getSEARCH_RESULTS_PRODUCT_LIST().size());
        LOGGER.info("Test 'checkElementsAmountOnSearchPage' complete");
    }

    @Test
    public void checkThatSearchResultsContainsSearchWord() {
        LOGGER.info("Test 'checkThatSearchResultsContainsSearchWord' started");
        LOGGER.info("Input 'iPhone 11' into the search bar");
        LOGGER.info("Search results page opened");
        LOGGER.info("Assert that every product has 'iPhone 11' in the description");
        for (SelenideElement selenideElement : homePage.searchByKeyword("iPhone 11").getSEARCH_RESULTS_PRODUCT_LIST()) {
            $(selenideElement).shouldHave(text("iPhone 11"));
        }
        LOGGER.info("Test 'checkThatSearchResultsContainsSearchWord' complete");
    }

    @Test
    public void checkAddToCart() {
        LOGGER.info("Test 'checkAddToCart' started");
        IphonePage iphonePage = homePage.clickOnSidebarItem()
                .clickOnAppleStoreButton()
                .clickOnIphoneButton()
                .waitPageToLoad()
                .clickOnFirstBuyButton();
        LOGGER.info("iPhone page opened");
        LOGGER.info("Click on first buy button");
        LOGGER.info("Add to cart popup opened");
        iphonePage.getADD_TO_CART_POPUP().shouldBe(visible);
        LOGGER.info("Click on 'Continue shopping' button");
        LOGGER.info("Assert that cart label with number of products has text '1'");
        iphonePage.clickOnContinueShoppingButton()
                .getNUMBER_OF_PRODUCTS_CART_LABEL()
                .shouldHave(text("1"));
        LOGGER.info("Test 'checkAddToCart' complete");
    }

    @Test
    public void checkReturnToMainPageByClickingOnLogo() {
        LOGGER.info("Test 'checkReturnToMainPageByClickingOnLogo' started");
        homePage.clickOnAppleStoreButton()
                .waitPageToLoad()
                .clickOnLogoButton()
                .waitPageToLoad();
        LOGGER.info("Apple Store page opened");
        LOGGER.info("Click on Logo button");
        LOGGER.info("Assert that home page is opened");
        assert (url()).equals(HOME_PAGE_URL);
        LOGGER.info("Test 'checkReturnToMainPageByClickingOnLogo' complete");
    }

    @Test
    public void checkDiscountedProducts() {
        LOGGER.info("Test 'checkDiscountedProducts' started");
        LOGGER.info("Open discounted products page");
        DiscountedProductsPage discountedProductsPage = homePage.clickOnDiscountedProductsButton()
                .waitPageToLoad();
        LOGGER.info("Discounted products page opened");
        for (int i = 0; i < 5; i++) {
            discountedProductsPage.getTYPE_OF_PRODUCTS_LABELS().get(i).scrollIntoView(true);
            String typeOfProducts = discountedProductsPage.getTYPE_OF_PRODUCTS_LABELS().get(i).text();
            LOGGER.info("Consider product type '" + typeOfProducts + "'");
            int numberOnTitle =
                    Integer.parseInt(discountedProductsPage.getNUMBERS_ON_TITLES().get(i).text().substring(1,
                            discountedProductsPage.getNUMBERS_ON_TITLES().get(i).text().length() - 1));
            LOGGER.info("Number of products on title is " + numberOnTitle);
            LOGGER.info("Open 'Show all' page");
            AllProductsPage allProductsPage = discountedProductsPage.clickOnShowAllButton(i);
            allProductsPage.waitPageToLoad();
            LOGGER.info("'Show all' page opened");
            int realNumberOfProducts = 0;
            if ((typeOfProducts.contains("Смартфоны")
                    || typeOfProducts.contains("Наушники")
                    || typeOfProducts.contains("Смартфони")
                    || typeOfProducts.contains("Навушники"))
                    && !typeOfProducts.contains("Apple")) {
                for (int j = 0; j < allProductsPage.getBUY_BUTTONS().size(); j++)
                    if (!allProductsPage.getPRODUCT_DESCRIPTION_LABELS().get(j).text().contains("Apple"))
                        realNumberOfProducts++;
            } else realNumberOfProducts = allProductsPage.getBUY_BUTTONS().size();
            LOGGER.info("Assert that the number of products on the page equals the number on the title");
            assertEquals(numberOnTitle, realNumberOfProducts);
            LOGGER.info("Return to previous page");
            allProductsPage.returnToPreviousPage();
            discountedProductsPage.waitPageToLoad();
            LOGGER.info("All products page opened");
        }
        LOGGER.info("Test 'checkDiscountedProducts' complete");
    }

    @Test
    public void checkLaptopsCategoryTitle() {
        assert (homePage.clickOnLaptopsAndTablesPage()
                .waitPageToLoad()
                .clickOnLaptopsButton()
                .waitPageToLoad()
                .getPAGE_TITLE()
                .text()
                .contains("Ноутбуки"));
    }

    @Test
    public void checkIphoneCategoryTitle() {
        assert (homePage.clickOnSidebarItem()
                .clickOnAppleStoreButton()
                .waitPageToLoad()
                .clickOnIphoneButton()
                .waitPageToLoad()
                .getPAGE_TITLE()
                .text()
                .contains("iPhone"));
    }

    @Test
    public void checkMiceCategoryTitle() {
        assert (homePage.clickOnSidebarItem()
                .clickOnComputersButton()
                .clickOnMiceButton()
                .waitPageToLoad()
                .getPAGE_TITLE()
                .text()
                .contains("Мыши"));
    }

    @Test
    public void checkDiscountedProductsCategoryTitle() {
        assert (homePage.clickOnDiscountedProductsButton()
                .waitPageToLoad()
                .getPAGE_TITLE()
                .text()
                .contains("Уцененные товары!"));
    }

    @Test
    public void checkDescriptionForLaptops() {
        ElementsCollection productDescriptionLabels =
                homePage.clickOnLaptopsAndTablesPage()
                        .waitPageToLoad()
                        .clickOnLaptopsButton()
                        .waitPageToLoad()
                        .getPRODUCT_DESCRIPTION_LABELS();
        for (SelenideElement element :
                productDescriptionLabels) {
            assert (element.text().contains("Ноутбук"));
        }
    }

    @Test
    public void checkDescriptionForIPhones() {
        ElementsCollection productDescriptionLabels =
                homePage.clickOnSidebarItem()
                        .clickOnAppleStoreButton()
                        .waitPageToLoad()
                        .clickOnIphoneButton()
                        .waitPageToLoad()
                        .getPRODUCT_DESCRIPTION_LABELS();
        for (SelenideElement element :
                productDescriptionLabels) {
            assert (element.text().contains("iPhone"));
        }
    }

    @Test
    public void checkDescriptionForMice() {
        ElementsCollection productDescriptionLabels =
                homePage.clickOnSidebarItem()
                        .clickOnComputersButton()
                        .clickOnMiceButton()
                        .waitPageToLoad()
                        .getPRODUCT_DESCRIPTION_LABELS();
        for (SelenideElement element :
                productDescriptionLabels) {
            assert (element.text().contains("Мыш"));
        }
    }

    @Test
    public void checkComputersCategoryTitle() {
        assert (homePage.clickOnComputersButton()
                .waitPageToLoad()
                .getPAGE_TITLE()
                .text()
                .contains("Компьютеры"));
    }*/

    /*@Test
    public void checkProducerOfMouse() {
        LOGGER.info("Test 'checkProducerOfMouse' started");
        MicePage micePage = homePage.clickOnSidebarItem()
                .clickOnComputersButton()
                .clickOnMiceButton()
                .waitPageToLoad();
        micePage.getPRODUCER_2E().scrollIntoView(true);
        LOGGER.info("Computers page opened");
        LOGGER.info("Mice page opened");
        LOGGER.info("'2E' producer chosen");
        LOGGER.info("Assert that every product has '2E' in the description");
        for (SelenideElement selenideElement :
                micePage.clickOn2EProducer()
                        .waitPageToLoad()
                        .getMICE_PRODUCTS()) {
            selenideElement.shouldHave(text("2E"));
        }
        LOGGER.info("Test 'checkProducerOfMouse' complete");
    }*/

}
