package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectProduct {

	public WebDriver driver;

	By sortBy = By.cssSelector("div.sort-sortBy");
	By sorted = By.xpath("//label[contains(text(), \"What's New\")]");
	By discount = By.xpath("//*[@class='discount-list']");
	By dropdown = By.xpath("//label[contains(text(),'50% and above')]");
	By brandCheckbox = By.xpath("//*[@class=\"brand-list\"]");
	By checkbox = By.xpath("//label");
	By product = By.xpath("//ul[@class='results-base']/li[2]");

	public SelectProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getSortBy() {
		Actions act = new Actions(driver);
		WebElement sortByValue = driver.findElement(sortBy);// sort
		act.moveToElement(sortByValue).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sorted));
		sortByValue.findElement(sorted).click();// click on the what's new
		return driver.findElement(sorted);
		

	}

	public WebElement getDiscount() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Actions act = new Actions(driver);
		WebElement List = driver.findElement(discount);// discount checkbox
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
		// click on the discount checkbox as soon as the discount checkbox is visible
		List.findElement(dropdown).click();
		//WebElement ele2=driver.findElement(dropdown);
		//act.moveToElement(ele2).click().build().perform();
		return driver.findElement(dropdown);
	}

	public WebElement getBrand() {
		Actions act = new Actions(driver);
		WebElement brandList = driver.findElement(brandCheckbox);// brand checkbox
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
		// click on the brand checkbox as soon as the brand checkbox is visible
		//brandList.findElement(checkbox).click();
		WebElement brandList2=driver.findElement(checkbox);
		act.moveToElement(brandList2).click().build().perform();

		return driver.findElement(brandCheckbox);
	}

	public WebElement getProduct() {
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(product));// click on product
		driver.findElement(product).click();
		return driver.findElement(product);
	}

}
//