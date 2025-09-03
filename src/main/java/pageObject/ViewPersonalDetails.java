package pageObject;

import abstractComponets.AbstractComponet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ViewPersonalDetails extends AbstractComponet {
    private WebDriver driver;

    public ViewPersonalDetails(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
