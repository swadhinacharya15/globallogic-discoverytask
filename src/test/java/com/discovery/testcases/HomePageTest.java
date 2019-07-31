package com.discovery.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.discovery.base.TestBase;
import com.discovery.pages.HomePage;
import com.discovery.util.TestUtil;

/**
 * @author Swadhin Acharya
 *
 */
public class HomePageTest extends TestBase {
	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();

	}

	@Test(priority = 1)
	public void discoveryTestSenario() throws InterruptedException {
		homePage.clickReference();
		homePage.getTitle();
		homePage.getDescriptions();
		homePage.clickPlusIcons();
		homePage.clickHambergerMenu();
		homePage.clickMyVideos();
		homePage.verifyTitle();
	}

	@AfterMethod
	public void tearDown() throws Throwable {
		Thread.sleep(10000);
		driver.quit();
	}

}
