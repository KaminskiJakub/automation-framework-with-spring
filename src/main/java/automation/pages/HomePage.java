package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Constants;
import automation.utils.Utils;


public class HomePage {
    private WebDriver driver;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Add to cart' and @data-id-product='1']")
    private WebElement addToCartFirst;

    @FindBy(xpath = "//a[@title='Add to cart' and @data-id-product='2']")
    private WebElement addToCartSecond;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private WebElement cart;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//li[contains(@class,'first-in-line first-item-of-tablet-line')]")
    private WebElement firstElement;

    @FindBy(xpath = "//li[contains(@class,'col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line')]")
    private WebElement secondElement;

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
    private WebElement username;

    @FindBy(id = "search_query_top")
    private WebElement searchBar;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(css = "#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
    private WebElement searchResults;

    public Boolean searchElement(String searchStr){
        searchBar.sendKeys(searchStr);
        searchButton.click();
        try {
            if(searchResults.isEnabled())
                return true;
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public String getUserName() {
        return username.getText();
    }

    public void addFirstElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(firstElement).build().perform();
        addToCartFirst.click();
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
        if (cart.getText().contains(Constants.CART_QUANTITY))
            System.out.println("Cart has been updated");
        else {
            System.out.println("Cart has not been updated");
            Utils.takeScreenshot();
        }

    }

    public void addSecondElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(secondElement).build().perform();
        addToCartSecond.click();
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }
}


