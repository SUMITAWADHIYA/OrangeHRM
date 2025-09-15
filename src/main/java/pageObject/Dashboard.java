package pageObject;

import abstractComponets.AbstractComponet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends AbstractComponet {
  private WebDriver driver;

  public Dashboard(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}
