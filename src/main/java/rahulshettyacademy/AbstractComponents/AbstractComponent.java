package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(By findBy) throws InterruptedException {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    	Thread.sleep(2000);
    }

    public void waitForWebElementToAppear(WebElement element) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(element));
    	Thread.sleep(2000);
    }

    public void waitForElementToBeClickable(WebElement element) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(element));
    	Thread.sleep(2000);
    }

    public void waitForElementToDisappear(WebElement element) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.invisibilityOf(element));
    	Thread.sleep(2000);
    }

    public void waitForOverlayToDisappear(By overlaySelector) throws InterruptedException {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(overlaySelector));
    	Thread.sleep(2000);
    }

    public void scrollElementIntoViewCenter(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public CartPage goToCartPage() throws InterruptedException {
        scrollElementIntoViewCenter(cartHeader);
        waitForElementToBeClickable(cartHeader);
        cartHeader.click();
        return new CartPage(driver);
    }

    public OrderPage goToOrdersPage() throws InterruptedException {
        scrollElementIntoViewCenter(orderHeader);
        waitForElementToBeClickable(orderHeader);
        orderHeader.click();
        return new OrderPage(driver);
    }
}
