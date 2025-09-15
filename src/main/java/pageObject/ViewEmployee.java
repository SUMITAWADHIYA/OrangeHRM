package pageObject;

import abstractComponets.AbstractComponet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewEmployee extends AbstractComponet {
  private WebDriver driver;

  public ViewEmployee(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']/parent::button")
  private WebElement add;

  @FindBy(
      xpath =
          "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
  private WebElement searchField;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement search;

  public AddEmployee addEmployee() {
    add.click();
    return new AddEmployee(driver);
  }

  public boolean verifyEmployee(String fName, String lName) {
    waitForWebElementToAppear(searchField);
    searchField.sendKeys(fName + " " + lName);
    search.click();
    List<WebElement> firstNames =
        driver.findElements(
            By.cssSelector(
                ".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable div:nth-child(3)"));
    List<WebElement> lastNames =
        driver.findElements(
            By.cssSelector(
                ".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable div:nth-child(4)"));

    Boolean matchFName =
        firstNames.stream().anyMatch(first -> first.getText().equalsIgnoreCase(fName));
    Boolean matchLName =
        lastNames.stream().anyMatch(last -> last.getText().equalsIgnoreCase(lName));

    if (matchFName == true && matchLName == true) {
      return true;
    } else {
      return false;
    }
  }
}
