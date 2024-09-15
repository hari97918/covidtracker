package pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static FileReader fr;
	public static ChromeOptions chromeOptions;
	
	//driver initialization
	public void setUp() throws IOException {
		if (driver == null) {
			FileReader fr = new FileReader("src/main/resources/testdata/configuration.properties");
			prop.load(fr);

		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}

	}

// select dropdown from state
	public void selectDropdown(String state) {
		Select select = new Select(driver.findElement(By.xpath("//select[@class='data-filter-input']")));
		select.selectByVisibleText(state);

	}
// Teardown method
	public void tearDown() {
		driver.quit();
	}

}
