package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPageLocator {
	  WebDriver driver;
		
		public mainPageLocator(WebDriver driver) {
			this.driver=driver;
		}
		
		//Locator for state
		By resultState = By.xpath("//div[@class='resultCard']/h2");
		
		//Method to return the State from result Page
		public String getStateFromResultPge() {
			String resultPageState=driver.findElement(resultState).getText();
			return resultPageState;
		}
	     
	  
}
