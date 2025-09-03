package abstractComponets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.ViewEmployee;

import java.time.Duration;

public class AbstractComponet {
    WebDriver driver;

    public AbstractComponet(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css ="[href='/web/index.php/pim/viewPimModule']")
    private WebElement pim;

    public void waitForWebElementToAppear(By byElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }
    public void waitForWebElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public ViewEmployee viewEmployeePage() {
        pim.click();
        return new ViewEmployee(driver);
    }
}

