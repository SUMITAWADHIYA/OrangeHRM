package pageObject;

import abstractComponets.AbstractComponet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponet {
    private WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name="username")
    private WebElement username;

    @FindBy(name ="password")
    private WebElement password;

    @FindBy(css="[type='submit']")
    private WebElement submitBtn;

    @FindBy(css=".oxd-text.oxd-text--p.orangehrm-login-forgot-header")
    private WebElement forgotPass;

    @FindBy(css=".oxd-alert.oxd-alert--error")
    private WebElement invalidCreds;

    public void goTo(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public Dashboard login(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        submitBtn.click();
        return  new Dashboard(driver);
    }
    public ResetPassword forgotPassword(){
        forgotPass.click();
        return new ResetPassword(driver);
    }
    public String getErrorMessage(){
        waitForWebElementToAppear(invalidCreds);
        return invalidCreds.getText();
    }

}
