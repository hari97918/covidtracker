package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import locators.chartLocator;
import locators.mainPageLocator;
import pages.BaseClass;

public class mainPageStepDef extends BaseClass {
	@Given("user navigates to the covid tracker url")
	public void user_navigates_to_the_covid_tracker_url() throws IOException {
		setUp();
		//Validation for title of the page
		if (driver.getTitle().contains("InerG"))
			System.out.println("Page title contains expected Title");
		else
			System.out.println("Page title doesn't contains expected Title ");
	}

	@When("user select {string} state from dropdown")
	public void user_select_one_country_from_dropdown(String state) {
		selectDropdown(state);
		// Wait for the State from result page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mainPageLocator mainLocator = new mainPageLocator(this.driver);
		String result = mainLocator.getStateFromResultPge();
		if (result.contains(state))
			System.out.println("Page title contains expected State");
		else
			System.out.println("Page title doesn't contains expected State ");

	}


	@Then("user sees covid case details from plot chart")
	public void user_sees_covid_case_details_from_plot_chart() {
		chartLocator chartLc = new chartLocator(driver);
		Actions act = new Actions(driver);
		act.moveToElement(chartLc.getChart()).build().perform();
		List<WebElement> elements = driver.findElements(By.cssSelector("path.point"));
		for (int i = 0; i < elements.size(); i++) {
			act.moveToElement(elements.get(i)).build().perform();
			;
			String caseValue = chartLc.getTooltipValue().getText();
			System.out.println("Case Deatails from plot chart" + caseValue);
		}

	}

	@And("user closed the driver")
	public void closeDriver() {
		tearDown();
	}
}


