package pageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(id = "nav-link-accountList")
    WebElement signInHover;

    @FindBy(xpath = "//a[@data-nav-ref='nav_signin']")
    WebElement signInBtnStart;

    @FindBy(id = "ap_email")
    WebElement inputFieldForMobileNumber;

    @FindBy(xpath = "//input[@aria-labelledby='continue-announce']")
    WebElement continueBtn;

    @FindBy(id = "ap_password")
    WebElement inputFieldForPassword;

    @FindBy(id = "signInSubmit")
    WebElement signInBtnEnd;

    @FindBy(xpath = "//span[contains(text(),' We cannot find an account with that')]")
    WebElement msgForIncorrectInput;

    @FindBy(xpath = "//div[contains(text(),'Enter your email or mobile phone number')]")
    WebElement msgForEmptyInputField;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOnSignIn() {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(signInHover);
            actions.moveToElement(signInBtnStart).click().perform();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void enterInput(String input) {
        try {
            inputFieldForMobileNumber.clear();
            inputFieldForMobileNumber.sendKeys(input);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickOnContinue() {
        try {
            continueBtn.click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String verifyErrorMsgForInvalidNumber() {
        String msg = "";
        try {
            msg = msgForIncorrectInput.getText();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public String verifyErrorMsgForEmptyField() {
        String msg = "";
        try {
            msg = msgForEmptyInputField.getText();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public void enterPasswordAndSignIn(String pwd) {
        try {
            inputFieldForPassword.clear();
            inputFieldForPassword.sendKeys(pwd);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickOnSignInBtn() {
        try {
            signInBtnEnd.click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getHomePageUrl() {
        return driver.getTitle();
    }
}
