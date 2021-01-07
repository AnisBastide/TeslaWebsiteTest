package test.functional;

import java.util.concurrent.TimeUnit;
import java.util.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePageTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
	    	// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
        driver.get("https://tesla.com/fr_fr/");
		assertEquals(driver.getTitle(), "Voitures électriques, énergie solaire et propre | Tesla France");
		assertEquals(driver.findElement(By.xpath("//meta[@name='description']"))
                .getAttribute("content"),"Tesla accélère la transition mondiale vers une énergie durable en proposant des véhicules électriques, des panneaux solaires et des solutions intégrées d'énergie renouvelable pour les particuliers et les entreprises.");


		//title
		Boolean title1 = driver.findElements(By.xpath("//h1[contains(text(), 'Model 3')]")).size() > 0;
        assertThat(title1, is(true));
        Boolean title2 = driver.findElements(By.xpath("//h1[contains(text(), 'Model S')]")).size() > 0;
        assertThat(title2, is(true));
        Boolean title3 = driver.findElements(By.xpath("//h1[contains(text(), 'Model X')]")).size() > 0;
        assertThat(title3, is(true));
        Boolean title4 = driver.findElements(By.xpath("//h1[contains(text(), 'Model Y')]")).size() > 0;
        assertThat(title4, is(true));
        Boolean title5 = driver.findElements(By.xpath("//h1[contains(text(), \"Systèmes d"+"'"+"énergie solaire et Powerwalls\")]")).size() > 0;
        assertThat(title5, is(true));


        String lien1 = driver.findElement(By.xpath("//a[text() = 'Model S']")).getAttribute("href");
        assertThat(lien1, is("https://www.tesla.com/fr_fr/models"));
        String lien2 = driver.findElement(By.xpath("//a[text() = 'Model 3']")).getAttribute("href");
        assertThat(lien2, is("https://www.tesla.com/fr_fr/model3"));
        String lien3 = driver.findElement(By.xpath("//a[text() = 'Model X']")).getAttribute("href");
        assertThat(lien3, is("https://www.tesla.com/fr_fr/modelx"));
        String lien4 = driver.findElement(By.xpath("//a[text() = 'Model Y']")).getAttribute("href");
        assertThat(lien4, is("https://www.tesla.com/fr_fr/modely"));
        String lien5 = driver.findElement(By.xpath("//a[text() = 'Powerwall']")).getAttribute("href");
        assertThat(lien5, is("https://www.tesla.com/fr_fr/powerwall"));
        String lien6 = driver.findElement(By.xpath("//a[text() = 'Recharger']")).getAttribute("href");
        assertThat(lien6, is("https://www.tesla.com/fr_fr/charging"));

        Boolean hamburger1 = driver.findElements(By.xpath("//a[text() = 'Véhicules disponibles']")).size() > 0;
        assertThat(hamburger1, is(true));
        Boolean hamburger2 = driver.findElements(By.xpath("//a[text() = \"Véhicules d"+"'"+"occasion\"]")).size() > 0;
        assertThat(hamburger2, is(true));
        Boolean hamburger3 = driver.findElements(By.xpath("//a[text() = 'Reprise']")).size() > 0;
        assertThat(hamburger3, is(true));
        Boolean hamburger4 = driver.findElements(By.xpath("//a[text() = 'Cybertruck']")).size() > 0;
        assertThat(hamburger4, is(true));
        Boolean hamburger5 = driver.findElements(By.xpath("//a[text() = 'Roadster']")).size() > 0;
        assertThat(hamburger5, is(true));
        Boolean hamburger6 = driver.findElements(By.xpath("//a[text() = 'Énergie']")).size() > 0;
        assertThat(hamburger6, is(true));
        Boolean hamburger7 = driver.findElements(By.xpath("//a[text() = 'Essais']")).size() > 0;
        assertThat(hamburger7, is(true));
        Boolean hamburger8 = driver.findElements(By.xpath("//a[text() = 'Flottes & Entreprises']")).size() > 0;
        assertThat(hamburger8, is(true));

		// TODO
		// To Be Completed By Coders From Coding Factory
    }

    // Test de la Story n ...
    // TODO
    // To Be Completed By Coders From Coding Factory

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
