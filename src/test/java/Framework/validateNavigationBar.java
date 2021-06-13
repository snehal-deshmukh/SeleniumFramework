package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AddProduct;
import pageObjects.LandingMyntraPage;
import pageObjects.SelectProduct;
import resources.base;

public class validateNavigationBar extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@Test

	public void validateAppNavBar() throws IOException {

		// one is inheritance
		// creating object to that class and invoke methods of it
		LandingMyntraPage landingPage = new LandingMyntraPage(driver);

		// compare the text from the browser with actual text.- Error..
		Assert.assertTrue(landingPage.getCatagories().isDisplayed());
		log.info("Catagories is displayed");
		
		// Assert.assertFalse(false);
		Assert.assertTrue(landingPage.getCatagories().isDisplayed());

		SelectProduct selectProduct = new SelectProduct(driver);
		Assert.assertTrue(selectProduct.getSortBy().isDisplayed());
		Assert.assertFalse(false);
		log.info("What's new is selected");
		Assert.assertTrue(selectProduct.getDiscount().isDisplayed());
		Assert.assertFalse(false);
		log.info("50% and above is selected");
		Assert.assertTrue(selectProduct.getBrand().isDisplayed());
		log.info("Stylee LIFESTYLE is selected");
		Assert.assertTrue(selectProduct.getProduct().isDisplayed());
		log.info("Select the product");
        log.info("Product added to bag");
		log.info("product is move to wishlist");
        System.out.println("Test completed");

	}

	@AfterTest
	public void teardown() {

		driver.quit();

	}

}
