package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;

    @FindBy(id = "buy-now-button")
    WebElement buyNowBtn;

    @FindBy(xpath = "//h1[contains(text(),'Added to Cart')]")
    WebElement msgForAddToCart;

    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement msgForBuyNow;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToaddToCart(){
        try {
            addToCartBtn.click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void navigateToCheckout(){
        try {
            buyNowBtn.click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getMsgForAddToCart(){
        String msg = "";
        try {
            msg = msgForAddToCart.getText();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }

    public String getMsgForBuyNow(){
        String msg = "";
        try {
            msg = msgForBuyNow.getText();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }

}
