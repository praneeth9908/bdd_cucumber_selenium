package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.HomePage;
import pageObjects.ProductListPage;
import pageObjects.ProductPage;

import java.util.logging.Logger;

public class StepDefinations extends BaseClass {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProductListPage productListPage;
    ProductPage productPage;

    @Before
    public void setUp() {
        logger = Logger.getLogger("amazon");
        PropertyConfigurator.configure("log4j.properties");
    }

    @Given("Open chrome browser and launch application")
    public void open_chrome_browser_and_launch_application() {
        logger.info("********** Launching browser **********");
        driver = new ChromeDriver();
        logger.info("********** Opening Url **********");
        while (!driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
            driver.get("https://amazon.in/");
        }
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @When("Click on signIn")
    public void click_on_sign_in() {
        logger.info("********** Started Sign in **********");
        loginPage.hoverOnSignIn();
    }

    @When("Enter mobile number {string}")
    public void enter_mobile_number(String mobileNo) {
        logger.info("********** Entering mobile number **********");
        loginPage.enterInput(mobileNo);
    }

    @When("Enter password {string}")
    public void enter_password(String pwd) {
        logger.info("********** Entering Password **********");
        loginPage.enterPasswordAndSignIn(pwd);
    }

    @When("Enter email {string}")
    public void enter_email(String email) {
        logger.info("********** Entering Email Address **********");
        loginPage.enterInput(email);
    }

    @When("click on continue")
    public void clickOnContinue() {
        loginPage.clickOnContinue();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) throws InterruptedException {
        logger.info("********** Asserting Home Page title **********");
        Thread.sleep(4000);
        Assert.assertEquals(string, driver.getTitle());
    }

    @Then("Close Driver")
    public void close_driver() {
        logger.info("********** Closing Browser **********");
        driver.quit();
    }

    @Then("Message should be {string}")
    public void message_should_be(String msg) {
        Assert.assertEquals(msg, loginPage.verifyErrorMsgForInvalidNumber());
    }

    @After
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }

    @Then("Message for empty field should be {string}")
    public void messageForEmptyFieldShouldBe(String msg) {
        Assert.assertEquals(msg, loginPage.verifyErrorMsgForEmptyField());
    }

    @When("click on sign in Btn")
    public void clickOnSignInBtn() {
        loginPage.clickOnSignInBtn();
    }

    @When("Search with valid keyword {string}")
    public void search_with_valid_keyword(String keyword) {
        homePage = new HomePage(driver);
        homePage.enterKeywordInSearchBox(keyword);
    }

    @When("Click on search icon")
    public void clickOnSearchIcon() {
        homePage.clickSearchIcon();
    }

    @Then("Message in product list page should be {string}")
    public void messageInProductListPageShouldBeBooks(String msg) {
        productListPage = new ProductListPage(driver);
        System.out.println(productListPage.verifySearchResult());
        Assert.assertTrue(productListPage.verifySearchResult().contains(msg));
    }

    @When("Search with invalid keyword {string}")
    public void searchWithInvalidKeyword(String keyword) {
        homePage = new HomePage(driver);
        homePage.enterKeywordInSearchBox(keyword);
    }

    @Then("Message in product list page for invalid should be {string}")
    public void messageInProductListPageForInvalidShouldBe(String msg) {
        productListPage = new ProductListPage(driver);
        Assert.assertTrue(productListPage.verifySearchNegativeResult().contains(msg));
    }

    @When("click one product")
    public void clickOneProduct() {
        productListPage.selectProduct();
    }

    @When("Navigate to product page")
    public void navigateToProductPage() {
        productListPage.navigateToProductPage();
        productPage = new ProductPage(driver);
    }

    @When("Click on add to cart")
    public void clickOnAddToCart() {
        productPage.navigateToaddToCart();
    }

    @When("Click on Buy now")
    public void clickOnBuyNow() {
        productPage.navigateToCheckout();
    }

    @Then("Message for Add To Cart should be {string}")
    public void messageForAddToCartShouldBe(String msg) {
        Assert.assertEquals(msg, productPage.getMsgForAddToCart());
    }

    @Then("Message for Buy Now should be {string}")
    public void messageForBuyNowShouldBe(String msg) {
        Assert.assertEquals(msg, productPage.getMsgForBuyNow());
    }

    @Given("uoubonj")
    public void uoubonj() {
        System.out.println("rhebkjdm");
    }
    @Then("njiomy")
    public void njiomy() {
        System.out.println("fbjnd");
    }

}
