package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProduct {

	
	public WebDriver driver;
	
	By addToBag=By.xpath("//div[contains(text(),'ADD TO BAG')]");
	By goToBag =By.xpath("//span[contains(text(),'GO TO BAG')]");////span[contains(text(),'Bag')]
	//By goToBag =By.xpath("//span[contains(text(),'Bag')]");
	By wishList=By.xpath("//div[contains(text(),'Add More From Wishlist')]");
	
	
	
	
	
	public AddProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
		
		
	}


	public void getaddToBag()
	{
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(addToBag));
		driver.findElement(addToBag).click();// add to bag
		//return driver.findElement(addToBag);
	}
	
	public void getGoToBag()
	{
		WebDriverWait wait4 = new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.visibilityOfElementLocated((goToBag)));
		driver.findElement(goToBag).click();// go to cart 
		
		
	}
	
	
	
	public void Wishlist()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebDriverWait wait5 = new WebDriverWait(driver,30);
		wait5.until(ExpectedConditions.visibilityOfElementLocated((wishList)));
		driver.findElement(wishList).click();// add to wishlist 
		
	
	}
	

	
	
}
