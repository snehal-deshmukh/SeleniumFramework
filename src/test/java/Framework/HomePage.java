package Framework;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AddProduct;
import pageObjects.LandingMyntraPage;
import pageObjects.SelectProduct;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		

	}

	@Test

	public void basePageNavigation() throws IOException {

		// one is inheritance

		// creating object to that class and invoke methods of it
		LandingMyntraPage landingPage = new LandingMyntraPage(driver);
		landingPage.getCatagories();
		
		SelectProduct selectProduct = new SelectProduct(driver);
		selectProduct.getSortBy();
		selectProduct.getDiscount();
		selectProduct.getBrand();
		selectProduct.getProduct();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));// window handles

		AddProduct addProduct = new AddProduct(driver);
		addProduct.getaddToBag();
		addProduct.getGoToBag();
		addProduct.Wishlist();
		
	}

	@AfterTest
	public void teardown() {

		driver.quit();

	}

}
