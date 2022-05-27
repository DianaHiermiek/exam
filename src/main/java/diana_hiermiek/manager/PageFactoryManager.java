package diana_hiermiek.manager;

import diana_hiermiek.pages.AllProductsPage;
import diana_hiermiek.pages.AppleStorePage;
import diana_hiermiek.pages.ComputersPage;
import diana_hiermiek.pages.DiscountedProductsPage;
import diana_hiermiek.pages.HomePage;
import diana_hiermiek.pages.IphonePage;
import diana_hiermiek.pages.MicePage;
import diana_hiermiek.pages.SearchResultsPage;

public class PageFactoryManager {

    public HomePage getHomePage() {
        return new HomePage();
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage();
    }

    public IphonePage getIphonePage() {
        return new IphonePage();
    }

    public ComputersPage getComputersPage() {
        return new ComputersPage();
    }

    public MicePage getMicePage() {
        return new MicePage();
    }

    public AppleStorePage getAppleStorePage() {
        return new AppleStorePage();
    }

    public DiscountedProductsPage getDiscountedProductsPage() {
        return new DiscountedProductsPage();
    }

    public AllProductsPage getAllProductsPage() {
        return new AllProductsPage();
    }
}
