package com.discovery.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.discovery.base.TestBase;

/**
 * @author Swadhin Acharya
 *
 */
public class HomePage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	ArrayList<String> descriptionList = new ArrayList<String>();
	ArrayList<String> titleList = new ArrayList<String>();
	@FindBy(xpath = "//*[@id='mod-card-1']/div/a[2]")
	@CacheLookup
	WebElement homePageVideoRef;

	@FindBy(xpath = "//*[@class=\"dscHeaderMenuShow__globalList\"]/li[4]/a")
	@CacheLookup
	WebElement myVideos;

	@FindBy(xpath = "//*[@class=\"dscHeaderMain__hideMobile\"]")
	@CacheLookup
	WebElement hambergerMenuIcon;

	@FindBy(xpath = "//ul[@class='episodeList__list']//p[2]")
	List<WebElement> allTitles;

	@FindBy(xpath = "//ul[@class='episodeList__list']//p[3]")
	List<WebElement> allDescriptions;

	@FindBy(xpath = "//div[@class='episodeVideoTile__right']/button/span/i")
	List<WebElement> allPlusIcons;

	@FindBy(xpath = "//*[@class='localStorageCarousel__wrapper']//h4[@class='overlayInner__title']")
	List<WebElement> allTitleActual;

	@FindBy(xpath = "//*[@class='localStorageCarousel__wrapper']//div[@class='overlayInner__overlayDescription description']")
	List<WebElement> allDescriptionActual;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void verifySuccessfullNavigation(String ExpextedTitle) {
	System.out.println(driver.getTitle());
	assertEquals(driver.getTitle(),ExpextedTitle);
	}

	public void clickReference() {
		homePageVideoRef.click();
	}

	public ArrayList<String> getTitle() {

		for (int i = 0; i < allTitles.size(); i++) {
			titleList.add(allTitles.get(i).getText());
			System.out.println("Title " + i + "is : " + titleList);

		}
		return titleList;
	}

	public void getDescriptions() throws InterruptedException {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"dscHeaderMain__hideMobile\"]")));
		Actions act = new Actions(driver);

		for (int i = 0; i < allDescriptions.size(); i++) {

			act.moveToElement(allDescriptions.get(i)).build().perform();
			descriptionList.add(allDescriptions.get(i).getAttribute("textContent"));
			System.out.println("Description is : " + descriptionList);

		}

	}

	public void clickPlusIcons() {
//		Actions act=new Actions(driver);
		for (int i = 0; i < allPlusIcons.size(); i++) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", allPlusIcons.get(i));

		}
		// WebElement ele =
		// driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[2]/main/section[2]/div/ul/li[1]/div[1]/div[1]/div/a/div[3]/button/span/i"));

	}

	public void gettext() {

		Actions act = new Actions(driver);
		act.moveToElement(allDescriptions.get(1));
		String s = driver.findElement(By.xpath("//ul[@class='episodeList__list']//p[3]")).getAttribute("text");
		System.out.println("value is " + s);
	}

	public void clickHambergerMenu() {
		hambergerMenuIcon.click();
	}

	public void clickMyVideos() {
		myVideos.click();
	}

	public void verifyTitle() {

		for (int i = 0; i < allTitleActual.size(); i++) {
			System.out.println("Size of all title actual is " + allTitleActual.size());
			String ExpectedTitle = allTitleActual.get(i).getAttribute("textContent").trim();
			System.out.println(ExpectedTitle);
			String ActualTitle = titleList.get(i).trim();
			System.out.println(ActualTitle);
			assertTrue(ActualTitle.equalsIgnoreCase(ExpectedTitle), "Title Mismatch");
			for (int j = 0; j < allDescriptionActual.size(); j++) {
				System.out.println("Size of all desc actual is " + allDescriptionActual.size());
				String ExpectedDesc = allDescriptionActual.get(j).getAttribute("textContent").substring(0, 20).trim();
				String ActualDesc = descriptionList.get(j).trim();
				assertTrue(ActualDesc.contains(ExpectedDesc), "Description mismatch");
			}
		}
	}

}
