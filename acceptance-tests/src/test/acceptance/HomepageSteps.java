package test.acceptance;

import java.util.concurrent.TimeUnit;

import java.lang.*;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class HomepageSteps {

	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^je suis sur la page \"([^\"]*)\"$")
	public void je_suis_sur_la_homepage(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Then("^le titre doit être \"([^\"]*)\"$")
	public void le_titre_doit_être(String arg1) throws Throwable {
	    assertEquals(arg1,driver.getTitle());
	}

	@Then("^la description contient \"([^\"]*)\"$")
	public void la_description_doit_être(String arg1) throws Throwable {
		// By CSS Selector
		assertTrue(driver.findElement(By.cssSelector("meta[name='description']")).getAttribute("content").contains(arg1));
		// By XPATH, si vous préférez...
	    // assertEquals(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"), arg1);
	}
	@Then("^les titres de la page contiennent \"([^\"]*)\"$")
	public void les_titres_de_la_page_contiennent(String arg1) throws Throwable {
		Boolean title1 = driver.findElements(By.xpath("//h1[contains(text(),\""+ arg1 +"\")]")).size() > 0;
		assertThat(title1, is(true));
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^le lien du bouton \"([^\"]*)\" doit etre \"([^\"]*)\"$")
	public void le_lien_du_bouton_doit_etre(String arg1, String arg2) throws Throwable {
		String lien1 = driver.findElement(By.xpath("//a[text() = '"+ arg1 +"']")).getAttribute("href");
		assertThat(lien1, is(arg2));
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^le burger contient le bouton \"([^\"]*)\"$")
	public void le_burger_contient_le_bouton(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Boolean lien1 = driver.findElements(By.xpath("//a[text() = \""+ arg1 +"\"]")).size() > 0;
		assertThat(lien1, is(true));
	}
	@Then("^la categorie \"([^\"]*)\" contient \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void la_categorie_contient(String category, String weight, String acceleration, String battery) throws Throwable {
		Thread.sleep(1000);
		WebElement tab = driver.findElement(By.cssSelector("li[data-title = 'caractéristiques']"));
		tab.click();
		WebElement command = driver.findElement(By.xpath("//a[text() = '"+category+"']"));
		command.click();

		String ActualWeight = driver.findElement(By.xpath("//section[contains(@class, 'tds-tab-panel--active')]//span[contains(., 'Poids')]/following-sibling::span")).getAttribute("innerHTML");
		ActualWeight = ActualWeight.replace("&nbsp;", " ");
		assertThat(ActualWeight, containsString(weight));
		String ActualAcceleration = driver.findElement(By.xpath("//section[contains(@class, 'tds-tab-panel--active')]//span[contains(., 'Accélération')]/..")).getAttribute("innerHTML");
		ActualAcceleration = ActualAcceleration.replace("&nbsp;", " ");
		assertThat(ActualAcceleration, containsString(acceleration));
		String ActualBattery = driver.findElement(By.xpath("//section[contains(@class, 'tds-tab-panel--active')]//span[contains(., 'Autonomie')]/following-sibling::span")).getAttribute("innerHTML");
		ActualBattery = ActualBattery.replace("&nbsp;", " ");
		assertThat(ActualBattery, containsString(battery));
		// Write code here that turns the phrase above into concrete actions
	}

	@After
	public void afterScenario() {
		driver.quit();
	}

}
