package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;
import java.util.Set;

public class ProductListPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    WebElement searchResult;

    @FindBy(xpath = "//div[@class='a-row']")
    WebElement searchNegativeResult;

    @FindBy(xpath = "(//div[@class='sg-col-inner']/div[@data-csa-c-type='item'])[1]")
    WebElement product;

    public ProductListPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifySearchResult(){
        String str = "";
        try {
            str = searchResult.getText();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return str;
    }

    public String verifySearchNegativeResult(){
        String str = "";
        try {
            str = searchNegativeResult.getText();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return str;
    }

    public void selectProduct(){
        try {
            product.click();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void navigateToProductPage(){
        String original_window = driver.getWindowHandle();
        Set<String> all_windows = driver.getWindowHandles();
        for (String str:all_windows){
            if(!Objects.equals(str, original_window)){
                driver.switchTo().window(str);
            }
        }
    }
}
