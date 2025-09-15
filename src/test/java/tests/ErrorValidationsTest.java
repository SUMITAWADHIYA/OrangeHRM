package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

  @Test
  public void incorrectLogin() {
    landingPage.login("varun", "awadhiya");
    Assert.assertEquals("Invalid credentials", landingPage.getErrorMessage());
  }
}
