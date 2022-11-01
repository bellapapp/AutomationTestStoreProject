package Tests;

import Utils.Constants;
import org.junit.Assert;
import org.junit.Test;

public class ProductsCatalogTest extends BaseTest{

    @Test
    public void changeToAnotherCurrencyAndVerifyPrices() {
        homePage.navigateToShoesSubmenu();
        Assert.assertTrue(productsCatalogPage.changeToAnotherCurrency());
        Assert.assertTrue(productsCatalogPage.verifyCurrencyPrices(productsCatalogPage.getCurrencySymbol(productsCatalogPage.getActualCurrency())));
        Assert.assertTrue(productsCatalogPage.changeToAnotherCurrency());
        Assert.assertTrue(productsCatalogPage.verifyCurrencyPrices(productsCatalogPage.getCurrencySymbol(productsCatalogPage.getActualCurrency())));
    }

    @Test
    public void changeToATargetedCurrency() {
        homePage.navigateToShoesSubmenu();
        Assert.assertTrue(productsCatalogPage.changeToATargetedCurrency(Constants.POUND));
        Assert.assertTrue(productsCatalogPage.verifyCurrencyPrices(Constants.POUND));
    }

    @Test
    public void verifySalesPrices() {
        homePage.navigateToSpecials();
        Assert.assertTrue(productsCatalogPage.verifySalePrices());
    }
}
