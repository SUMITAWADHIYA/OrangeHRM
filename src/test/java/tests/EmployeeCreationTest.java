package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.AddEmployee;
import pageObject.Dashboard;
import pageObject.ViewEmployee;
import pageObject.ViewPersonalDetails;
import testComponents.BaseTest;
import testComponents.Retry;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class EmployeeCreationTest extends BaseTest {

    private String extractCredential(String text){
        return text.split(":")[1].trim();
    }

    @Test(dataProvider = "getData")
    public void CreateEmployee(HashMap<String,String>input)throws Exception{
        String userNameText = driver.findElement(By.xpath("//p[normalize-space()='Username : Admin']")).getText();
        String passwordText = driver.findElement(By.xpath("//p[normalize-space()='Password : admin123']")).getText();
        String Titleusername =extractCredential(userNameText);
        String Titlepassword = extractCredential(passwordText);
        Dashboard dashboard = landingPage.login(Titleusername,Titlepassword);
        ViewEmployee employeePage = dashboard.viewEmployeePage();
        AddEmployee addPage = employeePage.addEmployee();
        ViewPersonalDetails employeeAdded = addPage.addEmployee(input.get("fName"), input.get("lName"));


    }
    @Test(dependsOnMethods = { "CreateEmployee" }, dataProvider="getData", retryAnalyzer= Retry.class)
    public void verifyEmployeeCreation(HashMap<String, String> input) {
        Dashboard dashboard = landingPage.login("Admin", "admin123");
        ViewEmployee employeePage = dashboard.viewEmployeePage();
        Assert.assertTrue(employeePage.verifyEmployee(input.get("fName"), input.get("lName")));
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//data//EmployeeData.json");
        return new Object[][] { { data.get(0) }, { data.get(1) } };

    }

}
