package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingMyntraPage {

	
	public WebDriver driver;
	
	
	By Catagories=By.xpath("//a[contains(text(),'Women')]");
	By Type=By.xpath("//a[contains(text(),'Dress Materials')]");
	
	
	
	
	public LandingMyntraPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	public WebElement getCatagories()
	{
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(Catagories);
		act.moveToElement(ele).build().perform();
		driver.findElement(Type).click();// click on the product type
		
		return driver.findElement(Catagories);
		
	}
	
	
	
}
