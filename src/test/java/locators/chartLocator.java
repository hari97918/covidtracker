package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class chartLocator {
	 WebDriver driver;

		public chartLocator(WebDriver driver) {
			this.driver = driver;
		}
		
		//Locator for Chart
		By ele = By.cssSelector("rect.nsewdrag.drag");
		//Locator for toolTip
		By toolTip = By.cssSelector("svg g.hovertext text.nums");

		
		public WebElement getChart() {
			WebElement chart=driver.findElement(ele);
			return chart;
		}
		
		public WebElement getTooltipValue() {
			WebElement toolTipValue=driver.findElement(toolTip);
			return toolTipValue;
		}
		
}
