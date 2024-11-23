package krishna.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import krishna.TestComponents.BaseTEST;
import krishna.TestComponents.RetryTEST;
import krishna.pageobjects.CartPage;
import krishna.pageobjects.CheckoutPage;
import krishna.pageobjects.ConfirmationPage;
import krishna.pageobjects.ProductCatalogue;

public class ErrorValidationTEST extends BaseTEST {
	@Test(groups = { "Error Handling" }, retryAnalyzer = RetryTEST.class)
	public void LoginErrorValidation() throws IOException {
		landingPage.loginApplication("jkbalu@gmail.com", "Krishn@1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws IOException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("krishnabalu@gmail.com", "Balar@ju1");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
