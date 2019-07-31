/**
 * 
 */
package step_defination;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.discovery.base.TestBase;
import com.discovery.pages.HomePage;
import com.discovery.util.TestUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

/**
 * @author Swadhin
 *
 */
@RunWith(Cucumber.class)
public class discovery extends TestBase {
	
     
     HomePage homePage;
 	TestUtil testUtil;

 	public discovery() {
 		super();
 	}

 	@After
	public void tearDown() throws Throwable {
		Thread.sleep(10000);
		//driver.quit();
	}
	@Before
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();

	}
	
	@Given("^User naviagte to URL$")
	public void user_naviagte_to_URL() throws Throwable {
		
		driver.get(prop.getProperty("url"));
		
	}

	@Given("^user successfuly navigated to home page$")
	public void user_successfuly_navigated_to_home_page() throws Throwable {
      homePage.verifySuccessfullNavigation(prop.getProperty("homePageTitle"));
	}

	@Given("^Click on video from recent epesodes$")
	public void click_on_video_from_recent_epesodes() throws Throwable {
	 homePage.clickReference();
	}

	@When("^user should add three videos to fevoroite$")
	public void user_should_add_three_videos_to_fevoroite() throws Throwable {
	homePage.getTitle();
	homePage.getDescriptions();
    homePage.clickPlusIcons();
	}

	@Then("^click on hamburger menu$")
	public void click_on_hamburger_menu() throws Throwable {
		   homePage.clickHambergerMenu();
	}

	@Then("^naviagte to My Videos$")
	public void naviagte_to_My_Videos() throws Throwable {
		  homePage.clickMyVideos();
	}

	@Then("^verfy videos should appear with correct show title and description$")
	public void verfy_videos_should_appear_with_correct_show_title_and_description() throws Throwable {
		  homePage.verifyTitle();
	}
}
